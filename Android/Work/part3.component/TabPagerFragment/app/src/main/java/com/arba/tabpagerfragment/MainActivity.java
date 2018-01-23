package com.arba.tabpagerfragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);


        // tab layout configration
        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_email).setText("1"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_dialer).setText("2"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_map).setText("3"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_info).setText("4"));

        // view pager configration
        pager = findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(adapter);


        // connect viewpager and tab layout
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // clicked tab int tab layout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private int tabCount;

        public PagerAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            tabCount = numberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Tab1Fragment();

                case 1:
                    return new Tab2Fragment();

                case 2:
                    return new Tab3Fragment();

                case 3:
                    return new Tab4Fragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return tabCount;
        }
    }

}