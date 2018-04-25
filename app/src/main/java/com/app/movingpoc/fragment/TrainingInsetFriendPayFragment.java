package com.app.movingpoc.fragment;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.movingpoc.utils.AppUtils;
import com.app.movingpoc.R;
import com.app.movingpoc.anim.TrainingViewAnimations;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrainingInsetFriendPayFragment extends BaseFragment {

    private View mRootView;

    private final int OFFSET = 120;
    private View mScreen1Layout;
    private View mScreen2Layout;

    private RelativeLayout mLayoutTop;
    private View mOverlayTranslateView;
    private ImageView mImageToBeEnlarged;
    private ImageView mImageEnlarged;
    private LinearLayout mRow4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.f_training_inset_friend_pay, container, false);
        mLayoutTop = (RelativeLayout) mRootView.findViewById(R.id.layoutTop);
        mScreen1Layout = mRootView.findViewById(R.id.screen_1_layout);
        mScreen1Layout.setVisibility(View.VISIBLE);
        mScreen2Layout = mRootView.findViewById(R.id.screen_2_layout);
        mOverlayTranslateView = mRootView.findViewById(R.id.overlay_translate_view);
        mImageToBeEnlarged = (ImageView) mRootView.findViewById(R.id.row_image_toBeEnlarged);
        mImageEnlarged = (ImageView) mRootView.findViewById(R.id.enlarge_male_image);
        mRow4 = (LinearLayout) mRootView.findViewById(R.id.row_4);

        return mRootView;
    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            if (mLayoutTop != null && !isEnterAnimationStarted) {
                isEnterAnimationStarted = true;
                startEnterAnimation();
            }
        }
    }

    @Override
    public void startEnterAnimation() {
        if (isRightAnimation)
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_1));
        else
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_1));
        animateRowsTowardLeft();
        animateOverlayTranslateView();

        mImageEnlarged.clearAnimation();
        mImageEnlarged.requestLayout();

        View ovalBg = mRootView.findViewById(R.id.oval_bg);
        ovalBg.setVisibility(View.INVISIBLE);
        ovalBg.clearAnimation();
        ovalBg.requestLayout();

        View ovalTick = mRootView.findViewById(R.id.oval_tick);
        ovalTick.setVisibility(View.INVISIBLE);
        ovalTick.clearAnimation();
        ovalTick.requestLayout();

        mScreen2Layout.clearAnimation();
        mScreen2Layout.setVisibility(View.INVISIBLE);

        View rule1 = mRootView.findViewById(R.id.horizontal_rule_1);
        rule1.setVisibility(View.VISIBLE);
        rule1.clearAnimation();
        rule1.requestLayout();

        View rule2 = mRootView.findViewById(R.id.horizontal_rule_2);
        rule2.setVisibility(View.VISIBLE);
        rule2.clearAnimation();
        rule2.requestLayout();
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (isRightAnimation) {
            mImageEnlarged.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(0));
            mRootView.findViewById(R.id.horizontal_rule_1).startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(200));
            mRootView.findViewById(R.id.horizontal_rule_2).startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(200));
            mRootView.findViewById(R.id.oval_bg).startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(400));
            mRootView.findViewById(R.id.oval_tick).startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(400));
            mLayoutTop.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(450));
        } else {
            mImageEnlarged.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(0));
            mRootView.findViewById(R.id.horizontal_rule_1).startAnimation(TrainingViewAnimations.leftToRightExitAnimation(200));
            mRootView.findViewById(R.id.horizontal_rule_2).startAnimation(TrainingViewAnimations.leftToRightExitAnimation(200));
            mRootView.findViewById(R.id.oval_bg).startAnimation(TrainingViewAnimations.leftToRightExitAnimation(400));
            mRootView.findViewById(R.id.oval_tick).startAnimation(TrainingViewAnimations.leftToRightExitAnimation(400));
            mLayoutTop.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(450));
        }
        isEnterAnimationStarted = false;
    }

    /////////////////// Screen 1 Animations ////////////////////////

    private void animateRowsTowardLeft() {
        if (isRightAnimation) {
            mRootView.findViewById(R.id.hr_1).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 1));
            mRootView.findViewById(R.id.row_1).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_2).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 3));
            mRootView.findViewById(R.id.row_2).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 4));

            mRootView.findViewById(R.id.hr_3).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 5));
            mRootView.findViewById(R.id.row_3).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 6));

            mRootView.findViewById(R.id.hr_4).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 7));
            mRootView.findViewById(R.id.row_4).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 8));

            mRootView.findViewById(R.id.hr_5).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 9));
            mRootView.findViewById(R.id.row_5).startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(OFFSET * 10));
        } else {
            mRootView.findViewById(R.id.hr_1).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 1));
            mRootView.findViewById(R.id.row_1).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 2));

            mRootView.findViewById(R.id.hr_2).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 3));
            mRootView.findViewById(R.id.row_2).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 4));

            mRootView.findViewById(R.id.hr_3).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 5));
            mRootView.findViewById(R.id.row_3).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 6));

            mRootView.findViewById(R.id.hr_4).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 7));
            mRootView.findViewById(R.id.row_4).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 8));

            mRootView.findViewById(R.id.hr_5).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 9));
            mRootView.findViewById(R.id.row_5).startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(OFFSET * 10));
        }
    }

    private float mTranslateYHolder;

    private void animateOverlayTranslateView() {
        mOverlayTranslateView.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(OFFSET * 11);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        mOverlayTranslateView.startAnimation(alphaAnimation);
        mTranslateYHolder = mOverlayTranslateView.getTranslationY();
        objectTranslate(0, OFFSET * 14);
    }

    private void objectTranslate(final int i, int offset) {

        if (i >= 3) {
            final View view = mRootView.findViewById(R.id.overlay_ripple_view);
            Animation animation = TrainingViewAnimations.rippleAnimation(0);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    animateScreen2();
                    mOverlayTranslateView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mOverlayTranslateView.setTranslationY(mTranslateYHolder);
                        }
                    }, 600);
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
                mOverlayTranslateView.getTranslationY() + AppUtils.dpToPx(getActivity(), 47f));
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

    float[] mEnlargedImageInfoArray = new float[4];

    private void animateScreen2() {
        Animation anim = TrainingViewAnimations.alphaHideAnimation(0);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mScreen1Layout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mScreen1Layout.startAnimation(anim);

        mEnlargedImageInfoArray[0] = mImageEnlarged.getX();
        mEnlargedImageInfoArray[1] = mImageEnlarged.getY();
        mEnlargedImageInfoArray[2] = mImageEnlarged.getWidth();
        mEnlargedImageInfoArray[3] = mImageEnlarged.getHeight();

        mScreen2Layout.startAnimation(TrainingViewAnimations.alphaVisibleAnimation(0));
        mScreen2Layout.setVisibility(View.VISIBLE);

        animateToEnlargeImage();

        if (mRootView != null) {
            View rule1 = mRootView.findViewById(R.id.horizontal_rule_1);
            rule1.setVisibility(View.VISIBLE);
            rule1.startAnimation(TrainingViewAnimations.alphaVisibleAnimation(OFFSET * 3));

            View rule2 = mRootView.findViewById(R.id.horizontal_rule_2);
            rule2.setVisibility(View.VISIBLE);
            rule2.startAnimation(TrainingViewAnimations.alphaVisibleAnimation((int) (OFFSET * 3.5)));

            AnimationSet animSet1 = new AnimationSet(true);
            animSet1.setFillAfter(true);
            animSet1.addAnimation(TrainingViewAnimations.alphaVisibleAnimation(OFFSET * 4));
            animSet1.addAnimation(TrainingViewAnimations.alphaHideAnimation(OFFSET * 24));

            final TextView amountTxt = (TextView) mRootView.findViewById(R.id.amount_txt);
            amountTxt.setVisibility(View.VISIBLE);
            amountTxt.startAnimation(animSet1);

            ValueAnimator animateText = ValueAnimator.ofInt(0, 35);
            animateText.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (int) valueAnimator.getAnimatedValue();
                    amountTxt.setText("$" + val + ".00");
                }
            });
            animateText.setDuration(700);
            animateText.setStartDelay(OFFSET * 6);
            animateText.start();


            AnimationSet animSet2 = new AnimationSet(true);
            animSet2.setFillAfter(true);
            animSet2.addAnimation(TrainingViewAnimations.alphaVisibleAnimation(OFFSET * 10));
            animSet2.addAnimation(TrainingViewAnimations.alphaHideAnimation(OFFSET * 22));

            View requestPayLayout = mRootView.findViewById(R.id.request_pay_layout);
            requestPayLayout.setVisibility(View.VISIBLE);
            requestPayLayout.startAnimation(animSet2);

            View payRippleView = mRootView.findViewById(R.id.pay_ripple_view);
            payRippleView.setVisibility(View.VISIBLE);
            payRippleView.startAnimation(TrainingViewAnimations.rippleAnimation(OFFSET * 16));


            View ovalBg = mRootView.findViewById(R.id.oval_bg);
            ovalBg.setVisibility(View.VISIBLE);
            ovalBg.startAnimation(scaleUpWithBounce(OFFSET * 28, 2200));

            View ovalTick = mRootView.findViewById(R.id.oval_tick);
            ovalTick.setVisibility(View.VISIBLE);
            ovalTick.startAnimation(scaleUpWithBounce(OFFSET * 28, 1800));

        }
    }


    private void animateToEnlargeImage() {
        ObjectAnimator translateY = ObjectAnimator.ofFloat(mImageEnlarged, "Y",
                mRow4.getY(), mEnlargedImageInfoArray[1]);
        translateY.setDuration(400);

        ObjectAnimator translateX = ObjectAnimator.ofFloat(mImageEnlarged, "X",
                mRow4.getX(), mEnlargedImageInfoArray[0]);
        translateX.setDuration(600);

        ValueAnimator animateSize = ValueAnimator.ofInt(mImageToBeEnlarged.getWidth(), (int) mEnlargedImageInfoArray[2]);
        animateSize.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = mImageEnlarged.getLayoutParams();
                layoutParams.height = val;
                layoutParams.width = val;
                mImageEnlarged.setLayoutParams(layoutParams);
            }
        });
        animateSize.setDuration(500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateY, translateX, animateSize);
        animatorSet.setStartDelay(50);
        animatorSet.start();

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
