package com.facebook.jingweih.tinnews.save;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.ViewModelAdapter;
import com.facebook.jingweih.tinnews.mvp.MvpContract;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.LinkedList;
import java.util.List;

public class SavedNewsFragment extends MvpFragment<SavedNewsContract.Presenter> implements SavedNewsContract.View {

    private ViewModelAdapter viewModelAdapter;
    public static SavedNewsFragment newInstance() {
        SavedNewsFragment tinBasicFragment = new SavedNewsFragment();
        return tinBasicFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;
    }

    @Override
    public SavedNewsContract.Presenter getPresenter() {
        return new SavedNewsPresenter();
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        List<SavedNewsViewModel> savedNewsViewModels = new LinkedList<>();
        for (News news: newsList) {
            savedNewsViewModels.add(new SavedNewsViewModel(R.layout.saved_news_item, news, tinFragmentManager));
        }
        viewModelAdapter.addViewModels(savedNewsViewModels);
    }
}
