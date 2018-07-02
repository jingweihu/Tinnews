package com.facebook.jingweih.tinnews.save;

import com.facebook.jingweih.tinnews.mvp.MvpContract;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.List;

public interface SavedNewsContract {

    interface View extends MvpContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends  MvpContract.Presenter<View, Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchDate();
    }
}
