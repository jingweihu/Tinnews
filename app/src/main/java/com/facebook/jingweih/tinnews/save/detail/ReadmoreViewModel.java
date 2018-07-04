package com.facebook.jingweih.tinnews.save.detail;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;
import com.facebook.jingweih.tinnews.common.TinFragmentManager;

public class ReadmoreViewModel extends BaseViewModel<ReadmoreViewModel.ReadmoreViewModelHolder> {

    private final String uri;
    private final TinFragmentManager fragmentManager;
    public ReadmoreViewModel(String uri, TinFragmentManager fragmentManager) {
        super(R.layout.readmore_layout);
        this.uri = uri;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ReadmoreViewModelHolder createItemViewHolder(View view) {
        return new ReadmoreViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(ReadmoreViewModelHolder holder) {
        holder.readMore.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        holder.readMore.setOnClickListener(view -> {
            fragmentManager.doFragmentTransaction(WebViewFragment.newInstance(uri));
        });
    }

    static class ReadmoreViewModelHolder extends RecyclerView.ViewHolder {
        TextView readMore;
        ReadmoreViewModelHolder(View itemView) {
            super(itemView);
            readMore = itemView.findViewById(R.id.readmore);
        }
    }
}
