package com.facebook.jingweih.tinnews.profile;

import android.view.View;

import com.facebook.jingweih.tinnews.mvp.MvpContract;

public class ProfileContract {

    interface View extends MvpContract.View<Presenter> {
        void setView();
        boolean isViewEmpty();
        void onCacheCleared();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void onCacheCleared();
        android.view.View.OnClickListener getCacheClearListener();
    }

    interface Model extends MvpContract.Model<Presenter> {
        void deleteAllNewsCache();
    }
}

