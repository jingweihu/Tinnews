package com.facebook.jingweih.tinnews.tin;

import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {

    private final TinContract.Model tinModel;
    private TinContract.View view;
    TinPresenter() {
        this.tinModel = new TinModel();
        this.tinModel.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(TinContract.View view) {
        this.view = view;
        tinModel.fetchDate();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void onNewsLoaded(List<News> newsList) {
        if (view != null) {
            view.onNewsLoaded(newsList);
        }
    }

    @Override
    public void saveFavoritedNews(News news) {
        tinModel.saveFavoritedNews(news);
    }

    @Override
    public void message(String string) {
        if (view != null) {
            view.message(string);
        }
    }
}
