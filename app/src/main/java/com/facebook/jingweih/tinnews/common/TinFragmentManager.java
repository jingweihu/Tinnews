package com.facebook.jingweih.tinnews.common;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;

import com.facebook.jingweih.tinnews.common.TinBasicFragment;


public interface TinFragmentManager {

    FragmentManager getTinFragmentManager();

    void doFragmentTransaction(TinBasicFragment basicFragment);

    void onBackPressed();

    @LayoutRes
    int getLayout();
}
