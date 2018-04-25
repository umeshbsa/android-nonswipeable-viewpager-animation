package com.app.movingpoc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.movingpoc.fragment.BaseFragment;
import com.app.movingpoc.fragment.TrainingIllusionFragment;
import com.app.movingpoc.fragment.TrainingInset1Fragment;
import com.app.movingpoc.fragment.TrainingInset2Fragment;
import com.app.movingpoc.fragment.TrainingInset3Fragment;
import com.app.movingpoc.fragment.TrainingInsetBillPayFragment;
import com.app.movingpoc.fragment.TrainingInsetFriendPayFragment;

public class TrainingInsetPagerAdapter extends FragmentPagerAdapter {

    private int noOfPages = 4;
    private BaseFragment[] mFragmentArray;

    public TrainingInsetPagerAdapter(FragmentManager fm) {
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
        mFragmentArray[0] = new TrainingIllusionFragment();
        mFragmentArray[1] = new TrainingInset1Fragment();
        mFragmentArray[2] = new TrainingInset2Fragment();
        mFragmentArray[3] = new TrainingInset3Fragment();

        if (billPayTraining && friendPayTraining) {
            mFragmentArray[4] = new TrainingInsetBillPayFragment();
            mFragmentArray[5] = new TrainingInsetFriendPayFragment();
        } else {
            if (billPayTraining)
                mFragmentArray[4] = new TrainingInsetBillPayFragment();
            else if (friendPayTraining)
                mFragmentArray[4] = new TrainingInsetFriendPayFragment();
        }
    }

}
