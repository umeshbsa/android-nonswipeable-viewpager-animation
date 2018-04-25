package com.app.noswipeviewpager.activity;

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

import com.app.movingpoc.fragment.BaseFragment;
import com.app.movingpoc.adapter.TrainingInsetPagerAdapter;
import com.app.movingpoc.adapter.TrainingPagerAdapter;
import com.app.movingpoc.anim.TrainingViewAnimations;

public class AnimatedViewActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private View mSwipeAreaView;
    private final int MIN_VELOCITY = 1200;
    private final int MIN_DISTANCE = 10;
    private VelocityTracker mVelocityTracker;
    private float mVelocity, mLastTouchX;
    private boolean isMovedToRightAnimation;
    private boolean isMovedToLeftAnimation;
    private RelativeLayout mInsetLayout;
    private ViewPager mViewPager, mPagerInset;
    private TrainingPagerAdapter mTrainingPagerAdapter;
    private TrainingInsetPagerAdapter mTrainingInsetPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSwipeAreaView = findViewById(R.id.swipe_area_view);
        setUpViews();
        mSwipeAreaView.setOnTouchListener(this);

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

        BaseFragment fragment = mTrainingPagerAdapter.getFragmentArray()[mViewPager.getCurrentItem()];
        if (fragment != null) {
            fragment.startExitAnimation(true);
        }
        BaseFragment insetFragment = mTrainingInsetPagerAdapter.getFragmentArray()[mViewPager.getCurrentItem()];
        if (insetFragment != null) {
            insetFragment.startExitAnimation(true);
        }

        final int totalScreens = mTrainingPagerAdapter.getCount();
        final int maxPageIndex = totalScreens - 1;
        final int nextPage = mViewPager.getCurrentItem() == maxPageIndex ? 0 : mViewPager.getCurrentItem() + 1;

        if (nextPage == 0) {
            mInsetLayout.startAnimation(TrainingViewAnimations.rightToLeftExitAnimation(TrainingViewAnimations.OFFSET_3));
            mInsetLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mInsetLayout.setVisibility(View.INVISIBLE);
                }
            }, TrainingViewAnimations.OFFSET_3);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nextPage == 0) {
                    mPagerInset.setCurrentItem(0, false);
                } else if (nextPage == 1) {
                    mPagerInset.setCurrentItem(mPagerInset.getCurrentItem() + 1);
                    mInsetLayout.setVisibility(View.VISIBLE);
                    mInsetLayout.startAnimation(TrainingViewAnimations.rightToLeftEnterAnimation(TrainingViewAnimations.OFFSET_0));
                } else {
                    mPagerInset.setCurrentItem(mPagerInset.getCurrentItem() + 1, false);
                }


                if (mViewPager.getCurrentItem() == maxPageIndex) {
                    mViewPager.setCurrentItem(0, false);
                } else {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, false);
                }

                isSliding = false;

            }
        }, fragment.exitDuration());

    }

    private void previousPagerItem() {
        isSliding = true;

        BaseFragment.isRightAnimation = false;

        BaseFragment fragment = mTrainingPagerAdapter.getFragmentArray()[mViewPager.getCurrentItem()];
        if (fragment != null) {
            fragment.startExitAnimation(false);
        }
        BaseFragment insetFragment = mTrainingInsetPagerAdapter.getFragmentArray()[mViewPager.getCurrentItem()];
        if (insetFragment != null) {
            insetFragment.startExitAnimation(false);
        }

        final int totalScreens = mTrainingPagerAdapter.getCount();
        final int maxPageIndex = totalScreens - 1;
        final int previousPage = mViewPager.getCurrentItem() == 0 ? maxPageIndex : mViewPager.getCurrentItem() - 1;

        if (previousPage == 0) {
            mInsetLayout.startAnimation(TrainingViewAnimations.leftToRightExitAnimation(TrainingViewAnimations.OFFSET_3));
            mInsetLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mInsetLayout.setVisibility(View.INVISIBLE);
                }
            }, TrainingViewAnimations.OFFSET_3);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (previousPage == 0) {
                    mPagerInset.setCurrentItem(0, false);
                } else if (previousPage == maxPageIndex) {
                    mPagerInset.setCurrentItem(maxPageIndex);
                    mInsetLayout.setVisibility(View.VISIBLE);
                    mInsetLayout.startAnimation(TrainingViewAnimations.leftToRightEnterAnimation(TrainingViewAnimations.OFFSET_0));
                } else {
                    mPagerInset.setCurrentItem(mPagerInset.getCurrentItem() - 1, false);
                }


                if (mViewPager.getCurrentItem() == 0) {
                    mViewPager.setCurrentItem(maxPageIndex, false);
                } else {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, false);
                }

                isSliding = false;

            }
        }, fragment.exitDuration());

    }
    private void setUpViews() {
        mInsetLayout = (RelativeLayout) findViewById(R.id.insetLayout);
        setUpPager();
    }

    private void setUpPager() {
        boolean isProvideBillPayTraining = true;
        boolean isProvideFriendPayTraining = true;

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTrainingPagerAdapter = new TrainingPagerAdapter(getSupportFragmentManager());
        mTrainingPagerAdapter.setProvideExtraTraining(isProvideBillPayTraining, isProvideFriendPayTraining);
        mViewPager.setAdapter(mTrainingPagerAdapter);


        mPagerInset = (ViewPager) findViewById(R.id.pagerInner);
        if (getResources().getConfiguration().screenHeightDp > 600) {
            mInsetLayout.getLayoutParams().height = AppUtils.dpToPx(this, 360);
            ((LinearLayout.LayoutParams) mPagerInset.getLayoutParams()).topMargin += AppUtils.dpToPx(this, 6.45f);
        }
        mTrainingInsetPagerAdapter = new TrainingInsetPagerAdapter(getSupportFragmentManager());
        mTrainingInsetPagerAdapter.setProvideExtraTraining(isProvideBillPayTraining, isProvideFriendPayTraining);
        mPagerInset.setAdapter(mTrainingInsetPagerAdapter);
    }
}
