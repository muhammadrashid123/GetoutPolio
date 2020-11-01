package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AreasActivity extends AppCompatActivity {
    //    private FirebaseFirestore firebaseFirestore;
////    private RecyclerView mFireStoreList;
////    private FirestoreRecyclerAdapter adapter;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int carid = dataSnapshot.child("areas").child("bcVpiTTvbGTGoHJt8rJa").getValue(Integer.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        };
        //mPostReference.addValueEventListener(postListener);

    }
}
//        firebaseFirestore= FirebaseFirestore.getInstance();
//        mFireStoreList=findViewById(R.id.firestore_areas);
//
//        Query query=firebaseFirestore.collection("areas");
//
//        FirestoreRecyclerOptions<AreaModel> options= new FirestoreRecyclerOptions.Builder<AreaModel>()
//                .setQuery(query, AreaModel.class)
//                .build();
//
//        adapter= new FirestoreRecyclerAdapter<AreaModel,ProductsViewHolder>(options) {
//            @NonNull
//            @Override
//            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.areas_list_item,parent,false);
//                return new ProductsViewHolder(view);
//            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull AreaModel model) {
//                 holder.name.setText(model.getName());
//
//
//            }
//        };
//
//        mFireStoreList.setHasFixedSize(true);
//        mFireStoreList.setLayoutManager(new LinearLayoutManager(this));
//        mFireStoreList.setAdapter(adapter);
//    }
//
//    private class ProductsViewHolder extends RecyclerView.ViewHolder {
//        private TextView name;
//        public ProductsViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name=itemView.findViewById(R.id.areas_item_id);
//
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//}
