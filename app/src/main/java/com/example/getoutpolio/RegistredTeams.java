package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistredTeams extends AppCompatActivity {
    private Button searchBtn,editBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registred_teams);
        searchBtn=findViewById(R.id.search_team_Btn_id);
        editBtn=findViewById(R.id.edit_team_Btn_id);
        deleteBtn=findViewById(R.id.delete_team_Btn_id);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredTeams.this,SearchTeamInfoActivity.class);
                startActivity(intent);
            }
        });
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredTeams.this,EditTeamInfoActivity.class);
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistredTeams.this,DeleteTeamInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
