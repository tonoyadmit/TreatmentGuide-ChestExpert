package in.digitechlab.chestprescription;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.tappx.sdk.android.TappxBanner;

import in.digitechlab.chestprescription.data.ChestDBManager;

public class RespiratoryActivity extends AppCompatActivity {

    private CheckBox c3, c8, c12, c13, c14, c19, c27, c28, c29;

    private ChestDBManager CDM;

    private TappxBanner banner;
    private ViewGroup bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_respiratory);

        CDM =  ChestDBManager.getInstance(this);

        c3 = findViewById(R.id.cc3);
        c8 = findViewById(R.id.cc8);
        c12 = findViewById(R.id.cc12);
        c13 = findViewById(R.id.cc13);
        c14 = findViewById(R.id.cc14);
        c19 = findViewById(R.id.cc19);
        c27 = findViewById(R.id.cc21);
        c28 = findViewById(R.id.cc22);
        c29 = findViewById(R.id.cc23);

        if (CDM.CheckComplaintStatus(3)==1){
            c3.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(8)==1){
            c8.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(12)==1){
            c12.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(13)==1){
            c13.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(14)==1){
            c14.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(19)==1){
            c19.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(27)==1){
            c27.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(28)==1){
            c28.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(29)==1){
            c29.setChecked(true);
        }

        bannerContainer = (ViewGroup) findViewById(R.id.tappx_banner3);
        Context context = this;
        banner = new TappxBanner(context, getResources().getString(R.string.tappx_key));        //Create the banner
        banner.setAdSize(TappxBanner.AdSize.SMART_BANNER);
        bannerContainer.addView(banner);                              //add the banner to the view
        banner.loadAd();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (banner != null) banner.destroy();
    }


    public void SubmitRc(View view) {
        Intent intent = new Intent(this, ChestPainActivity.class);
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
    }

    public void onRespCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cc3:
                if (checked){
                    CDM.UpdateSingleComplaint(3);
                    c28.setChecked(false);
                    CDM.ResetSingleComplaint(28);
                }else{
                    CDM.ResetSingleComplaint(3);
                }
                break;
            case R.id.cc8:
                if (checked){
                    CDM.UpdateSingleComplaint(8);
                }else{
                    CDM.ResetSingleComplaint(8);
                }
                break;
            case R.id.cc12:
                if (checked){
                    CDM.UpdateSingleComplaint(12);
                    c14.setChecked(false);
                    CDM.ResetSingleComplaint(14);
                    c19.setChecked(false);
                    CDM.ResetSingleComplaint(19);
                    c27.setChecked(false);
                    CDM.ResetSingleComplaint(27);
                }else{
                    CDM.ResetSingleComplaint(12);
                }
                break;
            case R.id.cc13:
                if (checked){
                    CDM.UpdateSingleComplaint(13);
                }else{
                    CDM.ResetSingleComplaint(13);
                }
                break;
            case R.id.cc14:
                if (checked){
                    CDM.UpdateSingleComplaint(14);
                    c12.setChecked(false);
                    CDM.ResetSingleComplaint(12);
                }else{
                    CDM.ResetSingleComplaint(14);
                }
                break;
            case R.id.cc19:
                if (checked){
                    CDM.UpdateSingleComplaint(19);
                    c12.setChecked(false);
                    CDM.ResetSingleComplaint(12);
                }else{
                    CDM.ResetSingleComplaint(19);
                }
                break;
            case R.id.cc21:
                if (checked){
                    CDM.UpdateSingleComplaint(27);
                    c12.setChecked(false);
                    CDM.ResetSingleComplaint(12);
                }else{
                    CDM.ResetSingleComplaint(27);
                }
                break;
            case R.id.cc22:
                if (checked){
                    CDM.UpdateSingleComplaint(28);
                    c3.setChecked(false);
                    CDM.ResetSingleComplaint(3);
                }else{
                    CDM.ResetSingleComplaint(28);
                }
                break;
            case R.id.cc23:
                if (checked){
                    CDM.UpdateSingleComplaint(29);
                    c3.setChecked(false);
                    c8.setChecked(false);
                    c12.setChecked(false);
                    c13.setChecked(false);
                    c14.setChecked(false);
                    c19.setChecked(false);
                    c27.setChecked(false);
                    c28.setChecked(false);
                    CDM.ResetAllRespitory();
                }else{
                    CDM.ResetSingleComplaint(29);
                }
                break;
        }
    }
}
