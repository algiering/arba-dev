package com.android.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        ButtonInner bi = new ButtonInner();

        button1.setOnClickListener(bi);
        button2.setOnClickListener(bi);
        button3.setOnClickListener(bi);

        pager = findViewById(R.id.pager);
        PagerInner pi = new PagerInner(getApplication());
        pager.setAdapter(pi);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button1:
                    pager.setCurrentItem(0, true);
                    break;

                case R.id.button2:
                    pager.setCurrentItem(1, true);
                    break;

                case R.id.button3:
                    pager.setCurrentItem(2, true);
                    break;
            }
        }
    }

    private class PagerInner extends PagerAdapter {

        private LayoutInflater inflater;

        public PagerInner(Context c) {
            this.inflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            View v = null;

            switch (position) {
                case 0:
                    v = inflater.inflate(R.layout.inflate_one, null, false);
                    break;

                case 1:
                    v = inflater.inflate(R.layout.inflate_two, null, false);
                    break;

                case 2:
                    v = inflater.inflate(R.layout.inflate_three, null, false);
                    break;
            }
            pager.addView(v);
            return v;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            pager.removeView((View) object);
        }
    }
}
