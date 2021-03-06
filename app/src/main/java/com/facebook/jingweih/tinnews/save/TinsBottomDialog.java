package com.facebook.jingweih.tinnews.save;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

import com.facebook.jingweih.tinnews.R;

public class TinsBottomDialog extends BottomSheetDialog {

    private View.OnClickListener listener;
    public TinsBottomDialog(@NonNull Context context) {
        super(context, R.style.BottomSheetDialog);
        setContentView(R.layout.bottomdialog_layout);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStart() {
        this.findViewById(R.id.delete).setOnClickListener(listener);
        this.findViewById(R.id.back).setOnClickListener(v -> {
            dismiss();
        });
    }

}
