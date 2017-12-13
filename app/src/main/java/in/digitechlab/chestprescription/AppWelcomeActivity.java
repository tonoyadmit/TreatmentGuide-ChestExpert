package in.digitechlab.chestprescription;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppWelcomeActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Slide 1
        addSlide(AppIntroFragment.newInstance("WELCOME To CHEST EXPERT", "Chest Expert Application is produced by expert Medical consultant presenting more than 25 diseases related to Heart, Lungs, Muscle, Nerve & Joint and Oesophagus. It includes disease identification by practical query, diagnosis generation followed by treatment & investigation suggestions.   ",
                R.drawable.chest1, getResources().getColor(R.color.slide1)));

        //Slide 2
        addSlide(AppIntroFragment.newInstance("Chronic Obstructive Pulmonary Disease (COPD)", "COPD is a chronic inflammatory lung disease that causes obstructed airflow from the lungs. COPD term is used to describe progressive lung diseases including emphysema, chronic bronchitis, refractory (non-reversible) asthma, and some forms of bronchiectasis.",
                R.drawable.copd1, getResources().getColor(R.color.slide2)));

        //Slide 3
        addSlide(AppIntroFragment.newInstance("BRONCHITIS\n(Acute and Chronic)", "Bronchitis is inflammation of the bronchi (large and medium-sized airways) in the lungs. Symptoms include coughing up mucus, wheezing, shortness of breath, and chest discomfort. Bronchitis is divided into two types: acute and chronic. Acute bronchitis is also known as a chest cold.",
                R.drawable.bronchitis1, getResources().getColor(R.color.slide3)));

        //Slide 4
        addSlide(AppIntroFragment.newInstance("Congestive Heart Failure (CHF)", "Heart failure (HF), often referred to as congestive heart failure (CHF), occurs when the heart is unable to pump sufficiently to maintain blood flow to meet the body's needs.",
                R.drawable.heart1, getResources().getColor(R.color.slide4)));

        //Slide 5
        addSlide(AppIntroFragment.newInstance("CHECK YOUR CHEST HEALTH", "Chest Expert application will point out your general problems, breathing or repiratory distress, type of the chest pain and then expertly determine your health condition and suggest treatment & investigations if required.\n\nLet's have a expert helth check by chest expert!!",
                R.drawable.chest5, getResources().getColor(R.color.slide5)));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        //finish();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("map_link", mapLink);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}

