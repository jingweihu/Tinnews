package com.facebook.jingweih.tinnews.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;

import com.facebook.jingweih.tinnews.common.TinBasicFragment;


public interface TinFragmentManager {

    void doFragmentTransaction(TinBasicFragment basicFragment);

    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);

    @LayoutRes
    int getLayout();
}
