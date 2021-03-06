package com.facebook.jingweih.tinnews.save.detail;

import com.facebook.jingweih.tinnews.mvp.MvpContract;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

public class SavedNewsDetailedContract {

    interface View extends MvpContract.View<Presenter> {
        void loadNews(News news);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
    }

    interface Model extends MvpContract.Model<Presenter> {
    }
}
