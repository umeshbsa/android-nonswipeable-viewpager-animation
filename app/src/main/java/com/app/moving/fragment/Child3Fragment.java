package com.app.moving.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.moving.R;
import com.app.moving.utils.Utils;

import static com.app.moving.utils.Utils.OFFSET_0;


public class Child3Fragment extends BaseFragment {

    private RelativeLayout mLayoutTop;
    private ImageView mPin1SwingImageView;
    private ImageView mPin2SwingImageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_3, container, false);
        mLayoutTop = (RelativeLayout) view.findViewById(R.id.linear_child2_root);
        mPin1SwingImageView = (ImageView) view.findViewById(R.id.iv_child3_pin1_swing);
        mPin2SwingImageView = (ImageView) view.findViewById(R.id.iv_child3_pin2_swing);
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
        mPin1SwingImageView.startAnimation(Utils.shakeAnimation());
        mPin2SwingImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPin2SwingImageView.startAnimation(Utils.shakeAnimation());
            }
        }, 700);
        if (isRightAnimation)
            mLayoutTop.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_1));
        else
            mLayoutTop.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_1));
    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {
        if (!isAdded()) {
            return;
        }
        if (isRightAnimation)
            mLayoutTop.startAnimation(Utils.rightToLeftExitAnimation(OFFSET_0));
        else
            mLayoutTop.startAnimation(Utils.leftToRightExitAnimation(OFFSET_0));
    }

}
