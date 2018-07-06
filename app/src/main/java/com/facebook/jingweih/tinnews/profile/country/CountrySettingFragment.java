package com.facebook.jingweih.tinnews.profile.country;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;

import java.util.List;

public class CountrySettingFragment extends MvpFragment<CountrySettingContract.Presenter> implements CountrySettingContract.View {

    private ListView countryGroup;
    public static CountrySettingFragment newInstance() {
        CountrySettingFragment fragment = new CountrySettingFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.country_setting_layout, container, false);
        countryGroup = view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public CountrySettingContract.Presenter getPresenter() {
        return new CountrySettingPresenter();
    }

    @Override
    public void loadCountries(List<Country> countryList) {
        ListViewAdapter adapter = new ListViewAdapter(countryList, getContext(), presenter.getCountryListener());
        countryGroup.setAdapter(adapter);
    }
}
