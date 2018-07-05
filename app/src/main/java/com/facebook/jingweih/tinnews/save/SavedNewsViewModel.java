package com.facebook.jingweih.tinnews.save;

import android.support.annotation.DrawableRes;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.common.BaseViewModel;
import com.facebook.jingweih.tinnews.common.LongPressGesture;
import com.facebook.jingweih.tinnews.common.TinFragmentManager;
import com.facebook.jingweih.tinnews.common.Util;
import com.facebook.jingweih.tinnews.retrofit.Response.News;
import com.facebook.jingweih.tinnews.save.detail.SavedNewsDetailedFragment;

public class SavedNewsViewModel extends BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder> {

    private News news;
    private TinFragmentManager fragmentManager;
    private SavedNewsPresenter.DeleteListener deleteListener;
    private static int[] ICON_ARRAY = new int[]{R.drawable.a_news_icon, R.drawable.g_news_icon,
            R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon};

    public SavedNewsViewModel(int itemResourceId, News news, TinFragmentManager fragmentManager, SavedNewsPresenter.DeleteListener deleteListener) {
        super(itemResourceId);
        this.news = news;
        this.fragmentManager = fragmentManager;
        this.deleteListener = deleteListener;
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


        holder.icon.setImageResource(getDrawable());

        GestureDetectorCompat gestureDetector = new GestureDetectorCompat(holder.itemView.getContext(), new LongPressGesture(new LongPressGesture.GestureListener() {
            @Override
            public void onLongPress() {
                TinsBottomDialog dialog = new TinsBottomDialog(holder.itemView.getContext());
                dialog.setOnClickListener(view -> {
                    deleteListener.onDelete(news);
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

            @Override
            public void onPress() {
                fragmentManager.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news));
            }
        }));
        holder.itemView.setOnTouchListener((view, motionEvent) -> {
            gestureDetector.onTouchEvent(motionEvent);
            return true;
        });
    }

    private @DrawableRes int getDrawable() {
        return ICON_ARRAY[(int)(Math.random() * 5)];
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
