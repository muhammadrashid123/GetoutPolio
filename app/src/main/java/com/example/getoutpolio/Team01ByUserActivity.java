package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Team01ByUserActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team01_by_user);

        setTitle("Team");
        textView=findViewById(R.id.team_name_id);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Team01ByUserActivity.this,Team01MembersByUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
