package com.facebook.jingweih.tinnews.save;

import com.facebook.jingweih.tinnews.TinApplication;
import com.facebook.jingweih.tinnews.database.AppDatabase;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SavedNewsModel implements SavedNewsContract.Model {
    private SavedNewsContract.Presenter presenter;

    private final AppDatabase db;
    SavedNewsModel() {
        db = TinApplication.getDataBase();
    }
    @Override
    public void setPresenter(SavedNewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void fetchDate() {
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> {
                    presenter.loadSavedNews(news);
                }, error -> {

                }, () -> {
                    System.out.println("complete");
                });
    }

    @Override
    public void deleteNews(News news) {
        Completable.fromAction(() -> db.newsDao().delete(news)).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() ->{
        }, error -> {

        });
    }
}
