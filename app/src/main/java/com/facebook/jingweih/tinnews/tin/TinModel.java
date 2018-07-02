package com.facebook.jingweih.tinnews.tin;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;

import com.facebook.jingweih.tinnews.TinApplication;
import com.facebook.jingweih.tinnews.database.AppDatabase;
import com.facebook.jingweih.tinnews.retrofit.NewsRequestApi;
import com.facebook.jingweih.tinnews.retrofit.Response.News;
import com.facebook.jingweih.tinnews.retrofit.RetrofitClient;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class TinModel implements TinContract.Model {

    private final Retrofit retrofit;
    private final NewsRequestApi newsRequestApi;
    private TinContract.Presenter presenter;
    private final AppDatabase db;

    TinModel() {
        retrofit = RetrofitClient.getInstance();
        newsRequestApi = retrofit.create(NewsRequestApi.class);
        db = TinApplication.getDataBase();
    }


    @SuppressLint("CheckResult")
    @Override
    public void fetchDate() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.onNewsLoaded(baseResponse.articles);
                });
    }

    @Override
    public void saveFavoritedNews(News news) {
        Completable.fromAction(() -> db.newsDao().insertNews(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{
        }, error -> {
            presenter.message("News has been saved before");
        });
    }

    @Override
    public void setPresenter(TinContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
