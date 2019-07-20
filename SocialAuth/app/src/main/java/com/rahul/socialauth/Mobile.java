package com.rahul.socialauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Mobile extends AppCompatActivity {

    EditText number,otp;
    Button send;
     private FirebaseAuth mAuth;
     String verifictationId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        //initialized firebaseauth
        mAuth = FirebaseAuth.getInstance();

        number=findViewById(R.id.edt1);
        otp=findViewById(R.id.edt2);
        send=findViewById(R.id.snd_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=number.getText().toString().trim();
                if (num.isEmpty() || number.length() < 10) {
                    number.setError("Valid number is required");
                    number.requestFocus();
                    return;
                }
                final String phoneNumber = "+" + "91" + num;
                sendVerificationCode(phoneNumber);
            }
        });
    }
    public void sendVerificationCode(String number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

        Log.i("TAG ---- - --1",PhoneAuthProvider.getInstance().toString());

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verifictationId = s;

            Log.i("TAG ---- - --2",verifictationId.toString());
            Log.i("TAG ---- - --3",forceResendingToken.toString());
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                otp.setText(code);  //we can do it here manually by otp.getText(code)
                verifyCode(code);
            }
            Log.i("TAG ---- - --4",phoneAuthCredential.toString());

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
        Log.i("FAilue-------2323",e.getMessage().toString());
        }


    };
    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifictationId,code);
        signInWithCredential (credential);

        Log.i("TAG ---- - --5",credential.toString());


    }
    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Mobile.this, "Verification Success !!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Mobile.this,MainActivity.class));
                }
                else{
                    Toast.makeText(Mobile.this, "Verification Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
