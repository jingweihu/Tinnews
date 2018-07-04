package com.facebook.jingweih.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;

public class AuthorViewModel extends BaseViewModel<AuthorViewModel.AuthorViewModelHolder> {

    private final String author;
    private final String timeStamp;

    public AuthorViewModel(String author, String timeStamp) {
        super(R.layout.author_layout);
        this.author = author;
        this.timeStamp = timeStamp;
    }

    @Override
    public AuthorViewModelHolder createItemViewHolder(View view) {
        return new AuthorViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(AuthorViewModelHolder holder) {
        holder.author.setText(author);
        holder.timeStamp.setText(timeStamp);
    }

    static class AuthorViewModelHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView timeStamp;
        AuthorViewModelHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            timeStamp = itemView.findViewById(R.id.time_stamp);
        }
    }
}
