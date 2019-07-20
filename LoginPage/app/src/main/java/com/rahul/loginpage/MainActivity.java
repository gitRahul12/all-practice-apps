package com.rahul.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,email,password,phone;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        btn=findViewById(R.id.signUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationPage.class);
                //Create a bundle object
             //   Bundle b = new Bundle();

                //Inserts a String value into the mapping of this Bundle
                intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                intent.putExtra("Password", password.getText().toString());
                intent.putExtra("PhoneNumber", phone.getText().toString());

                //Add the bundle to the intent.
//                intent.putExtras(b);

                //start the RegistrationPage Activity
                startActivity(intent);
            }
        });


    }
}
