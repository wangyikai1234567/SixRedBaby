package com.redbaby.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.redbaby.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.wv_wv);

        Intent intent = getIntent();
        String imgUrl = intent.getStringExtra("img");

        mWebView.loadUrl("http:" + imgUrl);


    }
}
