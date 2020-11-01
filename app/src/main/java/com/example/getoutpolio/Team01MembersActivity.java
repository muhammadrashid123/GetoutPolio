package com.example.getoutpolio;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

public class Team01MembersActivity extends AppCompatActivity implements RecyclerViewAreaClicKInterface {
    private FirebaseFirestore firebaseFirestore;
    private static final String COLLECTION_NAME="members";
    private RecyclerView recyclerView;
    AreaAdapter objAreaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team01_members);
        Toolbar toolbar = findViewById(R.id.toolbar);
        connectXML();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        firebaseFirestore=FirebaseFirestore.getInstance();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
                Intent intent = new Intent(Team01MembersActivity.this, TeamRegistration.class);
                startActivity(intent);
            }
        });
    }
    private void connectXML(){
        try
        {

            recyclerView=findViewById(R.id.team_01_members_RV_id);
            firebaseFirestore=FirebaseFirestore.getInstance();
            getValueFromFirebaseFirstore();

        }catch (Exception e){
            Toast.makeText(this, "connectXML"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void getValueFromFirebaseFirstore()
    {
        try
        {
            Query query=firebaseFirestore.collection("Teams").
                    document("Team#01").collection(COLLECTION_NAME);
            FirestoreRecyclerOptions<AreaModel> options;
            options=new FirestoreRecyclerOptions.Builder<AreaModel>().setQuery(query,AreaModel.class)
                    .build();
            objAreaAdapter=new AreaAdapter(options,this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(objAreaAdapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "getValueFromFirebaseFirstore"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        objAreaAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        objAreaAdapter.stopListening();
    }


    @Override
    public void onAreaClick(int position) {

        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

        final Intent intent;
        switch (position){
            case 0:

                gotoSamanabadHouse();
//                    intent =  new Intent(this.getApplicationContext(), SamnabadHouses.class);
                Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();

                break;

            case 1:
//                    intent =  new Intent(this.getApplicationContext(), LoginActivity.class);
                Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
                gotoJohartownHouse();
                break;
            default:
//                    intent =  new Intent(context, DefaultActivity.class);
                break;
        }
//            context.startActivity(intent);

    }

    public void gotoSamanabadHouse(){
        Intent intent =new Intent(Team01MembersActivity.this,RegistredTeams.class);
        startActivity(intent);

    }
    public void gotoJohartownHouse(){
        Intent intent =new Intent(Team01MembersActivity.this,RegistredTeams.class);
        startActivity(intent);

    }
}
