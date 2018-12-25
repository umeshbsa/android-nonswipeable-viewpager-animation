package com.app.moving.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.moving.R;

public class Child1Fragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_child_1, container, false);
    }

    @Override
    public void startEnterAnimation() {

    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {

    }

}
