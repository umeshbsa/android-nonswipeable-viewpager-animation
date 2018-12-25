package com.app.moving.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.moving.R;
import com.app.moving.utils.Utils;

public class Child2Fragment extends BaseFragment {

    private View mCharOverLay;
    private LinearLayout mChild2RootLinear;
    private ImageView mImageView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_2, container, false);

        mChild2RootLinear = (LinearLayout) view.findViewById(R.id.linear_child2_root);
        mCharOverLay = view.findViewById(R.id.fragment_child_over_chart);
        mImageView1 = (ImageView) view.findViewById(R.id.imageView_1);
        startEnterAnimation();
        return view;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if (mChild2RootLinear != null) {
                startEnterAnimation();
            }
        }
    }

    @Override
    public void startEnterAnimation() {
        if (!isAdded()) {
            return;
        }
        mCharOverLay.startAnimation(Utils.leftToRightOverlayInset());
        mImageView1.startAnimation(scaleUpWithBounce());
        if (isRightAnimation)
            mChild2RootLinear.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_1));
        else
            mChild2RootLinear.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_1));
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        mImageView1.startAnimation(scaleDown());
        if (isRightAnimation)
            mChild2RootLinear.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_2));
        else
            mChild2RootLinear.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_2));
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
            } else {
                float p = 0.2f;
                float two_pi = (float) (Math.PI * 2.0f);
                return (float) Math.pow(4.0f, -10.0f * ratio) * (float) Math.sin((ratio - (p / 5.0f)) * two_pi / p) + 1.0f;
            }
        }
    }


}
