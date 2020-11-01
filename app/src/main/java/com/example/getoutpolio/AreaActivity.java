package com.example.getoutpolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AreaActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private FirebaseFirestore firebaseFirestore;
//    AreaAdapter objAreaAdapter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
       setTitle("Area");
        textView=findViewById(R.id.area_name_id);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AreaActivity.this,SamnabadBlocksUserActivity.class);
                startActivity(intent);
            }
        });





//        connectXML();
//    }
//    private void connectXML(){
//        try
//        {
//
//        recyclerView=findViewById(R.id.area_RV_id);
//        firebaseFirestore=FirebaseFirestore.getInstance();
//        getValueFromFirebaseFirstore();
//
//        }catch (Exception e){
//            Toast.makeText(this, "connectXML"+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//    private void getValueFromFirebaseFirstore()
//    {
//        try
//        {
//            Query query=firebaseFirestore.collection("areas");
//            FirestoreRecyclerOptions<AreaModel> options;
//            options=new FirestoreRecyclerOptions.Builder<AreaModel>().setQuery(query,AreaModel.class)
//                    .build();
//         objAreaAdapter=new AreaAdapter(options,this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(objAreaAdapter);
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(this, "getValueFromFirebaseFirstore"+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        objAreaAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        objAreaAdapter.stopListening();
//    }
//
//    @Override
//    public void onAreaClick(int position) {
//        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
//
//            final Intent intent;
//            switch (position){
//                case 0:
//
//                    gotoSamanabadStreets();
////                    intent =  new Intent(this.getApplicationContext(), SamnabadHouses.class);
//                    Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
//
//                    break;
//
//                case 1:
////                    intent =  new Intent(this.getApplicationContext(), LoginActivity.class);
//                    Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
//                    gotoJohartown();
//                    break;
//                default:
////                    intent =  new Intent(context, DefaultActivity.class);
//                    break;
//            }
////            context.startActivity(intent);
//
//    }
//
//    public void gotoSamanabadStreets(){
//        Intent intent =new Intent(AreaActivity.this,SamnabadStreetNo.class);
//        startActivity(intent);
//
//    }
//    public void gotoJohartown(){
//        Intent intent =new Intent(AreaActivity.this,LoginActivity.class);
//        startActivity(intent);
//
 }
}
