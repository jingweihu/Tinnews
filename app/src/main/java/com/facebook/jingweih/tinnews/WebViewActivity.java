package com.facebook.jingweih.tinnews;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.jingweih.tinnews.common.TinBasicActivity;
import com.facebook.jingweih.tinnews.common.TinBasicFragment;

public class WebViewActivity extends TinBasicActivity implements PopupMenu.OnMenuItemClickListener  {
    public static final String URL = "url";
    private String url;

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
                url = innerBundle.getString(URL);
                webView.loadUrl(url);
            }
        }

       findViewById(R.id.more).setOnClickListener(v -> {
           showMenu(v);
       });
    }

    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @SuppressLint("RestrictedApi")
    private void showMenu(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(this);
        MenuInflater inflater = menu.getMenuInflater();
        inflater.inflate(R.menu.web_view_items, menu.getMenu());
        MenuPopupHelper menuHelper = new MenuPopupHelper(this, (MenuBuilder) menu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

    @Override
    public int getLayout() {
        return R.layout.webview_activity_layout;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "From TinNews: \n" + url;
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                this.startActivity(Intent.createChooser(sharingIntent, "Share TinNews"));
            break;
            case R.id.menu_copy:
                ClipboardManager clipboard = (ClipboardManager)
                        getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", url);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Link Copied", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
