package com.facebook.jingweih.tinnews.common;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class TinBasicActivity extends AppCompatActivity implements TinFragmentManager {
    @Override
    public FragmentManager getTinFragmentManager() {
        return getSupportFragmentManager();
    }
}
