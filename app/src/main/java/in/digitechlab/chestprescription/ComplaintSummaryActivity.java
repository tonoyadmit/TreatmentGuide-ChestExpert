package in.digitechlab.chestprescription;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.tappx.sdk.android.TappxBanner;

import java.util.ArrayList;

import in.digitechlab.chestprescription.data.ChestDBManager;

public class ComplaintSummaryActivity extends AppCompatActivity {

    private TextView tvs1, tvs2, tvs3, tvs4;
    private AdView adView;
    private TappxBanner banner;
    private ViewGroup bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_summary);

        tvs1 = findViewById(R.id.tv101);
        tvs2 = findViewById(R.id.tv102);
        tvs3 = findViewById(R.id.tv103);
        tvs4 = findViewById(R.id.tv104);

        UpdateSummary();

        adView = findViewById(R.id.adView5);
        final AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        bannerContainer = (ViewGroup) findViewById(R.id.tappx_banner5);
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
        if (adView != null) adView.destroy();
    }

    public void SubmitRE(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                //intent.putExtra("map_link", mapLink);
        startActivity(intent);
    }

    public void SubmitGF(View view) {
        Intent intent = new Intent(this, Splash2Activity.class);
        ChestDBManager.getInstance(this).ResetAllDiagnosis();
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
    }

    private void UpdateSummary() {

        String nm = MainActivity.getDefaultString("k1",this);
        String occ = MainActivity.getDefaultString("k2",this);
        String age = MainActivity.getDefaultString("k3",this);
        String smk = MainActivity.getDefaultString("k4",this);
        String pls = MainActivity.getDefaultString("k5",this);

        ArrayList cc_list = ChestDBManager.getInstance(this).ComplaintByCategory(1);
        ArrayList rs_list = ChestDBManager.getInstance(this).ComplaintByCategory(2);
        ArrayList cp_list = ChestDBManager.getInstance(this).ComplaintByCategory(3);

        String s1 = "", s2 = "", s3 = "";

        String s4 = "PATIENT'S NAME: "+nm+"\n"+
                    "OCCUPATION: "+occ+"\n"+
                    "AGE: "+age+"\n"+
                    "SMOKING HABIT: "+smk+"\n"+
                    "PULSE RATE: "+pls;

        if(cc_list.size() > 0) {

            for(int i=0;i<cc_list.size();i++)
            {
                if(i==cc_list.size()-1) {
                    s1 = s1 + cc_list.get(i).toString();
                }else{
                    s1 = s1 + cc_list.get(i).toString() + ", ";
                }
            }

        } else {

            s1 = "No General Complaints Selected";

        }


        if(rs_list.size() > 0) {

            for(int i=0;i<rs_list.size();i++)
            {
                if(i==rs_list.size()-1) {
                    s2 = s2 + rs_list.get(i).toString();
                }else{
                    s2 = s2 + rs_list.get(i).toString() + ", ";
                }
            }
        } else {

            s2 = "No Respiratory/Breathing Complaint Selected";

        }


        if(cp_list.size() > 0){
            for(int i=0;i<cp_list.size();i++)
            {
                if(i==cp_list.size()-1) {
                    s3 = s3 + cp_list.get(i).toString();
                }else{
                    s3 = s3 + cp_list.get(i).toString() + "\n";
                }
            }

        } else {

            s3 = "No Chest Pain Complaint Selected";
        }


        tvs1.setText("PERSONAL INFORMATION: \n\n"+s4);
        tvs2.setText("GENERAL COMPLAINTS: \n\n"+s1);
        tvs3.setText("RESPIRATORY OR BREATHING COMPLAINTS: \n\n"+s2);
        tvs4.setText("CHEST PAIN COMPLAINTS: \n\n"+s3);

    }

}
