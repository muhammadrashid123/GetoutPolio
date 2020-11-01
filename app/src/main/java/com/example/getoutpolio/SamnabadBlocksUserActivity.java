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

public class SamnabadBlocksUserActivity extends AppCompatActivity implements RecyclerViewAreaClicKInterface {
    private FirebaseFirestore firebaseFirestore;
    private static final String COLLECTION_NAME="blocks";
    private RecyclerView recyclerView;
    AreaAdapter objAreaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samnabad_blocks_user);
        connectXML();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }
        private void connectXML(){
            try
            {

                recyclerView=findViewById(R.id.samnabad_blocks_RV_id);
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
                Query query=firebaseFirestore.collection("areas").document("Samnabad Town").collection("blocks");
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
                case 3:

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
            Intent intent =new Intent(SamnabadBlocksUserActivity.this,SamnabadStreetNo.class);
            startActivity(intent);

        }
        public void gotoJohartown(){
            Intent intent =new Intent(SamnabadBlocksUserActivity.this,SamnabadStreetNo.class);
            startActivity(intent);

        }
    }

