package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.movingpoc.R;
import com.app.movingpoc.utils.AnimationUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Outer5Fragment extends BaseFragment {

    private TextView mTitle, mSubTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outer_5, container, false);
        mTitle = (TextView) view.findViewById(R.id.title);
        mSubTitle = (TextView) view.findViewById(R.id.subtitle);
        setExitDuration(AnimationUtils.TO_LEFT_DURATION + 400);
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
        if (isRightAnimation) {
            mTitle.startAnimation(AnimationUtils.rightToLeftExitAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.rightToLeftExitAnimation(AnimationUtils.OFFSET_0));
        } else {
            mTitle.startAnimation(AnimationUtils.leftToRightExitAnimation(AnimationUtils.OFFSET_2));
            mSubTitle.startAnimation(AnimationUtils.leftToRightExitAnimation(AnimationUtils.OFFSET_0));
        }
    }

}
