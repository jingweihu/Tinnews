package com.facebook.jingweih.tinnews.save.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;
import com.facebook.jingweih.tinnews.common.Util;
import com.facebook.jingweih.tinnews.common.ViewModelAdapter;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

import java.util.LinkedList;
import java.util.List;

public class SavedNewsDetailedFragment extends MvpFragment<SavedNewsDetailedContract.Presenter> implements SavedNewsDetailedContract.View {


    private static final String NEWS = "news";
    private ViewModelAdapter viewModelAdapter;
    public static SavedNewsDetailedFragment newInstance(News news) {

        Bundle args = new Bundle();
        args.putParcelable(NEWS, news);
        SavedNewsDetailedFragment fragment = new SavedNewsDetailedFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.recycler_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModelAdapter = new ViewModelAdapter();
        recyclerView.setAdapter(viewModelAdapter);
        return view;
    }

    @Override
    public SavedNewsDetailedContract.Presenter getPresenter() {
        return new SavedNewsDetailedPresenter(getArguments().getParcelable(NEWS));
    }

    @Override
    public void loadNews(News news) {
        List<BaseViewModel> viewModels = new LinkedList<>();
        viewModels.add(new TitleViewModel(news.title));
        if (!Util.isStringEmpty(news.author) || !Util.isStringEmpty(news.time)) {
            viewModels.add(new AuthorViewModel(news.author, news.time));
        }

        if (!Util.isStringEmpty((news.image))) {
            viewModels.add(new ImageViewModel(news.image));
        }

        if (!Util.isStringEmpty(news.description)) {
            viewModels.add(new DescriptionViewModel(news.description));
        }

        if (!Util.isStringEmpty(news.url)) {
            viewModels.add(new ReadmoreViewModel(news.url, tinFragmentManager));
        }
        viewModelAdapter.addViewModels(viewModels);
    }
}
