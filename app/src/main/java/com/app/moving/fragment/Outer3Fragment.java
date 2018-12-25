package com.app.moving.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.moving.R;
import com.app.moving.utils.Utils;


public class Outer3Fragment extends BaseFragment {

    private TextView mOuter3Tv, mOuter3DescTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outer_3, container, false);
        mOuter3Tv = (TextView) view.findViewById(R.id.tv_outer3_title);
        mOuter3DescTv = (TextView) view.findViewById(R.id.tv_outer3_desc);
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
        if(!isAdded()){
            return;
        }
        if (isRightAnimation) {
            mOuter3Tv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_2));
            mOuter3DescTv.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_0));
        } else {
            mOuter3Tv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_2));
            mOuter3DescTv.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if(!isAdded()){
            return;
        }
        if (isRightAnimation) {
            mOuter3Tv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_2));
            mOuter3DescTv.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_0));
        } else {
            mOuter3Tv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_2));
            mOuter3DescTv.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_0));
        }
    }

}
