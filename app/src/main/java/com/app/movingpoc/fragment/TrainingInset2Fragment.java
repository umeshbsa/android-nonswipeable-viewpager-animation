package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;

import static com.app.movingpoc.anim.TrainingViewAnimations.OFFSET_0;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingInset2Fragment extends BaseFragment {

    private RelativeLayout mLayoutTop;
    private ImageView mDealsIcon1, mDealsIcon2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_training_inset_2, container, false);
        mLayoutTop = (RelativeLayout) view.findViewById(R.id.layoutTop);
        mDealsIcon1 = (ImageView) view.findViewById(R.id.fragment_inner_two_deals_1);
        mDealsIcon2 = (ImageView) view.findViewById(R.id.fragment_inner_two_deals_2);
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
        mDealsIcon1.startAnimation(TrainingViewAnimations.shakeAnimation());
        mDealsIcon2.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDealsIcon2.startAnimation(TrainingViewAnimations.shakeAnimation());
            }
        }, 700);
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_1));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_1));
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if(!isAdded()){
            return;
        }
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(OFFSET_0));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(OFFSET_0));
    }

}
