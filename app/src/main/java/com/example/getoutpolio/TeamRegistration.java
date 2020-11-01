package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TeamRegistration extends AppCompatActivity {

    private ImageView uploadImage;
    private EditText  objName,objFatherName,objCNIC,objContact,objAddress;
    private Button objRegisterBtn;
    private ProgressBar progressBar;
    private static final int REQUEST_CODE=123;
    private Uri objectUri;
    private boolean isImageSelected=false;
    private FirebaseFirestore objectFirebaseFirestore;

    private StorageReference objectStorageReference;

    private static final String COLLECTION_NAME="members";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
            setTitle("Registration");
        uploadImage=findViewById(R.id.team_image_Id);
        objName=findViewById(R.id.member_Reg_name_id);
        objFatherName=findViewById(R.id.member_Father_name_id);
        objCNIC=findViewById(R.id.member_CNIC_no_id);
       objContact=findViewById(R.id.member_contact__id);
        objAddress=findViewById(R.id.member_address_id);
        objRegisterBtn=findViewById(R.id.btn_register_member);
        progressBar=findViewById(R.id.waitProgressBar);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallery();
            }
        });

        objectFirebaseFirestore=FirebaseFirestore.getInstance();
        objectStorageReference= FirebaseStorage.getInstance().getReference("registeredChildsImages");

        objRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImageToCloudStorage();
            }
        });
    }

    private void uploadImageToCloudStorage()
    {
        if(isImageSelected && !objName.getText().toString().isEmpty()&& !objFatherName.getText().toString().isEmpty()&& !objCNIC.getText().toString().isEmpty()&& !objContact.getText().toString().isEmpty()&& !objAddress.getText().toString().isEmpty() )
        {

            String imagePath=objName.getText().toString()+"."+getExtension(objectUri);
            final StorageReference imageRef=objectStorageReference.child(imagePath);

            UploadTask objectUploadTask=imageRef.putFile(objectUri);
            objectUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful())
                    {

                        throw task.getException();
                    }

                    return imageRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful())
                    {
                        Map<String,Object> objectMap=new HashMap<>();
                        objectMap.put("imageUrl",task.getResult().toString());
                        objectMap.put("name",objName.getText().toString());
                        objectMap.put("fatherName",objFatherName.getText().toString());
                        objectMap.put("CNIC",objCNIC.getText().toString());
                        objectMap.put("age",objContact.getText().toString());
                        objectMap.put("address",objAddress.getText().toString());


                        objectFirebaseFirestore.collection("Teams").document("Team#01").collection(COLLECTION_NAME)
                                .document(objCNIC.getText().toString())
                                .set(objectMap)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        objName.setText("");
                                        objFatherName.setText("");
                                        objCNIC.setText("");
                                        objContact.setText("");
                                        objAddress.setText("");


                                        Toast.makeText(TeamRegistration.this, "member add successfully", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(TeamRegistration.this, "Fails to upload image:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(TeamRegistration.this, "Fails to upload image:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            })
            ;

        }
        else if(!isImageSelected)
        {
            Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show();
        }
        else if(objName.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter the Empty input Field", Toast.LENGTH_SHORT).show();
        }
    }

    private String getExtension(Uri objectUri) {
        try
        {
            ContentResolver objectContentResolver=getContentResolver();
            MimeTypeMap objectMimeTypeMap=MimeTypeMap.getSingleton();

            String extension=objectMimeTypeMap.getExtensionFromMimeType(objectContentResolver.getType(objectUri));
            return extension;
        }
        catch (Exception e)
        {
            Toast.makeText(this, "getExtension:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return null;
    }


    private void selectImageFromGallery()
    {
        try
        {
            Intent objectIntent=new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,REQUEST_CODE);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "selectImageFromGallery:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null)
        {
            objectUri=data.getData();
            if(objectUri!=null)
            {
                try
                {
                    Bitmap objectBitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),objectUri);
                    uploadImage.setImageBitmap(objectBitmap);

                    isImageSelected=true;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Toast.makeText(this, "Data is null", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "No Image is selected", Toast.LENGTH_SHORT).show();
        }
    }

}

