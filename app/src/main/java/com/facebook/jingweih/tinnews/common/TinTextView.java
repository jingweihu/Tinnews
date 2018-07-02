package com.facebook.jingweih.tinnews.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TinTextView extends TextView {
    public TinTextView(Context context) {
        super(context);
    }

    public TinTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TinTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
