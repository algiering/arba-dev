package com.arba.paginglistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    AdapterItem adapter;
    private ArrayList<ModelItem> list;
    private int[] imagesIds = {
            R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        initData();
        adapter = new AdapterItem(MainActivity.this, R.layout.customview_item, list);

        listview.setAdapter(adapter);

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
               if (totalItemCount == firstVisibleItem + visibleItemCount) {
                   Random r = new Random();
                   for (int i = 0; i < 10; i++) {
                       ModelItem person = new ModelItem();
                       person.setDataItem01("name" + i);
                       person.setDataItem02(getRandString());
                       person.setDataItem03(20 + r.nextInt(30) + "");
                       person.setIconItem(getResources().getDrawable(imagesIds[i % imagesIds.length], null));

                       list.add(person);
                   }
                   adapter.notifyDataSetChanged();
               }
            }
        });

    }

    private void initData() {
        list = new ArrayList<ModelItem>();

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            ModelItem person = new ModelItem();
            person.setDataItem01("name" + i);
            person.setDataItem02(getRandString());
            person.setDataItem03(20 + r.nextInt(30) + "");
            person.setIconItem(getResources().getDrawable(imagesIds[i % imagesIds.length], null));

            list.add(person);
        }
    }

    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random() * 10000); i++) {
//char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf((char) ((Math.random() * 26) + 97));
        }
        return str;
    }
}
