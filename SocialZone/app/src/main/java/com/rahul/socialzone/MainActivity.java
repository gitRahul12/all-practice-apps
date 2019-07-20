package com.rahul.socialzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView facebook=findViewById(R.id.facebook_btn);
        ImageView instagram=findViewById(R.id.instagram_btn);
        ImageView twitter=findViewById(R.id.twitter_btn);
        ImageView linkdin=findViewById(R.id.linkdin_btn);
        ImageView youtube=findViewById(R.id.youtube_btn);
        ImageView whatsapp=findViewById(R.id.whatsapp_btn);
//        ImageView gmail=findViewById(R.id.gmail_btn);
//        ImageView yahoo=findViewById(R.id.yahoo_btn);
//        ImageView chrome=findViewById(R.id.chrome_btn);
        ImageView bing=findViewById(R.id.bing_btn);
        ImageView netflix=findViewById(R.id.netflix_btn);
        ImageView quora=findViewById(R.id.quora_btn);
        ImageView wikipedia=findViewById(R.id.wiki_btn);
        ImageView snapchat=findViewById(R.id.snapchat_btn);
        ImageView tumbler=findViewById(R.id.tumbler_btn);
        ImageView medium=findViewById(R.id.medium_btn);
        ImageView udemy=findViewById(R.id.udemy_btn);
        ImageView telegram=findViewById(R.id.telegram_btn);
//        ImageView amazon=findViewById(R.id.amazon_btn);
//        ImageView flipkart=findViewById(R.id.flipkart_btn);
//        ImageView snapdeal=findViewById(R.id.snapdeal_btn);
//        ImageView hotstar=findViewById(R.id.hotstar_btn);
//        ImageView sonyLiv=findViewById(R.id.sony_btn);
//        ImageView jioTv=findViewById(R.id.jiotv_btn);
//        ImageView uberEats=findViewById(R.id.ubereats_btn);
//        ImageView swiggy=findViewById(R.id.swiggy_btn);
//        ImageView zomato=findViewById(R.id.zomato_btn);
//        ImageView uber=findViewById(R.id.uber_btn);
//        ImageView ola=findViewById(R.id.ola_btn);
//        ImageView lco=findViewById(R.id.lco_btn);


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                startActivity(i);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                startActivity(i);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                startActivity(i);
            }
        });
        linkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.linkdin.android.home");
                startActivity(i);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(i);
            }
        });
    }
}
