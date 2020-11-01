package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SearchChildsInfoActivity extends AppCompatActivity {
    private EditText objimageNameET;
    private TextView objdowndLoadTV;
    private ImageView objdownloadedIV;

    private Button objdownloadBtn;
    private FirebaseFirestore objectFirebaseFirestore;

    private Dialog objectWaitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_childs_info);
        objimageNameET=findViewById(R.id.imageName_id);
        objdownloadBtn=findViewById(R.id.downloadImageBtn_id);
        objdowndLoadTV=findViewById(R.id.downloadedDataTV);
        objdownloadedIV=findViewById(R.id.downladedImageIV_id);
        objectWaitDialog=new Dialog(this);

        objectWaitDialog.setContentView(R.layout.please_wait);
        objectWaitDialog.setCancelable(false);

        objectFirebaseFirestore=FirebaseFirestore.getInstance();
        objdownloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetInfo();
            }
        });

    }

    private void GetInfo()
    {
        if(!objimageNameET.getText().toString().isEmpty())
        {
            objectWaitDialog.show();
            objectFirebaseFirestore.collection("registeredChildsInfo").document(objimageNameET.getText().toString())
                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        objectWaitDialog.dismiss();
                        String url=documentSnapshot.getString("imageUrl");
                        Glide.with(SearchChildsInfoActivity.this)
                                .load(url).into(objdownloadedIV);
                        String documentID=documentSnapshot.getId();
                        String name=documentSnapshot.getString("name");
                        String fname=documentSnapshot.getString("fatherName");
                        String fCNIC=documentSnapshot.getString("fatherCNIC");
                        String age=documentSnapshot.getString("age");
                        String address=documentSnapshot.getString("address");
                        String completeData="Registration No:"+documentID
                                +"\n"+
                                "Name:"+name+"\n"+
                                "Father Name:"+fname+"\n"+
                                "Father CNIC:"+fCNIC+"\n"+
                                "Age:"+age+"\n"+
                                "Address:"+address;
                        objdowndLoadTV.setText(completeData);
//                                Toast.makeText(RegisteredChildsInfoActivity.this, ""+documentID
//                                +"\n"
//                                +name+"\n"
//                                +fname+"\n"
//                                +fCNIC+"\n"
//                                +age+"\n"
//                                +address+"\n", Toast.LENGTH_SHORT).show();
                    }
                    else if(!documentSnapshot.exists())
                    {
                        Toast.makeText(SearchChildsInfoActivity.this, "child record does not exist", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SearchChildsInfoActivity.this,RegistraionActivity.class);
                        startActivity(intent);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    objectWaitDialog.dismiss();
                    Toast.makeText(SearchChildsInfoActivity.this, "Fail to download data:"+
                            e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            objectWaitDialog.dismiss();
            Toast.makeText(this, "Please enter the Registration No", Toast.LENGTH_SHORT).show();
        }
    }
}
