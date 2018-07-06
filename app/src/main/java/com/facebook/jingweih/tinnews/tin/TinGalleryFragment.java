package com.facebook.jingweih.tinnews.tin;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;
import com.facebook.jingweih.tinnews.retrofit.Response.News;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class TinGalleryFragment extends MvpFragment<TinContract.Presenter> implements TinContract.View, TinNewsCard.OnSwipeListener {

    private SwipePlaceHolderView mSwipeView;
    private List<News> cacheNews = new ArrayList<>();
    public static TinGalleryFragment newInstance() {
        return  new TinGalleryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        mSwipeView = view.findViewById(R.id.swipeView);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tin_news_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tin_news_swipe_out_msg_view));

        view.findViewById(R.id.rejectBtn).setOnClickListener(v -> {
            mSwipeView.doSwipe(false);
        });

        view.findViewById(R.id.acceptBtn).setOnClickListener(v ->  {
            mSwipeView.doSwipe(true);
        });

        return view;
    }

    @Override
    public TinContract.Presenter getPresenter() {
        return new TinPresenter();
    }

    @Override
    public void onNewsLoaded(List<News> newsList, boolean isClear) {
        if (isClear) {
            cacheNews.clear();
            mSwipeView.removeAllViews();
        }
        cacheNews.addAll(newsList);
        for (News news : newsList) {
            mSwipeView.addView(new TinNewsCard(news, mSwipeView, this));
        }
    }

    @Override
    public void message(String string) {
        tinFragmentManager.showSnackBar(string);
    }

    @Override
    public void onLike(News news) {
        cacheNews.remove(news);
        presenter.saveFavoritedNews(news);
        if (cacheNews.size() < 4) {
            presenter.fetchData(false);
        }
    }
}
