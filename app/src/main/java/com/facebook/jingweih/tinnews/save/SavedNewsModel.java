package com.facebook.jingweih.tinnews.save;

import com.facebook.jingweih.tinnews.TinApplication;
import com.facebook.jingweih.tinnews.database.AppDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;

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
        db.newsDao().getAll().observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> {
                    presenter.loadSavedNews(news);
                }, error -> {

                }, () -> {
                    System.out.println("complete");
                });
    }
}
