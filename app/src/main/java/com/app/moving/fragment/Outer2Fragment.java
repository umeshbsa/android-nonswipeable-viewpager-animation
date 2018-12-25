package com.app.moving.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.moving.R;
import com.app.moving.utils.Utils;


public class Outer2Fragment extends BaseFragment {

    private TextView mOuter2TitleTv;
    private TextView mOuter2DescTv;
    private LinearLayout mOuter2LinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent_2, container, false);
        mOuter2TitleTv = (TextView) view.findViewById(R.id.tv_outer2_title);
        mOuter2DescTv = (TextView) view.findViewById(R.id.tv_outer2_description);
        mOuter2LinearLayout = (LinearLayout) view.findViewById(R.id.linear_outer2);
        mOuter2LinearLayout.setVisibility(View.VISIBLE);
        setExitDuration(Utils.TO_LEFT_DURATION + 200);
        return view;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            startEnterAnimation();
        }
    }

    @Override
    public void startEnterAnimation() {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation) {
            mOuter2TitleTv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_2));
            mOuter2DescTv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_0));
        } else {
            mOuter2TitleTv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_2));
            mOuter2DescTv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation) {
            mOuter2TitleTv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_2));
            mOuter2DescTv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_0));
        } else {
            mOuter2TitleTv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_2));
            mOuter2DescTv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_0));
        }
    }

}
