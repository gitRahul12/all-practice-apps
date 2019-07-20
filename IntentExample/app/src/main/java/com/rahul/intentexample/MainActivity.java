package com.rahul.intentexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button proBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.Button);
        Button btn_Alert = findViewById(R.id.Button1);
        RatingBar rate = findViewById(R.id.ratingBar);

        proBar = findViewById(R.id.buttonPro);
        proBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progress =new ProgressDialog(MainActivity.this);
                progress.setMessage("Download");
                progress.setProgress(0);
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);     //for horizontal shape STYLE_HORIZONTAL
                progress.show();
                progress.setCanceledOnTouchOutside(false);
            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

        btn_Alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showalert();

            }
        });


    }
    public void showalert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to logout ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes Clicked", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();



            }
        });
        //Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        //Show the Alert Dialog box
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "Click one more time to Exit", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
