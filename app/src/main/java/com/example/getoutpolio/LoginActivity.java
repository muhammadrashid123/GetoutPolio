package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
  private EditText userEmailET;
  private EditText passwordET;
  private Button button_login;
  private FirebaseAuth firebaseAuth;
    private ProgressBar objectWaitPB;
    private static final String DEFAULT_PASSWORD="user123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();


        connectXML();

    }
    private void connectXML()
    {
        try {
            userEmailET =findViewById(R.id.edittext_userEmail);
            passwordET=findViewById(R.id.edittest_password);
            button_login=findViewById(R.id.button_login);
            objectWaitPB=findViewById(R.id.waitProgressBar);

            button_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInUser();
                }
            });

            }catch (Exception e)
        {
            Toast.makeText(this, "connectXML"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void signInUser()
    {
        try {
            if(!userEmailET.getText().toString().isEmpty() && ! passwordET.getText().toString().isEmpty() && firebaseAuth!=null)
            {


                if (firebaseAuth.getCurrentUser()!=null)
                {
                    firebaseAuth.signOut();
                    Toast.makeText(this, "Already logged in user sign out successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    objectWaitPB.setVisibility(View.VISIBLE);
                    button_login.setEnabled(false);
                    firebaseAuth.signInWithEmailAndPassword(userEmailET.getText().toString(),passwordET.getText().toString())

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "User sign in Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_login.setEnabled(true);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_login.setEnabled(true);
                                    Toast.makeText(LoginActivity.this, "Fails to sign in user", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }

            else if (userEmailET.getText().toString().isEmpty())
            {
                Toast.makeText(this, "PLease enter Email", Toast.LENGTH_SHORT).show();
               userEmailET.requestFocus();
            }
            else if (passwordET.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show();
                passwordET.requestFocus();
            }
            else if (firebaseAuth==null)
            {
                Toast.makeText(this, "Firebase Auth is null", Toast.LENGTH_SHORT).show();
                userEmailET.requestFocus();
            }
            }
        catch (Exception e)
          {
              objectWaitPB.setVisibility(View.INVISIBLE);
            button_login.setEnabled(true);
            Toast.makeText(this, "signInUser"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


public void gotoforgot(View view){
        Intent intent =new Intent(LoginActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);

}

}
