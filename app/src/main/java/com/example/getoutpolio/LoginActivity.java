package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
  private EditText userEmailET;
  private EditText passwordET;
  private Button button_user_login,button_admin_login;
  private FirebaseAuth firebaseAuth;
    private ProgressBar objectWaitPB;
    private EditText forgotPassword;
   // String[] user = { " ", "Admin", "User"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        Spinner spin = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, user);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(adapter);
//        spin.setOnItemSelectedListener(this);




        firebaseAuth=FirebaseAuth.getInstance();


        connectXML();

    }
    private void connectXML()
    {
        try {
            userEmailET =findViewById(R.id.edittext_userEmail);
            passwordET=findViewById(R.id.edittest_password);
            button_user_login=findViewById(R.id.button_user_login_id);
            button_admin_login=findViewById(R.id.button_admin_login_id);
            objectWaitPB=findViewById(R.id.waitProgressBar);
            forgotPassword=findViewById(R.id.send_email_Id);

            button_user_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInUser();
                }
            });
            button_admin_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInAdmin();
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
               else  if(userEmailET.getText().toString().equals("admin@gmail.com") && passwordET.getText().toString().equals("admin"))
                {
                    objectWaitPB.setVisibility(View.VISIBLE);
                    button_user_login.setEnabled(false);
                    firebaseAuth.signInWithEmailAndPassword(userEmailET.getText().toString(),passwordET.getText().toString())

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "User sign in Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    Toast.makeText(LoginActivity.this, "Fails to sign in user", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else
                {
                    objectWaitPB.setVisibility(View.VISIBLE);
                    button_user_login.setEnabled(false);
                    firebaseAuth.signInWithEmailAndPassword(userEmailET.getText().toString(),passwordET.getText().toString())

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "User sign in Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
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
              button_user_login.setEnabled(true);
            Toast.makeText(this, "signInUser"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


public void gotoforgot(View view){
        Intent intent =new Intent(LoginActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);

}
    private void signInAdmin()
    {
        try {
            if(!userEmailET.getText().toString().isEmpty() && ! passwordET.getText().toString().isEmpty() && firebaseAuth!=null)
            {


                if (firebaseAuth.getCurrentUser()!=null)
                {
                    firebaseAuth.signOut();
                    Toast.makeText(this, "Already logged in Admin sign out successfully", Toast.LENGTH_SHORT).show();
                }
                else  if(userEmailET.getText().toString().equals("admin@gmail.com") && passwordET.getText().toString().equals("admin"))
                {
                    objectWaitPB.setVisibility(View.VISIBLE);
                    button_user_login.setEnabled(false);
                    firebaseAuth.signInWithEmailAndPassword(userEmailET.getText().toString(),passwordET.getText().toString())

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "admin sign in Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    Toast.makeText(LoginActivity.this, "Fails to sign in Admin", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else
                {
                    objectWaitPB.setVisibility(View.VISIBLE);
                    button_user_login.setEnabled(false);
                    firebaseAuth.signInWithEmailAndPassword(userEmailET.getText().toString(),passwordET.getText().toString())

                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(LoginActivity.this, "Admin sign in Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,AdminDashboard.class));
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    objectWaitPB.setVisibility(View.INVISIBLE);
                                    button_user_login.setEnabled(true);
                                    Toast.makeText(LoginActivity.this, "Fails to sign in Admin", Toast.LENGTH_SHORT).show();
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
            button_user_login.setEnabled(true);
            Toast.makeText(this, "signInAdmin"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }




    }
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        //Toast.makeText(getApplicationContext(), "Selected  : "+ user[position] ,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

