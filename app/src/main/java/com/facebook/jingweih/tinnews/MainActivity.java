package com.facebook.jingweih.tinnews;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.jingweih.tinnews.common.ContainerFragment;
import com.facebook.jingweih.tinnews.common.TinBasicActivity;
import com.facebook.jingweih.tinnews.common.TinBasicFragment;
import com.facebook.jingweih.tinnews.common.TinFragmentManager;
import com.facebook.jingweih.tinnews.retrofit.NewsRequestApi;
import com.facebook.jingweih.tinnews.retrofit.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends TinBasicActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomBar;
    private TinFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        viewPager = findViewById(R.id.viewpager);
        adapter = new TinFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(TinFragmentPagerAdapter.FRAGMENT_NUMBER);

        bottomBar = findViewById(R.id.bottom_navigation);
        bottomBar.setOnNavigationItemSelectedListener(item -> {
            viewPager.setCurrentItem(ContainerFragment.getPositionById(item.getItemId()));
            return true;
        });
    }

    @Override
    public FragmentManager getTinFragmentManager() {
        return getSupportFragmentManager();
    }

    private FragmentManager getCurrentChildFragmentManager() {
        return adapter.getItem(viewPager.getCurrentItem()).getChildFragmentManager();
    }

    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {
        FragmentTransaction fragmentTransaction = getCurrentChildFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.pop_in, R.anim.pop_out);
        fragmentTransaction.replace(
                R.id.child_fragment_container,
                basicFragment,
                basicFragment.getFragmentTag()).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getCurrentChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
