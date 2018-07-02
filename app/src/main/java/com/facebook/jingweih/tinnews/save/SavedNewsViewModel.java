package com.facebook.jingweih.tinnews.save;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;
import com.facebook.jingweih.tinnews.common.TinFragmentManager;
import com.facebook.jingweih.tinnews.common.Util;
import com.facebook.jingweih.tinnews.retrofit.Response.News;
import com.facebook.jingweih.tinnews.save.detail.SavedNewsDetailedFragment;

public class SavedNewsViewModel extends BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder> {

    private News news;
    private TinFragmentManager fragmentManager;

    public SavedNewsViewModel(int itemResourceId, News news, TinFragmentManager fragmentManager) {
        super(itemResourceId);
        this.news = news;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public SavedNewsViewHolder createItemViewHolder(View view) {
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void bindViewHolder(SavedNewsViewHolder holder) {
        if (!Util.isStringEmpty(news.author)) {
            holder.author.setText(news.author);
        }
        holder.description.setText(news.getDescription());

        holder.icon.setImageResource(R.drawable.ic_t_icon);

        holder.itemView.setOnClickListener(view -> {
            fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
        });
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }

}
