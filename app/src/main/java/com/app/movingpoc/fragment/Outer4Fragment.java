package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;

/**
 * A simple {@link Fragment} subclass.
 */
public class Outer4Fragment extends BaseFragment {

    private TextView mTitle, mSubTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_training_4, container, false);
        mTitle = (TextView) view.findViewById(R.id.title);
        mSubTitle = (TextView) view.findViewById(R.id.subtitle);
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
            mTitle.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_2));
            mSubTitle.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_0));
        } else {
            mTitle.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_2));
            mSubTitle.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if(!isAdded()){
            return;
        }
        if (isRightAnimation) {
            mTitle.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_2));
            mSubTitle.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_0));
        } else {
            mTitle.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_2));
            mSubTitle.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_0));
        }
    }

}
