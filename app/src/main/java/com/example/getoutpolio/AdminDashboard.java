package com.example.getoutpolio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AdminDashboard extends AppCompatActivity {
private ImageView objAddArea , objAddTeeam,objAddTask,objLocation,objCampaignDate ,objRecords;
private ImageView objLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_dashboard);
        objAddArea=findViewById(R.id.areas_add_id);
        objAddTeeam=findViewById(R.id.team_add_id);
        objAddTask=findViewById(R.id.task_add_id);
        objLocation=findViewById(R.id.maps_add_id);
        objCampaignDate=findViewById(R.id.date_add_id);
        objRecords=findViewById(R.id.record_id);
        objLogout=findViewById(R.id.admin_logout_id);
        objLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final AlertDialog.Builder alert=new AlertDialog.Builder(AdminDashboard.this);
//                View mview=getLayoutInflater().inflate(R.layout.admin,null);
//
//                alert.setView(mview);
//                final AlertDialog alertDialog=alert.create();
//                alertDialog.setCanceledOnTouchOutside(false);
//                alertDialog.show();
//                final EditText enterTeam=(EditText) mview.findViewById(R.id.enter_team_dialog_id);
//                Button btn_submint=(Button) mview.findViewById(R.id.btn_dialog_team_submit);
//                Button btn_cancel=(Button) mview.findViewById(R.id.btn_dialog_team_cancel);
//                btn_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        alertDialog.dismiss();
                    //}
                //});
            }
        });

        objAddArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this, AddAreasActivity.class);
                startActivity(intent);
            }
        });
        objAddTeeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this,TeamAddByAdminActivity.class);
                startActivity(intent);
            }
        });
        objAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this,AssignTaskActivity.class);
                startActivity(intent);
            }
        });
        objLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        objCampaignDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this,CampaignDatesActivity.class);
                startActivity(intent);
            }
        });
        objRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboard.this,RecordsByAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
