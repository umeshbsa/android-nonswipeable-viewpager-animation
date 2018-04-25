package com.app.movingpoc.anim;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class TrainingViewAnimations {

    public static final int TO_LEFT_DURATION = 600;

    public static final int OFFSET_0 = 0;
    public static final int OFFSET_1 = 100;
    public static final int OFFSET_2 = 200;
    public static final int OFFSET_3 = 500;

    public static Animation rightToLeftEnterAnimation(long startOffset) {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, (float) 1.0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animation.setDuration(TO_LEFT_DURATION);
        animation.setStartOffset(startOffset);
        animation.setFillAfter(true);
        return animation;
    }

    public static Animation rightToLeftExitAnimation(long startOffset) {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animation.setDuration(TO_LEFT_DURATION);
        animation.setStartOffset(startOffset);
        animation.setFillAfter(true);
        return animation;
    }

    public static Animation leftToRightEnterAnimation(long startOffset) {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, (float) -1.0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animation.setDuration(TO_LEFT_DURATION);
        animation.setStartOffset(startOffset);
        animation.setFillAfter(true);
        return animation;
    }

    public static Animation leftToRightExitAnimation(long startOffset) {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1.0f,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animation.setDuration(TO_LEFT_DURATION);
        animation.setStartOffset(startOffset);
        animation.setFillAfter(true);
        return animation;
    }

    public static Animation leftToRightOverlayInset() {
        TranslateAnimation animOverlay = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, (float) 1.0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animOverlay.setDuration(1800);
        animOverlay.setStartOffset(1200);
        animOverlay.setFillAfter(true);
        return animOverlay;
    }

    public static Animation alphaVisibleAnimation(int startOffset) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setStartOffset(startOffset);
        alphaAnimation.setDuration(TO_LEFT_DURATION);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillEnabled(true);
        return alphaAnimation;
    }

    public static Animation alphaHideAnimation(int startOffset) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setStartOffset(startOffset);
        alphaAnimation.setDuration(TO_LEFT_DURATION);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillEnabled(true);
        return alphaAnimation;
    }

    public static Animation shakeAnimation() {

        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(new AccelerateInterpolator());

        RotateAnimation shake = new RotateAnimation(-10.0f, 40.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.05f,
                RotateAnimation.RELATIVE_TO_SELF, 0.05f);

        shake.setDuration(1200);
        shake.setRepeatMode(Animation.REVERSE);
        shake.setRepeatCount(Animation.INFINITE);
        animSet.addAnimation(shake);
        return animSet;
    }

    public static Animation rightToLeftViewInnerFragmentThree() {
        TranslateAnimation animView = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, (float) -0.15,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animView.setDuration(500);
        animView.setStartOffset(800);
        animView.setRepeatCount(1);
        animView.setRepeatMode(Animation.REVERSE);
        animView.setFillAfter(true);
        return animView;
    }

    public static Animation rightToLeftHiddenViewInnerFragmentThree() {
        TranslateAnimation animView = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, (float) -0.35,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animView.setDuration(500);
        animView.setStartOffset(800);
        animView.setRepeatCount(1);
        animView.setRepeatMode(Animation.REVERSE);
        animView.setFillAfter(true);
        return animView;
    }

    public static Animation rippleAnimation(int offset) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(700);
        alphaAnimation.setFillAfter(true);

        ScaleAnimation grow = new ScaleAnimation(0.3f, 1.0f, 0.99f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        grow.setDuration(450);
        grow.setFillAfter(true);

        AnimationSet animSet = new AnimationSet(true);
        animSet.addAnimation(alphaAnimation);
        animSet.addAnimation(grow);
        animSet.setStartOffset(offset);
        return animSet;
    }
}
