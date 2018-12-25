package com.app.moving.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.moving.fragment.BaseFragment;
import com.app.moving.fragment.Child1Fragment;
import com.app.moving.fragment.Child2Fragment;
import com.app.moving.fragment.Child3Fragment;

public class ChildPagerAdapter extends FragmentPagerAdapter {

    private int noOfPages = 3;
    private BaseFragment[] mFragmentArray;
    public ChildPagerAdapter(FragmentManager fm) {
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

    public void setProvideExtraTraining() {
        mFragmentArray = new BaseFragment[noOfPages];
        mFragmentArray[0] = new Child1Fragment();
        mFragmentArray[1] = new Child2Fragment();
        mFragmentArray[2] = new Child3Fragment();

    }

}
