package com.app.movingpoc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.movingpoc.fragment.BaseFragment;
import com.app.movingpoc.fragment.Inner1Fragment;
import com.app.movingpoc.fragment.Inner2Fragment;
import com.app.movingpoc.fragment.Inner3Fragment;
import com.app.movingpoc.fragment.Inner4Fragment;
import com.app.movingpoc.fragment.Inner5Fragment;
import com.app.movingpoc.fragment.Inner6Fragment;

public class InnerAdapter extends FragmentPagerAdapter {

    private int noOfPages = 4;
    private BaseFragment[] mFragmentArray;

    public InnerAdapter(FragmentManager fm) {
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
        mFragmentArray[0] = new Inner1Fragment();
        mFragmentArray[1] = new Inner2Fragment();
        mFragmentArray[2] = new Inner3Fragment();
        mFragmentArray[3] = new Inner4Fragment();

        if (billPayTraining && friendPayTraining) {
            mFragmentArray[4] = new Inner5Fragment();
            mFragmentArray[5] = new Inner6Fragment();
        } else {
            if (billPayTraining)
                mFragmentArray[4] = new Inner5Fragment();
            else if (friendPayTraining)
                mFragmentArray[4] = new Inner6Fragment();
        }
    }

}
