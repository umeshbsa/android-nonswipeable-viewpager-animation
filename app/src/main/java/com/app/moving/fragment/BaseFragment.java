package com.app.moving.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.moving.utils.Utils;


public abstract class BaseFragment extends Fragment {

    public static boolean isRightAnimation = true;
    private int mExitDuration = Utils.TO_LEFT_DURATION;
    protected boolean isEnterAnimationStarted;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void setExitDuration(int duration) {
        mExitDuration = duration;
    }

    public int exitDuration() {
        return mExitDuration;
    }

    public abstract void startEnterAnimation();

    public abstract void startExitAnimation(boolean isRightAnimation);

}
