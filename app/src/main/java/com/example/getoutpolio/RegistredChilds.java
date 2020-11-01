package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistredChilds extends AppCompatActivity {
    private Button searchBtn,editBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registred_childs);

        searchBtn=findViewById(R.id.search_reg_Btn_id);
        editBtn=findViewById(R.id.edit_reg_Btn_id);
        deleteBtn=findViewById(R.id.delete_reg_Btn_id);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredChilds.this,SearchChildsInfoActivity.class);
                startActivity(intent);
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredChilds.this,EditChildsActivity.class);
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredChilds.this,DeleteChildsInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
