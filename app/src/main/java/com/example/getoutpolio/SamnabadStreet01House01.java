package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SamnabadStreet01House01 extends AppCompatActivity {
    CheckBox objChild_1, objChild_2, objChild_3 ;
    Button objbtn;
    TextView objoutput;
    ArrayList<String>results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnabad_street01_house01);
        objChild_1=findViewById(R.id.checkbox_child_1_id);
        objChild_2 = findViewById(R.id.checkbox_child_2_id);
        objChild_3=findViewById(R.id.checkbox_child_3_id);
        objbtn = findViewById(R.id.btn_submit);
        objoutput=findViewById(R.id.output_id);
        results= new ArrayList<>();
        objChild_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objChild_1.isChecked()){
                    objChild_1.setTextColor(getResources().getColor(R.color.colorAccent2));
                }
                else
                {
                    objChild_1.setTextColor(getResources().getColor(R.color.colorblack));
                }

            }
        });
        objChild_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (objChild_2.isChecked()){
                    objChild_2.setTextColor(getResources().getColor(R.color.colorAccent2));
                }
                else
                {
                    objChild_2.setTextColor(getResources().getColor(R.color.colorblack));
                }
            }
        });
        objChild_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objChild_3.isChecked()){
                    objChild_3.setTextColor(getResources().getColor(R.color.colorAccent2));

                }
                else
                {
                    objChild_3.setTextColor(getResources().getColor(R.color.colorblack));
                }
            }
        });

      objbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              objoutput.setText(" ");
              if (objChild_1.isChecked()){
                  objoutput.append("\n Muhammad Aleem");
              }
              if (objChild_2.isChecked()){
                  objoutput.append("\n Muhammad Taha");
              }
              if (objChild_3.isChecked()){
                  objoutput.append("\n Mustafa");
              }
          }
      });



    }
}
