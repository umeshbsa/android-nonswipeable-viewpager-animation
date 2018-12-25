package com.app.moving.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.app.moving.R;
import com.app.moving.adapter.ChildPagerAdapter;
import com.app.moving.adapter.ParentPagerAdapter;
import com.app.moving.fragment.BaseFragment;
import com.app.moving.utils.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private final int MIN_VELOCITY = 1200;
    private final int MIN_DISTANCE = 10;

    private float mVelocity, mLastTouchX;

    private VelocityTracker mVelocityTracker;

    private boolean isMovedToRightAnimation;
    private boolean isMovedToLeftAnimation;

    private View mSwipeAreaView;
    private RelativeLayout mChildRealativeLayout;
    private ViewPager mOuterNonSwipViewPager;
    private ViewPager mChildNonSwipViewPager;

    private ParentPagerAdapter mParentPagerAdapter;
    private ChildPagerAdapter mChildPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeAreaView = findViewById(R.id.swipe_area_view);
        mChildRealativeLayout = (RelativeLayout) findViewById(R.id.child_relative_layout);
        mOuterNonSwipViewPager = (ViewPager) findViewById(R.id.non_swip_outer_viewpager);
        mChildNonSwipViewPager = (ViewPager) findViewById(R.id.non_swip_child_viewpager);

        mSwipeAreaView.setOnTouchListener(this);

        setUpPager();

        final RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.s_join_login_parent_layout);
        parentLayout.post(new Runnable() {
            public void run() {
                int height = parentLayout.getHeight();
                int width = parentLayout.getWidth();
            }
        });
    }


    @Override
    public void onClick(View v) {


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int index = motionEvent.getActionIndex();
        int action = motionEvent.getActionMasked();
        int pointerId = motionEvent.getPointerId(index);
        if (pointerId > 0) {
            return false;
        }
        switch (action) {

            case MotionEvent.ACTION_DOWN: {
                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain();
                } else {
                    mVelocityTracker.clear();
                }
                if (mVelocityTracker != null) {
                    mVelocityTracker.addMovement(motionEvent);
                }
                isMovedToRightAnimation = false;
                isMovedToLeftAnimation = false;
                final float x = motionEvent.getX();
                mLastTouchX = x;
                return true;
            }

            case MotionEvent.ACTION_MOVE: {
                if (mVelocityTracker != null) {
                    mVelocityTracker.addMovement(motionEvent);
                    mVelocityTracker.computeCurrentVelocity(1000);
                    mVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId);
                }
                final float x = motionEvent.getX();
                if (mLastTouchX > x && (mLastTouchX - x) > MIN_DISTANCE) {
                    isMovedToRightAnimation = true;
                } else if (mLastTouchX < x && (x - mLastTouchX) > MIN_DISTANCE) {
                    isMovedToLeftAnimation = true;
                }

                return true;
            }

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP: {
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                if (isMovedToRightAnimation && mVelocity < -MIN_VELOCITY && !isSliding) {
                    nextPagerItem();
                } else if (isMovedToLeftAnimation && mVelocity > MIN_VELOCITY && !isSliding) {
                    previousPagerItem();
                }
                return true;
            }

            default: {
                if (mVelocityTracker != null) {
                    mVelocityTracker.recycle();
                    mVelocityTracker = null;
                }
                return true;
            }
        }
    }

    private boolean isSliding;

    private void nextPagerItem() {
        isSliding = true;

        BaseFragment.isRightAnimation = true;

        BaseFragment fragment = mParentPagerAdapter.getFragmentArray()[mOuterNonSwipViewPager.getCurrentItem()];
        if (fragment != null) {
            fragment.startExitAnimation(true);
        }
        BaseFragment insetFragment = mChildPagerAdapter.getFragmentArray()[mOuterNonSwipViewPager.getCurrentItem()];
        if (insetFragment != null) {
            insetFragment.startExitAnimation(true);
        }

        final int totalScreens = mParentPagerAdapter.getCount();
        final int maxPageIndex = totalScreens - 1;
        final int nextPage = mOuterNonSwipViewPager.getCurrentItem() == maxPageIndex ? 0 : mOuterNonSwipViewPager.getCurrentItem() + 1;

        if (nextPage == 0) {
            mChildRealativeLayout.startAnimation(Utils.rightToLeftExitAnimation(Utils.OFFSET_3));
            mChildRealativeLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mChildRealativeLayout.setVisibility(View.INVISIBLE);
                }
            }, Utils.OFFSET_3);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nextPage == 0) {
                    mChildNonSwipViewPager.setCurrentItem(0, false);
                } else if (nextPage == 1) {
                    mChildNonSwipViewPager.setCurrentItem(mChildNonSwipViewPager.getCurrentItem() + 1);
                    mChildRealativeLayout.setVisibility(View.VISIBLE);
                    mChildRealativeLayout.startAnimation(Utils.rightToLeftEnterAnimation(Utils.OFFSET_0));
                } else {
                    mChildNonSwipViewPager.setCurrentItem(mChildNonSwipViewPager.getCurrentItem() + 1, false);
                }


                if (mOuterNonSwipViewPager.getCurrentItem() == maxPageIndex) {
                    mOuterNonSwipViewPager.setCurrentItem(0, false);
                } else {
                    mOuterNonSwipViewPager.setCurrentItem(mOuterNonSwipViewPager.getCurrentItem() + 1, false);
                }

                isSliding = false;

            }
        }, fragment.exitDuration());

    }

    private void previousPagerItem() {
        isSliding = true;

        BaseFragment.isRightAnimation = false;

        BaseFragment fragment = mParentPagerAdapter.getFragmentArray()[mOuterNonSwipViewPager.getCurrentItem()];
        if (fragment != null) {
            fragment.startExitAnimation(false);
        }
        BaseFragment insetFragment = mChildPagerAdapter.getFragmentArray()[mOuterNonSwipViewPager.getCurrentItem()];
        if (insetFragment != null) {
            insetFragment.startExitAnimation(false);
        }

        final int totalScreens = mParentPagerAdapter.getCount();
        final int maxPageIndex = totalScreens - 1;
        final int previousPage = mOuterNonSwipViewPager.getCurrentItem() == 0 ? maxPageIndex : mOuterNonSwipViewPager.getCurrentItem() - 1;

        if (previousPage == 0) {
            mChildRealativeLayout.startAnimation(Utils.leftToRightExitAnimation(Utils.OFFSET_3));
            mChildRealativeLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mChildRealativeLayout.setVisibility(View.INVISIBLE);
                }
            }, Utils.OFFSET_3);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (previousPage == 0) {
                    mChildNonSwipViewPager.setCurrentItem(0, false);
                } else if (previousPage == maxPageIndex) {
                    mChildNonSwipViewPager.setCurrentItem(maxPageIndex);
                    mChildRealativeLayout.setVisibility(View.VISIBLE);
                    mChildRealativeLayout.startAnimation(Utils.leftToRightEnterAnimation(Utils.OFFSET_0));
                } else {
                    mChildNonSwipViewPager.setCurrentItem(mChildNonSwipViewPager.getCurrentItem() - 1, false);
                }


                if (mOuterNonSwipViewPager.getCurrentItem() == 0) {
                    mOuterNonSwipViewPager.setCurrentItem(maxPageIndex, false);
                } else {
                    mOuterNonSwipViewPager.setCurrentItem(mOuterNonSwipViewPager.getCurrentItem() - 1, false);
                }

                isSliding = false;

            }
        }, fragment.exitDuration());

    }


    private void setUpPager() {

        mParentPagerAdapter = new ParentPagerAdapter(getSupportFragmentManager());
        mParentPagerAdapter.setProvideExtraTraining();
        mOuterNonSwipViewPager.setAdapter(mParentPagerAdapter);


        if (getResources().getConfiguration().screenHeightDp > 600) {
            mChildRealativeLayout.getLayoutParams().height = Utils.dpToPx(this, 360);
            ((LinearLayout.LayoutParams) mChildNonSwipViewPager.getLayoutParams()).topMargin += Utils.dpToPx(this, 6.45f);
        }
        mChildPagerAdapter = new ChildPagerAdapter(getSupportFragmentManager());
        mChildPagerAdapter.setProvideExtraTraining();
        mChildNonSwipViewPager.setAdapter(mChildPagerAdapter);
    }
}
