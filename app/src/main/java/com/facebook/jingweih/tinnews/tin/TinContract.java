package com.facebook.jingweih.tinnews.tin;

import com.facebook.jingweih.tinnews.mvp.MvpContract;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.List;

public interface TinContract {

    interface View extends MvpContract.View<Presenter> {
        void onNewsLoaded(List<News> newsList, boolean isClear);

        void message(String string);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void onNewsLoaded(List<News> newsList, boolean isClear);

        void saveFavoritedNews(News news);

        void message(String string);

        void fetchData(boolean isClear);
    }

    interface Model extends  MvpContract.Model<Presenter> {
        void fetchDate(boolean isClear);

        void saveFavoritedNews(News news);
    }
}
