package com.arba.fragmentslide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayoutDots;
    private Button mBtnPrev, mBtnNext, mBtnSkip;

    private PrefManager mPref;

    private SlidePagerAdapter adapter;
    private int[] mLayouts = {    R.layout.welcome_slide1
                                , R.layout.welcome_slide2
                                , R.layout.welcome_slide3
                                , R.layout.welcome_slide4 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mBtnPrev = findViewById(R.id.btn_prev);
        mBtnNext = findViewById(R.id.btn_next);
        mBtnSkip = findViewById(R.id.btn_skip);


        // SharedPreference 이용하여 FirstLaunch 값 체크
        mPref = new PrefManager(IntroActivity.this);

        if (mPref.isFirstTimeLaunch()) {
            launchMain();
        }

        setContentView(R.layout.activity_intro);

        mViewPager = findViewById(R.id.view_pager);
        mLayoutDots = findViewById(R.id.layout_dots);

        // 위젯 설정. 리스너, 어댑터
        adapter = new SlidePagerAdapter(IntroActivity.this);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                addBottomDots(position);
            }

            @Override
            public void onPageSelected(int position) { }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        // 바닥에 ... 만들기
        mLayoutDots = findViewById(R.id.layout_dots);

        addBottomDots(0);

        ClickListener cl = new ClickListener();

        mBtnPrev.setOnClickListener(cl);
        mBtnNext.setOnClickListener(cl);
        mBtnSkip.setOnClickListener(cl);

        mLayoutDots.setOnClickListener(cl);
    }

    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[mLayouts.length];

        int[] colorActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorInactive = getResources().getIntArray(R.array.array_dot_inactive);

        mLayoutDots.removeAllViews();

        for(int i=0; i<mLayouts.length; i=i+1) {
            dots[i] = new TextView(IntroActivity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive[i]);
            mLayoutDots.addView(dots[i]);
        }

        dots[currentPage].setTextColor(colorActive[currentPage]);

    }

    private void launchMain() {
        mPref.setFirstTimeLaunch(true);

        Intent i = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(i);

        finish();
    }


    private class SlidePagerAdapter extends PagerAdapter {
        private final LayoutInflater inflater;

        public SlidePagerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(mLayouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mLayouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_prev:
                    Toast.makeText(IntroActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_next:
                    int current = mViewPager.getCurrentItem() + 1;
                    if (current < mLayouts.length) {
                        mViewPager.setCurrentItem(current);
                    }
                    else {
                        launchMain();
                    }
                    Toast.makeText(IntroActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_skip:
                    Toast.makeText(IntroActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                    launchMain();
                    break;

                case R.id.layout_dots:
                    Toast.makeText(IntroActivity.this, "Toast", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
