package com.facebook.jingweih.tinnews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.jingweih.tinnews.common.TinBasicActivity;
import com.facebook.jingweih.tinnews.common.TinBasicFragment;

public class WebViewActivity extends TinBasicActivity {
    public static final String URL = "url";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.back).setOnClickListener(button -> {
            onBackPressed();
        });
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Bundle innerBundle = bundle.getBundle(BUNDLE);
            if (innerBundle != null) {
                webView.loadUrl(innerBundle.getString(URL));
            }
        }
    }

    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {

    }

    @Override
    public int getLayout() {
        return R.layout.webview_activity_layout;
    }
}
