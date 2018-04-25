package com.app.movingpoc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingInset1Fragment extends BaseFragment {

    private View mViewOverlay;
    private LinearLayout mLayoutTop;
    private ImageView mImageView1;
    private ImageView mImageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_training_inset_1, container, false);
        mLayoutTop = (LinearLayout) view.findViewById(R.id.layoutTop);
        mViewOverlay = view.findViewById(R.id.fragment_inner_one_viewChartOverlay);
        mImageView1 = (ImageView) view.findViewById(R.id.imageView_1);
        mImageView2 = (ImageView) view.findViewById(R.id.imageView_2);
        startEnterAnimation();
        return view;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if (mLayoutTop != null) {
                startEnterAnimation();
            }
        }
    }

    @Override
    public void startEnterAnimation() {
        if(!isAdded()){
            return;
        }
        mViewOverlay.startAnimation(TrainingViewAnimations.leftToRightOverlayInset());
        mImageView1.startAnimation(scaleUpWithBounce());
        mImageView2.startAnimation(scaleUpWithBounce());
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
        mImageView1.startAnimation(scaleDown());
        mImageView2.startAnimation(scaleDown());
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_2));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_2));
    }

    private Animation scaleUpWithBounce() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new JellyBounceInterpolator());
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2200);
        scaleAnimation.setStartOffset(900);
        return scaleAnimation;
    }

    private Animation scaleDown() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0, 1, 0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300);
        scaleAnimation.setStartOffset(100);
        return scaleAnimation;
    }


    public class JellyBounceInterpolator implements Interpolator {
        @Override
        public float getInterpolation(float ratio) {
            if (ratio == 0.0f || ratio == 1.0f) {
                return ratio;
            }
            else {
                float p = 0.2f;
                float two_pi = (float) (Math.PI * 2.0f);
                return (float) Math.pow(4.0f, -10.0f * ratio) * (float) Math.sin((ratio - (p / 5.0f)) * two_pi / p) + 1.0f;
            }
        }
    }


}
