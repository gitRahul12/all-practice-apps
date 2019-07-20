package com.rahul.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button login;
    EditText email,password;
    TextView signup,resetPass;

    private FirebaseAuth firebaseAuth;
//    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth=FirebaseAuth.getInstance();

//        progressBar=findViewById(R.id.proBar);
         email=findViewById(R.id.email);
         password=findViewById(R.id.password);
         login=findViewById(R.id.signin);
         signup=findViewById(R.id.signup);
         resetPass=findViewById(R.id.reset_pass);


            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
            if (currentUser != null){
                startActivity(new Intent(Login.this,MainActivity.class));
            }


         resetPass.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Login.this, resetpassword.class));
             }
         });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),signUp.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1= email.getText().toString();
                String str2=password.getText().toString();

                if(TextUtils.isEmpty(str1) && TextUtils.isEmpty(str2))
                {
                    Toast.makeText(Login.this, " Email & Password Empty", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)){
                    Toast.makeText(Login.this, "Email or Password Empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    confirm(str1,str2);
                }
            }
        });
    }
    public void confirm(String str1, String str2){


//        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(str1,str2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
//                progressBar.setVisibility(View.GONE);

                if (!task.isSuccessful()) {
                            Toast.makeText(Login.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }
                    }




        });


    }
}
