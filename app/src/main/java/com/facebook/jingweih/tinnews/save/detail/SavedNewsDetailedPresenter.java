package com.facebook.jingweih.tinnews.save.detail;

import com.facebook.jingweih.tinnews.retrofit.Response.News;

public class SavedNewsDetailedPresenter implements SavedNewsDetailedContract.Presenter {

    private News news;
    private SavedNewsDetailedContract.View view;
    SavedNewsDetailedPresenter(News news) {
        this.news = news;

    }
    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsDetailedContract.View view) {
        this.view = view;
        this.view.loadNews(news);
    }

    @Override
    public void onViewDetached() {
        view = null;
    }
}
