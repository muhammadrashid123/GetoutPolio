package com.example.getoutpolio;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SamnbadBlockAStreet01House02Activity extends AppCompatActivity implements RecyclerViewAreaClicKInterface {

    private FirebaseFirestore firebaseFirestore;
    private static final String COLLECTION_NAME="childs";
    private RecyclerView recyclerView;
    AreaAdapter objAreaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnbad_block_a_street01_house02);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle("House 02");
        connectXML();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        firebaseFirestore=FirebaseFirestore.getInstance();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
                Intent intent = new Intent(SamnbadBlockAStreet01House02Activity.this, AdminRegistrationChildsActivity.class);
                startActivity(intent);
            }
        });
    }
        private void connectXML(){
            try
            {

                recyclerView=findViewById(R.id.samnabad_block_A_street_1_h02_id);
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
                Query query=firebaseFirestore.collection("areas").document("Samnabad Town").collection("blocks").document("block A").collection("streets").document("Street#01").collection("houses").document("House#02").collection(COLLECTION_NAME);
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
            Intent intent =new Intent(SamnbadBlockAStreet01House02Activity.this,RegistredAreasActivity.class);
            startActivity(intent);

        }
        public void gotoJohartownHouse(){
            Intent intent =new Intent(SamnbadBlockAStreet01House02Activity.this,RegistredAreasActivity.class);
            startActivity(intent);

        }
    }
