package com.facebook.jingweih.tinnews.profile.country;

import android.content.SharedPreferences;

import com.facebook.jingweih.tinnews.TinApplication;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountrySettingModel implements CountrySettingContract.Model {
    private CountrySettingContract.Presenter presenter;
    public static final String COUNTRY = "country";
    private final SharedPreferences sharedPreferences = TinApplication.getSharedPreferences();
    CountrySettingModel() {
    }

    @Override
    public void setPresenter(CountrySettingContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getSavedCountry() {
       Observable<String> observable = Observable.just(sharedPreferences.getString(COUNTRY, "us"));
       observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
             presenter.setDefaultCountry(s);
       }, error -> {

       });

    }

    @Override
    public void setDefaultCountry(Country country) {
        boolean isFinished = sharedPreferences.edit().putString(COUNTRY, country.getDbString()).commit();
        if (isFinished) {
            EventBus.getDefault().post(new CountryChangeEvent());
        }

    }
}
