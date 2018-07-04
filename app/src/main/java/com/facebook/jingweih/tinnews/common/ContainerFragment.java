package com.facebook.jingweih.tinnews.common;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.jingweih.tinnews.profile.TinProfileFragment;
import com.facebook.jingweih.tinnews.save.SavedNewsFragment;
import com.facebook.jingweih.tinnews.R;
import com.facebook.jingweih.tinnews.mvp.MvpContract;
import com.facebook.jingweih.tinnews.tin.TinGalleryFragment;

public class ContainerFragment extends TinBasicFragment {
    public static final int HOME_PAGE = 0;
    public static final String HOME_PAGE_TAG = "home_page";
    public static final int SAVE_PAGE = 1;
    public static final String SAVE_PAGE_TAG = "save_page";
    public static final int PROFILE_PAGE = 2;
    public static final String PROFILE_PAGE_TAG = "profile_page";

    private Fragment initFragment;
    private int pageIdnex;


    public static ContainerFragment newInstance(int pageIndex) {
        ContainerFragment containerFragment = new ContainerFragment();
        containerFragment.initFragment = createByIndex(pageIndex);
        containerFragment.pageIdnex = pageIndex;
        return containerFragment;
    }


    public static TinBasicFragment createByIndex(int position) {
        switch (position) {
            case HOME_PAGE:
                return TinGalleryFragment.newInstance();
            case SAVE_PAGE:
                return SavedNewsFragment.newInstance();
            case PROFILE_PAGE:
                return TinProfileFragment.newInstance();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public static int getIdByIndex(int position) {
        switch (position) {
            case HOME_PAGE:
                return R.id.action_tin;
            case SAVE_PAGE:
                return R.id.action_save;
            case PROFILE_PAGE:
                return R.id.action_profile;
            default:
                throw new IndexOutOfBoundsException();
        }
    }


    public static int getPositionById(int id) {
        switch (id) {
            case R.id.action_tin:
                return HOME_PAGE;
            case R.id.action_save:
                return SAVE_PAGE;
            case R.id.action_profile:
                return PROFILE_PAGE;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (initFragment != null && !initFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().replace(R.id.child_fragment_container, initFragment, getCurrentTag(pageIdnex))
                    .commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child_fragment_container, container, false);
    }

    public static String getCurrentTag(int position) {
        switch (position) {
            case HOME_PAGE:
                return HOME_PAGE_TAG;
            case SAVE_PAGE:
                return SAVE_PAGE_TAG;
            case PROFILE_PAGE:
                return PROFILE_PAGE_TAG;
            default:
                return null;
        }
    }




}
