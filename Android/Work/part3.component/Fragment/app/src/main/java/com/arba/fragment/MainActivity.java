package com.arba.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        MyViewPager adapter = new MyViewPager(MainActivity.this);

        pager.setAdapter(adapter);
    }

    private class MyViewPager extends PagerAdapter {

        LayoutInflater inflater = null;

        public MyViewPager(Context context) {
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
        public Object instantiateItem(ViewGroup container, int position) {
            View v = null;

            switch (position) {
                case 0:
                    Fragment old0 = getSupportFragmentManager().findFragmentByTag("zero");

                    if (old0 == null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentOne f = new FragmentOne();
                        ft.replace(container.getId(), f, "zero");
                        ft.commit();
                    } else {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(container.getId(), old0, "zero");
                        ft.commit();
                    }
                    break;

                case 1:
                    Fragment old1 = getSupportFragmentManager().findFragmentByTag("one");

                    if (old1 == null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        Fragment_Two f = new Fragment_Two();
                        ft.replace(container.getId(), f, "one");
                        ft.commit();
                    } else {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(container.getId(), old1, "one");
                        ft.commit();
                    }
                    break;

                case 2:
                    Fragment old2 = getSupportFragmentManager().findFragmentByTag("two");

                    if (old2 == null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        Fragment_Thr f = new Fragment_Thr();
                        ft.replace(container.getId(), f, "two");
                        ft.commit();
                    } else {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(container.getId(), old2, "two");
                        ft.commit();
                    }
                    break;
            }
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
