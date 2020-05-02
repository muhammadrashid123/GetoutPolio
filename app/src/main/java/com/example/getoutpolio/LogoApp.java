package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

public class LogoApp extends AppCompatActivity {
 // private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_app);
       // dialog=new Dialog(this);
      //  dialog.setContentView(R.layout.please_wait);
       // dialog.show();
        //dialog.dismiss();
        /****** Create Thread that will sleep for 5 seconds****/
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(3*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }
}
