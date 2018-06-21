package com.facebook.jingweih.tinnews;

import android.support.v4.app.FragmentManager;


public interface TinFragmentManager {

    FragmentManager getTinFragmentManager();

    void doFragmentTransaction(TinBasicFragment basicFragment);
}
