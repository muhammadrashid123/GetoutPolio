package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class SamnabadStreet01Houses extends AppCompatActivity {
       public TextView objHouse_1,objHouse_2;
       public  View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnabad_street01_houses);
        objHouse_1=findViewById(R.id.SamnabadHouse_1_id);
        objHouse_2=findViewById(R.id.SamnabadHouse_2_id);


        }

    public void gotoHouse01(View view) {
        Intent intent=new Intent(SamnabadStreet01Houses.this,SamnabadStreet01House01.class);
        startActivity(intent);
    }
}

