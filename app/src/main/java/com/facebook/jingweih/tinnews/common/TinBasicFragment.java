package com.facebook.jingweih.tinnews.common;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.mvp.MvpContract;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TinBasicFragment extends Fragment  {

    protected TinFragmentManager tinFragmentManager;
    private final String uuid = UUID.randomUUID().toString();

    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        tinFragmentManager = (TinFragmentManager) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tin_basic, container, false);
    }

    public String getFragmentTag() {
        return this.getClass().getName() + uuid;
    }

}
