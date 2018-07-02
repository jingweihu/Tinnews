package com.facebook.jingweih.tinnews.save.detail;

import com.facebook.jingweih.tinnews.mvp.MvpContract;

public class SavedNewsDetailedContract {

    interface View extends MvpContract.View<Presenter> {
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
    }

    interface Model extends MvpContract.Model<Presenter> {
    }
}
