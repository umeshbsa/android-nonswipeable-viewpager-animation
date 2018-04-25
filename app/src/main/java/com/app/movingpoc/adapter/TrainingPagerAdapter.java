package com.app.movingpoc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.movingpoc.fragment.BaseFragment;
import com.app.movingpoc.fragment.Outer1Fragment;
import com.app.movingpoc.fragment.Outer2Fragment;
import com.app.movingpoc.fragment.Outer3Fragment;
import com.app.movingpoc.fragment.Outer4Fragment;
import com.app.movingpoc.fragment.Outer5Fragment;
import com.app.movingpoc.fragment.Outer6Fragment;

public class TrainingPagerAdapter extends FragmentPagerAdapter {

    private int noOfPages = 4;
    private BaseFragment[] mFragmentArray;

    public TrainingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArray[position];
    }

    public BaseFragment[] getFragmentArray() {
        return mFragmentArray;
    }

    @Override
    public int getCount() {
        return noOfPages;
    }

    public void setProvideExtraTraining(boolean billPayTraining, boolean friendPayTraining) {
        if (billPayTraining) {
            noOfPages += 1;
        }
        if (friendPayTraining) {
            noOfPages += 1;
        }

        mFragmentArray = new BaseFragment[noOfPages];
        mFragmentArray[0] = new Outer1Fragment();
        mFragmentArray[1] = new Outer2Fragment();
        mFragmentArray[2] = new Outer3Fragment();
        mFragmentArray[3] = new Outer4Fragment();

        if (billPayTraining && friendPayTraining) {
            mFragmentArray[4] = new Outer5Fragment();
            mFragmentArray[5] = new Outer6Fragment();
        } else {
            if (billPayTraining)
                mFragmentArray[4] = new Outer5Fragment();
            else if (friendPayTraining)
                mFragmentArray[4] = new Outer6Fragment();
        }
    }

}



