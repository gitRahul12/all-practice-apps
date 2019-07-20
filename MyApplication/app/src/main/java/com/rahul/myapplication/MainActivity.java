package com.rahul.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1=findViewById(R.id.tv1);

        FirebaseUser firebaseUser =FirebaseAuth.getInstance().getCurrentUser();

        String email=firebaseUser.getEmail();

        tv1.setText(email);



    }
}
