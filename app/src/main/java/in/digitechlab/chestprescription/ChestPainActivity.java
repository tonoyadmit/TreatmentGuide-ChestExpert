package in.digitechlab.chestprescription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import in.digitechlab.chestprescription.data.ChestDBManager;

public class ChestPainActivity extends AppCompatActivity {

    private LinearLayout Lout1;
    private RadioButton rb1, rb2, rb3, rb21, rb22, rb23, rb24, rb25, rb26;
    private ChestDBManager CDM;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_chest_pain);

        MobileAds.initialize(this, getResources().getString(R.string.ad_app_id));

        CDM =  ChestDBManager.getInstance(this);

        rb3 = findViewById(R.id.cc24);

        rb1 = findViewById(R.id.cc6);
        rb2 = findViewById(R.id.cc7);
        rb21 = findViewById(R.id.cp1);
        rb22 = findViewById(R.id.cp2);
        rb23 = findViewById(R.id.cp3);
        rb24 = findViewById(R.id.cp4);
        rb25 = findViewById(R.id.cp5);
        rb26 = findViewById(R.id.cp6);

        Lout1 = findViewById(R.id.CPLayout);

        if (CDM.CheckComplaintStatus(6)==1){
            rb1.setChecked(true);
        }

        else if (CDM.CheckComplaintStatus(7)==1){
            rb2.setChecked(true);
        }

        else {
            rb3.setChecked(true);
        }

        if (CDM.CheckComplaintStatus(21)==1){
            rb21.setChecked(true);
        }

        else if (CDM.CheckComplaintStatus(22)==1){
            rb22.setChecked(true);
        }

        else if (CDM.CheckComplaintStatus(23)==1){
            rb23.setChecked(true);
        }

        else if (CDM.CheckComplaintStatus(24)==1){
            rb24.setChecked(true);
        }

        else if (CDM.CheckComplaintStatus(25)==1){
            rb25.setChecked(true);
        }

        else {
            rb26.setChecked(true);
        }

        if(rb3.isChecked()==true){
            Lout1.setVisibility(View.GONE);
        }else{
            Lout1.setVisibility(View.VISIBLE);
        }

        adView = findViewById(R.id.adView4);
        final AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView != null) adView.destroy();
    }

    public void SubmitCp(View view) {
        Intent intent = new Intent(this, ComplaintSummaryActivity.class);
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
    }

    public void onRadioCPClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.cc6:
                if (checked){
                    CDM.UpdateSingleComplaint(6);
                    CDM.ResetSingleComplaint(7);
                    CDM.ResetSingleComplaint(30);
                    Lout1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cc7:
                if (checked){
                    CDM.UpdateSingleComplaint(7);
                    CDM.ResetSingleComplaint(6);
                    CDM.ResetSingleComplaint(30);
                    Lout1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cc24:
                if (checked){
                    CDM.UpdateSingleComplaint(30);
                    CDM.ResetSingleComplaint(6);
                    CDM.ResetSingleComplaint(7);
                    Lout1.setVisibility(View.GONE);
                }
                break;
            case R.id.cp1:
                if (checked){
                    CDM.UpdateSingleComplaint(21);
                    CDM.ResetSingleComplaint(22);
                    CDM.ResetSingleComplaint(23);
                    CDM.ResetSingleComplaint(24);
                    CDM.ResetSingleComplaint(25);
                    CDM.ResetSingleComplaint(26);
                }
                break;
            case R.id.cp2:
                if (checked){
                    CDM.UpdateSingleComplaint(22);
                    CDM.ResetSingleComplaint(21);
                    CDM.ResetSingleComplaint(23);
                    CDM.ResetSingleComplaint(24);
                    CDM.ResetSingleComplaint(25);
                    CDM.ResetSingleComplaint(26);
                }
                break;
            case R.id.cp3:
                if (checked){
                    CDM.UpdateSingleComplaint(23);
                    CDM.ResetSingleComplaint(22);
                    CDM.ResetSingleComplaint(21);
                    CDM.ResetSingleComplaint(24);
                    CDM.ResetSingleComplaint(25);
                    CDM.ResetSingleComplaint(26);
                }
                break;
            case R.id.cp4:
                if (checked){
                    CDM.UpdateSingleComplaint(24);
                    CDM.ResetSingleComplaint(22);
                    CDM.ResetSingleComplaint(23);
                    CDM.ResetSingleComplaint(21);
                    CDM.ResetSingleComplaint(25);
                    CDM.ResetSingleComplaint(26);
                }
                break;
            case R.id.cp5:
                if (checked){
                    CDM.UpdateSingleComplaint(25);
                    CDM.ResetSingleComplaint(22);
                    CDM.ResetSingleComplaint(23);
                    CDM.ResetSingleComplaint(24);
                    CDM.ResetSingleComplaint(21);
                    CDM.ResetSingleComplaint(26);
                }
                break;
            case R.id.cp6:
                if (checked){
                    CDM.UpdateSingleComplaint(26);
                    CDM.ResetSingleComplaint(22);
                    CDM.ResetSingleComplaint(23);
                    CDM.ResetSingleComplaint(24);
                    CDM.ResetSingleComplaint(25);
                    CDM.ResetSingleComplaint(21);
                }
                break;
        }
    }
}
