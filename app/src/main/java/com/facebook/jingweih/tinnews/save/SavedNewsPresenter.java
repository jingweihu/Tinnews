package com.facebook.jingweih.tinnews.save;

import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.List;

public class SavedNewsPresenter implements SavedNewsContract.Presenter {

    private final SavedNewsContract.Model model;
    private SavedNewsContract.View view;
    SavedNewsPresenter() {
        model = new SavedNewsModel();
        model.setPresenter(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
        this.view = view;
        model.fetchDate();
    }

    @Override
    public void onViewDetached() {
        this.view = view;
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null) {
            view.loadSavedNews(newsList);
        }
    }

    @Override
    public DeleteListener getOnDeleteListener() {
        return news -> {
            model.deleteNews(news);
        };
    }

    interface DeleteListener {
        void onDelete(News news);
    }
}
