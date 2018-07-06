package com.facebook.jingweih.tinnews.onboard;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.TinBasicActivity;
import com.facebook.jingweih.tinnews.common.TinBasicFragment;

public class TinOnBoardingActivity extends TinBasicActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        viewPager = findViewById(R.id.viewpager);

    }



    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }
}
