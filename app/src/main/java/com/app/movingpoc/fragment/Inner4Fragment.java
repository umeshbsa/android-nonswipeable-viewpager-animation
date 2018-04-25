package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.movingpoc.R;
import com.app.movingpoc.utils.AnimationUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inner4Fragment extends BaseFragment {

    private LinearLayout mRowView, mLayoutTop;
    private ImageView mImageHidden;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inner_4, container, false);
        mLayoutTop = (LinearLayout) view.findViewById(R.id.layoutTop);
        mRowView = (LinearLayout) view.findViewById(R.id.fragment_inner_three_row_view);
        mImageHidden = (ImageView) view.findViewById(R.id.fragment_inner_three_row_hidden_view);

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
        mRowView.startAnimation(AnimationUtils.rightToLeftViewInnerFragmentThree());
        mImageHidden.startAnimation(AnimationUtils.rightToLeftHiddenViewInnerFragmentThree());
        if (isRightAnimation)
            mLayoutTop.startAnimation(AnimationUtils.rightToLeftEnterAnimation(AnimationUtils.OFFSET_1));
        else
            mLayoutTop.startAnimation(AnimationUtils.leftToRightEnterAnimation(AnimationUtils.OFFSET_1));
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation)
            mLayoutTop.startAnimation(AnimationUtils.rightToLeftExitAnimation(AnimationUtils.OFFSET_0));
        else
            mLayoutTop.startAnimation(AnimationUtils.leftToRightExitAnimation(AnimationUtils.OFFSET_0));
    }

}
