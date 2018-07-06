package com.facebook.jingweih.tinnews.profile;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.ViewModelAdapter;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;
import com.facebook.jingweih.tinnews.profile.country.CountrySettingFragment;
import com.facebook.jingweih.tinnews.save.detail.TitleViewModel;

public class TinProfileFragment extends MvpFragment<ProfileContract.Presenter> implements ProfileContract.View {
    private ViewModelAdapter viewModelAdapter;

    public static TinProfileFragment newInstance() {
        TinProfileFragment fragment = new TinProfileFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.recycler_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;
    }


    @Override
    public ProfileContract.Presenter getPresenter() {
        return new ProfilePresenter();
    }

    @Override
    public void setView() {
        viewModelAdapter.addViewModel(new TitleViewModel(getString(R.string.setting), R.layout.setting_title_layout));
        viewModelAdapter.addViewModel(new RomTextViewModel(getString(R.string.clear_cache), presenter.getCacheClearListener()));
        viewModelAdapter.addViewModel(new RomTextViewModel(getString(R.string.country_source), v -> {
            tinFragmentManager.doFragmentTransaction(CountrySettingFragment.newInstance());
        }));
    }

    @Override
    public boolean isViewEmpty() {
        return viewModelAdapter == null || viewModelAdapter.isEmpty();
    }

    @Override
    public void onCacheCleared() {
        tinFragmentManager.showSnackBar(getString(R.string.cache_cleared));
    }

}
