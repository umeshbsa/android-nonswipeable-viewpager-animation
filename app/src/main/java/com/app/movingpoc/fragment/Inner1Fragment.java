package com.app.movingpoc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.movingpoc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Inner1Fragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inner_1, container, false);
    }

    @Override
    public void startEnterAnimation() {

    }

    @Override
    public void startExitAnimation(boolean isRightAnimation) {

    }

}