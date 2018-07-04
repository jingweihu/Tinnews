package com.facebook.jingweih.tinnews.profile;

import android.view.View;

import com.facebook.jingweih.tinnews.mvp.MvpContract;

public class ProfileContract {

    interface View extends MvpContract.View<Presenter> {
        void setView();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {


        android.view.View.OnClickListener getListener();
    }

    interface Model extends MvpContract.Model<Presenter> {
        void deleteAllNewsCache();
    }
}

