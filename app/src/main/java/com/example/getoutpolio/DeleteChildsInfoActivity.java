package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

public class DeleteChildsInfoActivity extends AppCompatActivity {
    private EditText editText;
    private Button objBtn;
    private FirebaseFirestore objectFirebaseFirestore;

    private Dialog objectWaitDialog;
    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_childs_info);
        editText=findViewById(R.id.delete_TV_id);
        objBtn=findViewById(R.id.delete_Btn_id);

        objectWaitDialog=new Dialog(this);

        objectWaitDialog.setContentView(R.layout.please_wait);
        objectWaitDialog.setCancelable(false);

        objectFirebaseFirestore=FirebaseFirestore.getInstance();
        objBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             deleteInfo();
            }
        });
    }
    public void deleteInfo(){
        if(editText.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter the document id", Toast.LENGTH_SHORT).show();
        }else {
            objectWaitDialog.show();
            documentReference = objectFirebaseFirestore.collection("registeredChildsInfo")
                    .document(editText.getText().toString());
            documentReference.delete() .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    objectWaitDialog.dismiss();
                    Toast.makeText(DeleteChildsInfoActivity.this, "Data Doucment deleted Successfully", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            objectWaitDialog.dismiss();
                            Toast.makeText(DeleteChildsInfoActivity.this, "Fails to delete filed data:"
                                    + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
