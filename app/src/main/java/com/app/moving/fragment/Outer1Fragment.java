package com.app.moving.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.moving.R;
import com.app.moving.utils.Utils;


public class Outer1Fragment extends BaseFragment {

    private TextView mAppLogoTv;
    private TextView mAppNameTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent_1, container, false);
        mAppLogoTv = (TextView) view.findViewById(R.id.tv_logo);
        mAppNameTv = (TextView) view.findViewById(R.id.tv_app_name);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        startEnterAnimation();
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if (mAppLogoTv != null)
                startEnterAnimation();
        }
    }

    @Override
    public void startEnterAnimation() {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation) {
            mAppLogoTv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_2));
            mAppNameTv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_0));
        } else {
            mAppLogoTv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_2));
            mAppNameTv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation) {
            mAppLogoTv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_2));
            mAppNameTv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_0));
        } else {
            mAppLogoTv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_2));
            mAppNameTv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_0));
        }
    }
}
