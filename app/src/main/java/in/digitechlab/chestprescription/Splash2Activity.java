package in.digitechlab.chestprescription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        Thread t = new Thread(){

            public void run(){

                try{
                    sleep(2000);
                }catch (InterruptedException e){
                }
                finally{
                    Intent intent = new Intent(Splash2Activity.this, TreatmentActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        t.start();

    }

}