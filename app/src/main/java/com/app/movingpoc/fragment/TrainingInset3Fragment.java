package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingInset3Fragment extends BaseFragment {

    private LinearLayout mRowView, mLayoutTop;
    private ImageView mImageHidden;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_training_inset_3, container, false);
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
        mRowView.startAnimation(TrainingViewAnimations.rightToLeftViewInnerFragmentThree());
        mImageHidden.startAnimation(TrainingViewAnimations.rightToLeftHiddenViewInnerFragmentThree());
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_1));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_1));
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_0));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_0));
    }

}
