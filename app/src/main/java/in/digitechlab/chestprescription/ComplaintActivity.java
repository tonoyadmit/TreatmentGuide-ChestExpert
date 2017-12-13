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

public class ComplaintActivity extends AppCompatActivity {

    private CheckBox c1, c2, c4, c5, c9, c10, c11, c15, c16, c17, c18, c20;

    private ChestDBManager CDM;
    private TappxBanner banner;
    private ViewGroup bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_complaint);

        CDM =  ChestDBManager.getInstance(this);

        c1 = findViewById(R.id.cc1);
        c2 = findViewById(R.id.cc2);
        c4 = findViewById(R.id.cc4);
        c5 = findViewById(R.id.cc5);
        c9 = findViewById(R.id.cc9);
        c10 = findViewById(R.id.cc10);
        c11 = findViewById(R.id.cc11);
        c15 = findViewById(R.id.cc15);
        c16 = findViewById(R.id.cc16);
        c17 = findViewById(R.id.cc17);
        c18 = findViewById(R.id.cc18);
        c20 = findViewById(R.id.cc20);

        if (CDM.CheckComplaintStatus(1)==1){
            c1.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(2)==1){
            c2.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(4)==1){
            c4.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(5)==1){
            c5.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(9)==1){
            c9.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(10)==1){
            c10.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(11)==1){
            c11.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(15)==1){
            c15.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(16)==1){
            c16.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(17)==1){
            c17.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(18)==1){
            c18.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(20)==1){
            c20.setChecked(true);
        }

        bannerContainer = (ViewGroup) findViewById(R.id.tappx_banner2);
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

    public void SubmitCc(View view) {
        Intent intent = new Intent(this, RespiratoryActivity.class);
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
    }

    public void onComplaintCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cc1:
                if (checked){
                    CDM.UpdateSingleComplaint(1);
                }else{
                    CDM.ResetSingleComplaint(1);
                }
                break;
            case R.id.cc2:
                if (checked){
                    CDM.UpdateSingleComplaint(2);
                }else{
                    CDM.ResetSingleComplaint(2);
                }
                break;
            case R.id.cc4:
                if (checked){
                    CDM.UpdateSingleComplaint(4);
                }else{
                    CDM.ResetSingleComplaint(4);
                }
                break;
            case R.id.cc5:
                if (checked){
                    CDM.UpdateSingleComplaint(5);
                }else{
                    CDM.ResetSingleComplaint(5);
                }
                break;
            case R.id.cc9:
                if (checked){
                    CDM.UpdateSingleComplaint(9);
                }else{
                    CDM.ResetSingleComplaint(9);
                }
                break;
            case R.id.cc10:
                if (checked){
                    CDM.UpdateSingleComplaint(10);
                }else{
                    CDM.ResetSingleComplaint(10);
                }
                break;
            case R.id.cc11:
                if (checked){
                    CDM.UpdateSingleComplaint(11);
                }else{
                    CDM.ResetSingleComplaint(11);
                }
                break;
            case R.id.cc15:
                if (checked){
                    CDM.UpdateSingleComplaint(15);
                    c16.setChecked(false);
                    CDM.ResetSingleComplaint(16);
                }else{
                    CDM.ResetSingleComplaint(15);
                }
                break;
            case R.id.cc16:
                if (checked){
                    CDM.UpdateSingleComplaint(16);
                    c15.setChecked(false);
                    CDM.ResetSingleComplaint(15);
                }else{
                    CDM.ResetSingleComplaint(16);
                }
                break;
            case R.id.cc17:
                if (checked){
                    CDM.UpdateSingleComplaint(17);
                }else{
                    CDM.ResetSingleComplaint(17);
                }
                break;
            case R.id.cc18:
                if (checked){
                    CDM.UpdateSingleComplaint(18);
                }else{
                    CDM.ResetSingleComplaint(18);
                }
                break;
            case R.id.cc20:
                if (checked){
                    CDM.UpdateSingleComplaint(20);
                }else{
                    CDM.ResetSingleComplaint(20);
                }
                break;
        }
    }
}
