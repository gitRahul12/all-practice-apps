package com.rahul.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

//        Bundle b = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.nameValue);
        TextView email = (TextView) findViewById(R.id.emailValue);
        TextView password = (TextView) findViewById(R.id.passwordValue);
        TextView phone = (TextView) findViewById(R.id.phoneValue);



        name.setText("\t"+getIntent().getStringExtra("Name"));
        email.setText("\t"+getIntent().getStringExtra("Email"));
        password.setText("\t"+getIntent().getStringExtra("Password"));
        phone.setText("\t"+getIntent().getStringExtra("PhoneNumber"));


    }
}
