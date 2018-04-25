package com.app.movingpoc.fragment;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.movingpoc.R;
import com.app.movingpoc.utils.AnimationUtils;
import com.app.movingpoc.utils.AppUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inner5Fragment extends BaseFragment {

    private View mRootView;

    private final int OFFSET = 120;

    private RelativeLayout mLayoutTop;
    private View mOverlayTranslateView;
    private View mOvalTick;
    private TextView mAmountText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_inner_5, container, false);
        mLayoutTop = (RelativeLayout) mRootView.findViewById(R.id.layoutTop);
        mOverlayTranslateView = mRootView.findViewById(R.id.overlay_translate_view);
        mOvalTick = mRootView.findViewById(R.id.oval_tick);
        mAmountText = (TextView) mRootView.findViewById(R.id.amount_txt);

        return mRootView;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if(mLayoutTop != null && !isEnterAnimationStarted) {
                isEnterAnimationStarted = true;
                startEnterAnimation();
            }
        }
    }

    @Override
    public void startEnterAnimation() {
        if (isRightAnimation) {
            mLayoutTop.startAnimation(AnimationUtils.rightToLeftEnterAnimation(AnimationUtils.OFFSET_1));
        }
        else {
            mLayoutTop.startAnimation(AnimationUtils.leftToRightEnterAnimation(AnimationUtils.OFFSET_1));
        }
        animateRowsTowardLeft();
        animateOverlayTranslateView();
        mAmountText.clearAnimation();
        mAmountText.requestLayout();
        mOvalTick.clearAnimation();
        mOvalTick.setVisibility(View.INVISIBLE);
        mOvalTick.requestLayout();
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (isRightAnimation) {
            mAmountText.startAnimation(AnimationUtils.rightToLeftExitAnimation(OFFSET * 0));

            mRootView.findViewById(R.id.hr_1).startAnimation(AnimationUtils.rightToLeftExitAnimation((long) (OFFSET * 0.5)));
            mRootView.findViewById(R.id.row_1).startAnimation(AnimationUtils.rightToLeftExitAnimation(OFFSET * 1));

            mRootView.findViewById(R.id.hr_2).startAnimation(AnimationUtils.rightToLeftExitAnimation((long) (OFFSET * 1.5)));
            mRootView.findViewById(R.id.row_2).startAnimation(AnimationUtils.rightToLeftExitAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_3).startAnimation(AnimationUtils.rightToLeftExitAnimation((long) (OFFSET * 2.5)));
            mRootView.findViewById(R.id.row_3).startAnimation(AnimationUtils.rightToLeftExitAnimation(OFFSET * 3));

            mRootView.findViewById(R.id.hr_4).startAnimation(AnimationUtils.rightToLeftExitAnimation((long) (OFFSET * 3.5)));
            mRootView.findViewById(R.id.row_4).startAnimation(AnimationUtils.rightToLeftExitAnimation(OFFSET * 4));

            mLayoutTop.startAnimation(AnimationUtils.rightToLeftExitAnimation(450));
        }
        else {
            mAmountText.startAnimation(AnimationUtils.leftToRightExitAnimation(OFFSET * 0));

            mRootView.findViewById(R.id.hr_1).startAnimation(AnimationUtils.leftToRightExitAnimation((long) (OFFSET * 0.5)));
            mRootView.findViewById(R.id.row_1).startAnimation(AnimationUtils.leftToRightExitAnimation(OFFSET * 1));

            mRootView.findViewById(R.id.hr_2).startAnimation(AnimationUtils.leftToRightExitAnimation((long) (OFFSET * 1.5)));
            mRootView.findViewById(R.id.row_2).startAnimation(AnimationUtils.leftToRightExitAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_3).startAnimation(AnimationUtils.leftToRightExitAnimation((long) (OFFSET * 2.5)));
            mRootView.findViewById(R.id.row_3).startAnimation(AnimationUtils.leftToRightExitAnimation(OFFSET * 3));

            mRootView.findViewById(R.id.hr_4).startAnimation(AnimationUtils.leftToRightExitAnimation((long) (OFFSET * 3.5)));
            mRootView.findViewById(R.id.row_4).startAnimation(AnimationUtils.leftToRightExitAnimation(OFFSET * 4));

            mLayoutTop.startAnimation(AnimationUtils.leftToRightExitAnimation(450));
        }
        isEnterAnimationStarted = false;
    }

    /////////////////// Screen 1 Animations ////////////////////////

    private void animateRowsTowardLeft() {
        mAmountText.startAnimation(AnimationUtils.alphaVisibleAnimation(OFFSET * 4));

        if (isRightAnimation) {
            mRootView.findViewById(R.id.hr_1).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 1));
            mRootView.findViewById(R.id.row_1).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_2).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 3));
            mRootView.findViewById(R.id.row_2).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 4));

            mRootView.findViewById(R.id.hr_3).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 5));
            mRootView.findViewById(R.id.row_3).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 6));

            mRootView.findViewById(R.id.hr_4).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 7));
            mRootView.findViewById(R.id.row_4).startAnimation(AnimationUtils.rightToLeftEnterAnimation(OFFSET * 8));
        }
        else {
            mRootView.findViewById(R.id.hr_1).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 1));
            mRootView.findViewById(R.id.row_1).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_2).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 3));
            mRootView.findViewById(R.id.row_2).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 4));

            mRootView.findViewById(R.id.hr_3).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 5));
            mRootView.findViewById(R.id.row_3).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 6));

            mRootView.findViewById(R.id.hr_4).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 7));
            mRootView.findViewById(R.id.row_4).startAnimation(AnimationUtils.leftToRightEnterAnimation(OFFSET * 8));
        }
    }

    private float mTranslateYHolder;
    private void animateOverlayTranslateView() {
        mOverlayTranslateView.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(OFFSET * 9);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        mOverlayTranslateView.startAnimation(alphaAnimation);

        mTranslateYHolder = mOverlayTranslateView.getTranslationY();
        objectTranslate(0, OFFSET * 12);
    }

    private void objectTranslate(final int i, int offset) {

        if (i >= 2) {

            ValueAnimator animateText = ValueAnimator.ofInt(136, 56);
            animateText.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (int) valueAnimator.getAnimatedValue();
                    mAmountText.setText("$" + val + ".00");
                }
            });
            animateText.setDuration(700);
            animateText.setStartDelay(0);
            animateText.start();

            final View view = mRootView.findViewById(R.id.overlay_ripple_view);
            Animation animation = AnimationUtils.rippleAnimation(0);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mOverlayTranslateView.startAnimation(AnimationUtils.alphaHideAnimation(0));
                    mOverlayTranslateView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mOverlayTranslateView.setTranslationY(mTranslateYHolder);
                        }
                    }, 800);
                    view.startAnimation(AnimationUtils.alphaHideAnimation(0));

                    mOvalTick.setVisibility(View.VISIBLE);
                    mOvalTick.startAnimation(scaleUpWithBounce(OFFSET * 2, 1800));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            view.startAnimation(animation);
            return;
        }

        ObjectAnimator translateAnim = ObjectAnimator.ofFloat(mOverlayTranslateView, "translationY",
                mOverlayTranslateView.getTranslationY(),
                mOverlayTranslateView.getTranslationY() + mOverlayTranslateView.getHeight() + AppUtils.dpToPx(getActivity(), 1));
        translateAnim.setStartDelay(offset);
        translateAnim.setDuration(300);
        translateAnim.start();
        translateAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                objectTranslate(i + 1, 60);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }


    private Animation scaleUpWithBounce(int offset, int duration) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new JellyBounceInterpolator());
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(duration);
        scaleAnimation.setStartOffset(offset);
        return scaleAnimation;
    }

    public class JellyBounceInterpolator implements Interpolator {
        @Override
        public float getInterpolation(float ratio) {
            if (ratio == 0.0f || ratio == 1.0f)
                return ratio;
            else {
                float p = 0.2f;
                float two_pi = (float) (Math.PI * 1.5f);
                return (float) Math.pow(10.0f, -5.0f * ratio) * (float) Math.sin((ratio - (p / 5.0f)) * two_pi / p) + 1.0f;
            }
        }
    }

}
