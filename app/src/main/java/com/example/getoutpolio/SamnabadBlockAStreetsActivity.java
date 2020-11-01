package com.example.getoutpolio;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SamnabadBlockAStreetsActivity extends AppCompatActivity implements RecyclerViewAreaClicKInterface {
    private FirebaseFirestore firebaseFirestore;
    private static final String COLLECTION_NAME="streets";
    private RecyclerView recyclerView;
    AreaAdapter objAreaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnabad_block_a_streets);
        setTitle("Block A Streets");
        connectXML();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        firebaseFirestore=FirebaseFirestore.getInstance();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();

                final AlertDialog.Builder alert=new AlertDialog.Builder(SamnabadBlockAStreetsActivity.this);
                View mview=getLayoutInflater().inflate(R.layout.streets_dialog_box,null);

                alert.setView(mview);
                final AlertDialog alertDialog=alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
                final EditText enterStreets=(EditText) mview.findViewById(R.id.enter_street_dialog_id);
                Button btn_submint=(Button) mview.findViewById(R.id.btn_dialog_street_submit);
                Button btn_cancel=(Button) mview.findViewById(R.id.btn_dialog_street_cancel);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_submint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            if (!enterStreets.getText().toString().isEmpty())
                            {
                                Map<String, Object> objectMap = new HashMap();
                                objectMap.put("name", enterStreets.getText().toString());
                                firebaseFirestore.collection("areas").document("Samnabad Town").collection("blocks").document("block A").collection(COLLECTION_NAME)
                                        .document(enterStreets.getText().toString())
                                        .set(objectMap)
                                        .addOnSuccessListener(

                                                new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        enterStreets.setText("");

                                                        Toast.makeText(SamnabadBlockAStreetsActivity.this, "Add Blocks", Toast.LENGTH_SHORT).show();
                                                        alertDialog.dismiss();
                                                    }
                                                }
                                        )
                                        .addOnFailureListener(
                                                new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {

                                                        Toast.makeText(SamnabadBlockAStreetsActivity.this, "Your do not send" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                            }
                            else if(enterStreets.getText().toString().isEmpty())
                            {
                                Toast.makeText(SamnabadBlockAStreetsActivity.this, "please enter Name", Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e){
                            Toast.makeText(SamnabadBlockAStreetsActivity.this, "addAreaToFirebaseFirestore"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }


                });
            }
        });


    }
    private void connectXML(){
        try
        {

            recyclerView=findViewById(R.id.samnabad_block_A_streets_RV_id);
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
            Query query=firebaseFirestore.collection("areas").document("Samnabad Town").collection("blocks").document("block A").collection(COLLECTION_NAME);
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
            case 4:

                gotoSamanabadStreets();
//                    intent =  new Intent(this.getApplicationContext(), SamnabadHouses.class);
                Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();

                break;

            case 1:
//                    intent =  new Intent(this.getApplicationContext(), LoginActivity.class);
                Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
                gotoJohartown();
                break;
            default:
//                    intent =  new Intent(context, DefaultActivity.class);
                break;
        }
//            context.startActivity(intent);

    }

    public void gotoSamanabadStreets(){
        Intent intent =new Intent(SamnabadBlockAStreetsActivity.this,SamnabadBlockAStreet01HousesActivity.class);
        startActivity(intent);

    }
    public void gotoJohartown(){
     Intent intent =new Intent(SamnabadBlockAStreetsActivity.this,SamnabadBlockAStreet01HousesActivity.class);
        startActivity(intent);

    }
}

