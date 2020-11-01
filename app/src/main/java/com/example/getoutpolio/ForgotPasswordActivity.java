package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
EditText sendEmail;
Button sendPassword;
ProgressBar progressBar;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        sendEmail=findViewById(R.id.send_email_Id);
        sendPassword=findViewById(R.id.button_send_passwordID);
        progressBar=findViewById(R.id.waitProgressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        sendPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                sendPassword.setEnabled(false);
                firebaseAuth.sendPasswordResetEmail(sendEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressBar.setVisibility(View.INVISIBLE);
                                sendPassword.setEnabled(true);

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(ForgotPasswordActivity.this, "Password send to your email", Toast.LENGTH_SHORT).show();
                                    sendEmail.requestFocus();
                                }
                                else 
                                {
                                    Toast.makeText(ForgotPasswordActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    sendEmail.requestFocus();
                                }
                            }
                        });
            }
        });

    }
}
