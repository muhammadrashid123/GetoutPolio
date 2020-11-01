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

import java.util.HashMap;
import java.util.Map;

public class EditChildsActivity extends AppCompatActivity {
    private EditText objName,objFatherName,objFatherCNIC,objChildAge,objAddress;
    private Button objEditBtn;
    private Dialog objectWaitDialog;
    private FirebaseFirestore objectFirebaseFirestore;

    private StorageReference objectStorageReference;
    private DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_childs);


        objName=findViewById(R.id.Reg_name_id);
        objFatherName=findViewById(R.id.Father_name_id);
        objFatherCNIC=findViewById(R.id.Father_CNIC_no_id);
        objChildAge=findViewById(R.id.age__id);
        objAddress=findViewById(R.id.address_reg_id);
        objEditBtn=findViewById(R.id.button_edit);
        objectWaitDialog=new Dialog(this);

        objectWaitDialog.setContentView(R.layout.please_wait);
        objectWaitDialog.setCancelable(false);
        objectFirebaseFirestore=FirebaseFirestore.getInstance();

        objEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // EditInfo();
                updateValues();

            }
        });

    }
//    private void EditInfo()
//    {
//        if(!objName.getText().toString().isEmpty())
//        {
//            objectWaitDialog.show();
//            objectFirebaseFirestore.collection("registeredChildsInfo").document(objName.getText().toString())
//                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    if(documentSnapshot.exists())
//                    {
//                        objectWaitDialog.dismiss();
//
//                        String documentID=documentSnapshot.getId();
//                        String name=documentSnapshot.getString("name");
//                        String fname=documentSnapshot.getString("fatherName");
//                        String fCNIC=documentSnapshot.getString("fatherCNIC");
//                        String age=documentSnapshot.getString("age");
//                        String address=documentSnapshot.getString("address");
////                        String completeData="Registration No:"+documentID
////                                +"\n"+
////                                "Name:"+name+"\n"+
////                                "Father Name:"+fname+"\n"+
////                                "Father CNIC:"+fCNIC+"\n"+
////                                "Age:"+age+"\n"+
////                                "Address:"+address;
////                        objdowndLoadTV.setText(completeData);
//                        objName.setText(name);
//                        objFatherName.setText(fname);
//                        objFatherCNIC.setText(fCNIC);
//                        objChildAge.setText(age);
//                        objAddress.setText(address);
//
//                        objectWaitDialog.show();
//                        Map<String, Object> objectMap = new HashMap<>();
//                        objectMap.put("name",objName);
//                        objectMap.put("fatherName",objFatherName);
//                        objectMap.put("fatherCNIC",objFatherCNIC);
//                        objectMap.put("age",objChildAge);
//                        objectMap.put("address",objAddress);
//
//                        documentReference = objectFirebaseFirestore.collection("registeredChildsInfo")
//                                .document(objName.getText().toString());
//
//                        documentReference.update(objectMap)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void aVoid) {
//                                        objectWaitDialog.dismiss();
//                                        Toast.makeText(EditChildsActivity.this, "Values Successfully Updated", Toast.LENGTH_SHORT).show();
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        objectWaitDialog.dismiss();
//                                        Toast.makeText(EditChildsActivity.this, "Fails to update values :" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//
//
////                                Toast.makeText(RegisteredChildsInfoActivity.this, ""+documentID
////                                +"\n"
////                                +name+"\n"
////                                +fname+"\n"
////                                +fCNIC+"\n"
////                                +age+"\n"
////                                +address+"\n", Toast.LENGTH_SHORT).show();
//                    }
//                    else if(!documentSnapshot.exists())
//                    {
//                        Toast.makeText(EditChildsActivity.this, "child record does not exist", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(EditChildsActivity.this,RegistraionActivity.class);
//                        startActivity(intent);
//                    }
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    objectWaitDialog.dismiss();
//                    Toast.makeText(EditChildsActivity.this, "Fail to download data:"+
//                            e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else
//        {
//            objectWaitDialog.dismiss();
//            Toast.makeText(this, "Please enter the Registration No", Toast.LENGTH_SHORT).show();
//        }
//    }
    public void updateValues()
    {
        try
        {
                if(!objName.getText().toString().isEmpty()&& !objFatherName.getText().toString().isEmpty()&& !objFatherCNIC.getText().toString().isEmpty()&& !objChildAge.getText().toString().isEmpty() && !objAddress.getText().toString().isEmpty() )
            {
                Toast.makeText(this, "Please enter the values in required fields", Toast.LENGTH_SHORT).show();
            }
            else {
                    objectWaitDialog.show();
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("name",objName.getText().toString());
                objectMap.put("fatherName",objFatherName.getText().toString());
                objectMap.put("fatherCNIC",objFatherCNIC.getText().toString());
                objectMap.put("age",objChildAge.getText().toString());
                objectMap.put("address",objAddress.getText().toString());

                documentReference = objectFirebaseFirestore.collection("registeredChildsInfo")
                        .document(objName.getText().toString());

                documentReference.update(objectMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                objectWaitDialog.dismiss();
                                Toast.makeText(EditChildsActivity.this, "Values Successfully Updated", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                objectWaitDialog.dismiss();
                                Toast.makeText(EditChildsActivity.this, "Fails to update values :" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }
        catch (Exception e)
        {
            objectWaitDialog.dismiss();
            Toast.makeText(this, "updateValuesOfDocumentField:"+
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}
