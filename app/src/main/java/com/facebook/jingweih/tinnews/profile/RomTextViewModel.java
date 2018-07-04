package com.facebook.jingweih.tinnews.profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;

public class RomTextViewModel extends BaseViewModel<RomTextViewModel.RomTextViewModelHolder> {

    private final String rowText;
    private final View.OnClickListener listener;
    public RomTextViewModel(String rowText, View.OnClickListener listener) {
        super(R.layout.row_text_layout);
        this.rowText = rowText;
        this.listener = listener;
    }

    @Override
    public RomTextViewModelHolder createItemViewHolder(View view) {
        return new RomTextViewModelHolder(view);
    }

    @Override
    public void bindViewHolder(RomTextViewModelHolder holder) {
        holder.row.setText(rowText);
        holder.row.setOnClickListener(listener);
    }

    static class RomTextViewModelHolder extends RecyclerView.ViewHolder {
        TextView row;
        RomTextViewModelHolder(View itemView) {
            super(itemView);
            row = itemView.findViewById(R.id.row_text);
        }
    }
}
