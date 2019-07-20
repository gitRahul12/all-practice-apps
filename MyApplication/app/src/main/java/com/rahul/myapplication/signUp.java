package com.rahul.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {
    EditText email,password;
    Button signup;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);

        //provide firebase link of firebase
        firebaseAuth=FirebaseAuth.getInstance();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String em=email.getText().toString();
                final String pass=password.getText().toString();

                if (TextUtils.isEmpty(em) && TextUtils.isEmpty(pass)){
                    Toast.makeText(signUp.this, "Email & Password Empty", Toast.LENGTH_SHORT).show();

                }
                else if (TextUtils.isEmpty(em) || TextUtils.isEmpty(pass)){
                    Toast.makeText(signUp.this, "Email or Password Empty", Toast.LENGTH_SHORT).show();
                }
                else if (pass.length()<6){
                    Toast.makeText(signUp.this, "Password TOO short", Toast.LENGTH_SHORT).show();
                }
                else {
                    register(em, pass);
                }

            }
        });
    }



    public void register(String em, String pass){

        firebaseAuth.createUserWithEmailAndPassword(em,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    //Sign in success
                    Toast.makeText(signUp.this, "Registration Successful !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else{
                    //if sign in fails, display a message to the user
                    Toast.makeText(signUp.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
