package com.rahul.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView web=findViewById(R.id.webView);

        String rahul = getIntent().getStringExtra("url");
        String kumar = getIntent().getStringExtra("url1");

        web.loadUrl(rahul);
        web.loadUrl(kumar);

        web.setWebViewClient(new WebViewClient());
    }
}
