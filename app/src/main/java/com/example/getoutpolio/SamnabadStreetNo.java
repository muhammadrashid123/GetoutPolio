package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SamnabadStreetNo extends AppCompatActivity {
    private TextView objStreet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnabad_street_no);
        objStreet1=findViewById(R.id.SamnabadStreet_1_id);
        objStreet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SamnabadStreetNo.this,SamnabadStreet01Houses.class);
                startActivity(intent);
            }
        });
    }
}
