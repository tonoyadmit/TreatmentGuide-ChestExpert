package in.digitechlab.chestprescription;

import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;

import java.util.ArrayList;

import in.digitechlab.chestprescription.data.ChestDBManager;

public class TreatmentActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabPagerAdapter tabPagerAdapter;
    private DiagnosisFragment f1;
    private InvestigationFragment f2;
    private TreatmentFragment f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_treatment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.mainTab);
        viewPager = (ViewPager) findViewById(R.id.mainPager);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tt4).setIcon(R.drawable.ic_diagnosis));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tt5).setIcon(R.drawable.ic_investigation));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tt6).setIcon(R.drawable.ic_treatment));


        tabPagerAdapter  = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount() );

        viewPager.setAdapter(tabPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        UpdateDiagnosisStatus();

    }

    public class TabPagerAdapter extends FragmentStatePagerAdapter {

        int tabCount;

        public TabPagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new DiagnosisFragment();
                case 1:
                    return new InvestigationFragment();
                case 2:
                    return new TreatmentFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }


    private void UpdateDiagnosisStatus() {

        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;

        String occ = MainActivity.getDefaultString("k2",this);
        String age = MainActivity.getDefaultString("k3",this);
        String smk = MainActivity.getDefaultString("k4",this);
        String pls = MainActivity.getDefaultString("k5",this);

        if(occ.equals(getResources().getString(R.string.p10)))p1 = 1;
        if(age.equals(getResources().getString(R.string.p12)))p2 = 1;
        if(smk.equals(getResources().getString(R.string.p51)))p3 = 1;
        if(pls.equals(getResources().getString(R.string.p91))||pls.equals(getResources().getString(R.string.p93)))p4 = 1;


        int cc1 = ChestDBManager.getInstance(this).CheckComplaintStatus(1);
        int cc2 = ChestDBManager.getInstance(this).CheckComplaintStatus(2);
        int cc3 = ChestDBManager.getInstance(this).CheckComplaintStatus(3);
        int cc4 = ChestDBManager.getInstance(this).CheckComplaintStatus(4);
        int cc5 = ChestDBManager.getInstance(this).CheckComplaintStatus(5);
        int cc6 = ChestDBManager.getInstance(this).CheckComplaintStatus(6);
        int cc7 = ChestDBManager.getInstance(this).CheckComplaintStatus(7);
        int cc8 = ChestDBManager.getInstance(this).CheckComplaintStatus(8);
        int cc9 = ChestDBManager.getInstance(this).CheckComplaintStatus(9);
        int cc10 = ChestDBManager.getInstance(this).CheckComplaintStatus(10);
        int cc11 = ChestDBManager.getInstance(this).CheckComplaintStatus(11);
        int cc12 = ChestDBManager.getInstance(this).CheckComplaintStatus(12);
        int cc13 = ChestDBManager.getInstance(this).CheckComplaintStatus(13);
        int cc14 = ChestDBManager.getInstance(this).CheckComplaintStatus(14);
        int cc15 = ChestDBManager.getInstance(this).CheckComplaintStatus(15);
        int cc16 = ChestDBManager.getInstance(this).CheckComplaintStatus(16);
        int cc17 = ChestDBManager.getInstance(this).CheckComplaintStatus(17);
        int cc18 = ChestDBManager.getInstance(this).CheckComplaintStatus(18);
        int cc19 = ChestDBManager.getInstance(this).CheckComplaintStatus(19);
        int cc20 = ChestDBManager.getInstance(this).CheckComplaintStatus(20);
        int cc21 = ChestDBManager.getInstance(this).CheckComplaintStatus(21);
        int cc22 = ChestDBManager.getInstance(this).CheckComplaintStatus(22);
        int cc23 = ChestDBManager.getInstance(this).CheckComplaintStatus(23);
        int cc24 = ChestDBManager.getInstance(this).CheckComplaintStatus(24);
        int cc25 = ChestDBManager.getInstance(this).CheckComplaintStatus(25);
        int cc27 = ChestDBManager.getInstance(this).CheckComplaintStatus(27);
        int cc28 = ChestDBManager.getInstance(this).CheckComplaintStatus(28);

        if(cc21==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(1);
        }

        if(cc22==1 && (cc4==1 || cc5==1)){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(2);
        }

        if(cc3==1 && cc8==1 && cc23==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(4);
        }

        if(cc6==1 && cc24==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(6);
        }

        if(cc2==1 && cc10==1 && p3==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(7);
        }

        if(cc1==1 && cc2==1 && (cc6==1 || cc7==1) && cc23==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(8);
        }

        if(cc1==1 && cc2==1 && cc9==1 && cc15==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(9);
        }

        if(cc14==1 && (cc15==1 || cc16==1) && p2==1 && p3==1 && cc27==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(10);
            //Toast.makeText(getApplicationContext(), "COPD DETECTED!!", Toast.LENGTH_LONG).show();
        }

        if(cc25==1 && cc12==1 && cc13==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(11);
        }

        if(cc14==1 && p1==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(12);
        }

        if(p4==1 && cc11==1 & cc20==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(13);
        }

        if(cc17==1 && cc28==1 && cc6==1 && cc24==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(14);
        }

        if(cc17==1 && cc28==1 && cc14==1 && cc18==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(15);
        }

        if(cc17==1 && cc28==1 && cc14==1 && cc19==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(16);
        }

        if(cc17==1 && cc28==1 && cc14==1 && cc18==1 && cc19==1){
            ChestDBManager.getInstance(this).UpdateSingleDiagnosis(17);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

/*                Intent intent = new Intent(RestMapActivity.this, RestaurantDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
