package com.facebook.jingweih.tinnews.save.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.TinBasicFragment;

public class WebViewFragment extends TinBasicFragment {

    private String uri;
    public static WebViewFragment newInstance(String uri) {

        WebViewFragment fragment = new WebViewFragment();
        fragment.uri = uri;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.webview_fragment_layout, container, false);
        view.findViewById(R.id.back).setOnClickListener(button -> {
            tinFragmentManager.onBackPressed();
        });
        WebView webView = view.findViewById(R.id.web_view);
        webView.loadUrl(uri);
        return view;
    }
}
