package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class AssignTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
       String[] teams = { " ", "Team#01", "Team#02", "Team#03", "Team#04" };
    String[] area = { " ", "Samnabad Town", "joher town", "walton"};
    private Button AssignBtn;
    //private FirebaseFirestore firebaseFirestore;
   // private static final String COLLECTION_NAME="houses";
//private Spinner spinner;
   // private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_task);
        AssignBtn=findViewById(R.id.task_btn_id);
        AssignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AssignTaskActivity.this, "Assign Task successfully", Toast.LENGTH_SHORT).show();
            }
        });
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Teams");
//        spinner = (Spinner)findViewById(R.id.spinner);
//
//        Query query = mDatabase.orderByChild("title");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                final List<String> titleList = new ArrayList<String>();
//                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
//                    String titlename = dataSnapshot1.child("title").getValue(String.class);
//                    titleList.add(titlename);
//                }
//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AssignTaskActivity.this, android.R.layout.simple_spinner_item, titleList);
//                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner.setAdapter(arrayAdapter);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(AssignTaskActivity.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        //firebaseFirestore=FirebaseFirestore.getInstance();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teams);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);





        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }





}