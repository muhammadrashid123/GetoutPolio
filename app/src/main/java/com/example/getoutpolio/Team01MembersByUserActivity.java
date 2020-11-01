package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Team01MembersByUserActivity extends AppCompatActivity implements RecyclerViewAreaClicKInterface {
    private FirebaseFirestore firebaseFirestore;
    private static final String COLLECTION_NAME="members";
    private RecyclerView recyclerView;
    AreaAdapter objAreaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team01_members_by_user);
        setTitle("Team members");
        connectXML();
        firebaseFirestore=FirebaseFirestore.getInstance();
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

    }
}
