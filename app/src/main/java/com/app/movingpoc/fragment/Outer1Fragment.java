package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;


public class Outer1Fragment extends BaseFragment {

    private ImageView mLogo;
    private TextView mSlogan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_training_1, container, false);
        mLogo = (ImageView) view.findViewById(R.id.logo);
        mSlogan = (TextView) view.findViewById(R.id.slogan);
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
            if (mLogo != null)
                startEnterAnimation();
        }
    }

    @Override
    public void startEnterAnimation() {
        if(!isAdded()){
            return;
        }
        if(isRightAnimation) {
            mLogo.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_2));
            mSlogan.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_0));
        } else {
            mLogo.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_2));
            mSlogan.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_0));
        }
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if(!isAdded()){
            return;
        }
        if(isRightAnimation) {
            mLogo.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_2));
            mSlogan.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_0));
        } else {
            mLogo.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_2));
            mSlogan.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_0));
        }
    }
}
