package com.rahul.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float mValue1, mValue2;

    boolean add,sub,multi,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv1=findViewById(R.id.textView1);
        final TextView tv2=findViewById(R.id.textView2);

        Button btn0=findViewById(R.id.button0);
        Button btn1=findViewById(R.id.button1);
        Button btn2=findViewById(R.id.button2);
        Button btn3=findViewById(R.id.button3);
        Button btn4=findViewById(R.id.button4);
        Button btn5=findViewById(R.id.button5);
        Button btn6=findViewById(R.id.button6);
        Button btn7=findViewById(R.id.button7);
        Button btn8=findViewById(R.id.button8);
        Button btn9=findViewById(R.id.button9);
        Button btnPlus=findViewById(R.id.buttonPlus);
        Button btnsub=findViewById(R.id.buttonSub);
        Button btnmulti=findViewById(R.id.buttonMul);
        Button btndiv=findViewById(R.id.buttonDiv);
        Button btnAC=findViewById(R.id.buttonAC);
        Button btnC=findViewById(R.id.buttonC);
        Button btnDot=findViewById(R.id.buttonDot);
        Button btnEqual=findViewById(R.id.buttonEqual);
        Button btnMod=findViewById(R.id.buttonCheck);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"0");
            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"1");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+"9");
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tv1== null) {
                    tv1.setText("");
                } else {
                    mValue1 = Float.parseFloat(tv1.getText() + "");
                    add = true;
                    tv1.setText(null);
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv1==null){
                    tv1.setText("");
                }else{
                    mValue1 = Float.parseFloat(tv1.getText()+ "");
                    sub =true;
                    tv1.setText(null);
                }
            }
        });
        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv1==null){
                    tv1.setText("");
                }else{
                    mValue1 = Float.parseFloat(tv1.getText()+ "");
                    multi =true;
                    tv1.setText(null);
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv1==null){
                    tv1.setText("");
                }else{
                    mValue1 = Float.parseFloat(tv1.getText()+ "");
                    div = true;
                    tv1.setText(null);
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(" ");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValue2 = Float.parseFloat(tv1.getText() + "");

                if (add == true) {
                    tv2.setText(mValue1 + mValue2 + " ");
                    add = false;
                }

                if (sub== true) {
                    tv2.setText(mValue1 - mValue2 + "");
                    sub = false;
                }

                if (multi == true) {
                    tv2.setText(mValue1 * mValue2 + "");
                    multi = false;
                }

                if (div== true) {
                    tv2.setText(mValue1 / mValue2+ "");
                    div = false;
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText(tv1.getText()+ ".");
            }
        });
    }
}
