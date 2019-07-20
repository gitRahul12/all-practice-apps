package com.rahul.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        WebView web = findViewById(R.id.webView);



        String url = getIntent().getStringExtra("url");

        web.loadUrl(url);
        //giving javaScript permission for twitter
        web.getSettings().setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient());
    }
}
