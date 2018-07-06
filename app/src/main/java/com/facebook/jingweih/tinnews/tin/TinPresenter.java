package com.facebook.jingweih.tinnews.tin;

import com.facebook.jingweih.tinnews.profile.country.CountryChangeEvent;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        EventBus.getDefault().register(this);
        this.view = view;
        tinModel.fetchDate(false);
    }

    @Override
    public void onViewDetached() {
        this.view = null;
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onNewsLoaded(List<News> newsList, boolean isClear) {
        if (view != null) {
            view.onNewsLoaded(newsList, isClear);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CountryChangeEvent event) {
        tinModel.fetchDate(true);
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

    @Override
    public void fetchData(boolean isClear) {
        if (this.view != null) {
            tinModel.fetchDate(false);
        }
    }
}
