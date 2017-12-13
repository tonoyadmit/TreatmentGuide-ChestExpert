package in.digitechlab.chestprescription;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.tappx.sdk.android.TappxBanner;

import in.digitechlab.chestprescription.data.ChestDBManager;

public class MainActivity extends AppCompatActivity {

    private ChestDBManager chestDBManager;
    private RadioGroup rg1, rg2, rg3, rg4;
    private RadioButton rb1, rb2, rb3, rb4;
    private EditText et1;
    private String occ, age, pls, smk;
    private int occ_id, age_id, pls_id, smk_id;
    private LinearLayout llv;
    private AdView adView;
    private TappxBanner banner;
    private ViewGroup bannerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getResources().getString(R.string.ad_app_id));

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        rg1 = findViewById(R.id.RadioPp1);
        rg2 = findViewById(R.id.RadioPp2);
        rg3 = findViewById(R.id.RadioPp3);
        rg4 = findViewById(R.id.RadioPp4);

        //et1 = findViewById(R.id.PName);

        if(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT == getIntent().getFlags()){

            //nm = getDefaultString("k1", this);
            occ_id = getDefaultInt("k21", this);
            age_id = getDefaultInt("k31", this);
            smk_id = getDefaultInt("k41", this);
            pls_id = getDefaultInt("k51", this);

            //et1.setText(nm);
            rg1.check(occ_id);
            rg2.check(age_id);
            rg3.check(smk_id);
            rg4.check(pls_id);

        }else {

            chestDBManager = ChestDBManager.getInstance(this);
            chestDBManager.ResetAllComplaints();
            chestDBManager.ResetAllDiagnosis();

        }

        adView = findViewById(R.id.adView1);
        final AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        bannerContainer = (ViewGroup) findViewById(R.id.tappx_banner1);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void SubmitPp(View view) {

        // get selected radio button from radioGroup
        occ_id = rg1.getCheckedRadioButtonId();
        age_id = rg2.getCheckedRadioButtonId();
        smk_id = rg3.getCheckedRadioButtonId();
        pls_id = rg4.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rb1 = (RadioButton) findViewById(occ_id);
        rb2 = (RadioButton) findViewById(age_id);
        rb3 = (RadioButton) findViewById(smk_id);
        rb4 = (RadioButton) findViewById(pls_id);

        occ = rb1.getText().toString();
        age = rb2.getText().toString();
        smk = rb3.getText().toString();
        pls = rb4.getText().toString();
        //nm = et1.getText().toString();

/*
        if(nm.trim().equals(""))
        {

            et1.setError( "Patient name is required!" );

            //et1.setHint("please enter username");
        } else {
*/

            //Toast.makeText(getApplicationContext(), pls_id+"", Toast.LENGTH_LONG).show();

            //setDefaultString("k1",nm,this);
            setDefaultString("k2",occ,this);
            setDefaultString("k3",age,this);
            setDefaultString("k4",smk,this);
            setDefaultString("k5",pls,this);
            setDefaultInt("k21",occ_id,this);
            setDefaultInt("k31",age_id,this);
            setDefaultInt("k41",smk_id,this);
            setDefaultInt("k51",pls_id,this);

            Intent intent = new Intent(this, ComplaintActivity.class);
            //intent.putExtra("map_link", mapLink);
            startActivity(intent);
       // }
    }

    public static void setDefaultString(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setDefaultInt(String key, int value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }


    public static String getDefaultString(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public static int getDefaultInt(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }
}
