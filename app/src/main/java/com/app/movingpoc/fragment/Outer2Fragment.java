package com.app.movingpoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.movingpoc.R;
import com.app.movingpoc.utils.AnimationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class Outer2Fragment extends BaseFragment {

    private TextView mTitle, mSubTitle;
    private LinearLayout mLayoutTop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outer_2, container, false);
        mTitle = (TextView) view.findViewById(R.id.title);
        mSubTitle = (TextView) view.findViewById(R.id.subtitle);
        mLayoutTop = (LinearLayout) view.findViewById(R.id.layoutTop);
        mLayoutTop.setVisibility(View.VISIBLE);
        setExitDuration(AnimationUtils.TO_LEFT_DURATION + 200);
        mSubTitle.setText(getString(R.string.training_money_description_text, "Bank Card"));
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
            mTitle.startAnimation(AnimationUtils.rightToLeftEnterAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.rightToLeftEnterAnimation(AnimationUtils.OFFSET_0));
        } else {
            mTitle.startAnimation(AnimationUtils.leftToRightEnterAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.leftToRightEnterAnimation(AnimationUtils.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if(!isAdded()){
            return;
        }
        if (isRightAnimation) {
            mTitle.startAnimation(AnimationUtils.rightToLeftExitAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.rightToLeftExitAnimation(AnimationUtils.OFFSET_0));
        } else {
            mTitle.startAnimation(AnimationUtils.leftToRightExitAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.leftToRightExitAnimation(AnimationUtils.OFFSET_0));
        }
    }

}
