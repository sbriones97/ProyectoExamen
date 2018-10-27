package com.iteso.ProyectoExamen;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iteso.ProyectoExamen.tools.WebAppInterface;

public class ActivityPrivacyPolicy extends AppCompatActivity implements DialogInterface.OnKeyListener{

    public WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);


        webView = findViewById(R.id.activity_privacy_html);
        webView.loadUrl("file:///android_asset/PrivacyPolicy.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled (true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        webView.setWebViewClient (new WebViewClient());
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if((keyCode==KeyEvent.KEYCODE_BACK) &&webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history,
        // bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
