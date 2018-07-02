package com.facebook.jingweih.tinnews.save.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.mvp.MvpFragment;
import com.facebook.jingweih.tinnews.retrofit.Response.News;

public class SavedNewsDetailedFragment extends MvpFragment<SavedNewsDetailedContract.Presenter> implements SavedNewsDetailedContract.View {


    private static final String NEWS = "news";
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
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }



    @Override
    public SavedNewsDetailedContract.Presenter getPresenter() {
        return null;
    }
}
