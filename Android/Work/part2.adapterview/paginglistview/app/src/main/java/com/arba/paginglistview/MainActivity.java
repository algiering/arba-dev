package com.arba.paginglistview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private int count = 0;

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
    private boolean flagGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        listview = findViewById(R.id.listview);

        adapter = new AdapterItem(MainActivity.this, R.layout.customview_item, list);

        listview.setAdapter(adapter);

        AddItem(count, 30);

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount == firstVisibleItem + visibleItemCount) {
                    if (flagGetData == false) {
                        flagGetData = true;
                        new httpGetData().execute();
                        flagGetData = false;
                    }

                    adapter.notifyDataSetChanged();
                }
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ModelItem item = list.get(position);
                builder.setTitle(item.getDataItem01()).setMessage(item.toString()).setIcon(R.mipmap.ic_launcher).setPositiveButton("확인", null).show();
            }
        });

    }

    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random() * 10000); i++) {
            //char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf((char) ((Math.random() * 26) + 97));
        }
        return str;
    }

    private ArrayList<ModelItem> AddItem(Integer count, Integer bound) {
        ArrayList<ModelItem> items = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            ModelItem person = new ModelItem();
            person.setDataItem01("name" + count);
            person.setDataItem02(getRandString());
            person.setDataItem03(20 + r.nextInt(bound) + "");
            person.setIconItem(getResources().getDrawable(imagesIds[i % imagesIds.length], null));
            count++;

            items.add(person);
        }
        list.addAll(items);
        return items;
    }

    private class httpGetData extends AsyncTask<Integer, Integer, List<ModelItem>> {

        private ProgressDialog pdlg = null;

        // 네트워크 데이터 요청 직전 실행
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("Wait");
            pdlg.show();
        }

        @Override
        protected List<ModelItem> doInBackground(Integer... integers) {

            List<ModelItem> temp = null;

            try {
                Thread.sleep(2000);

                AddItem(count, 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return temp;
        }

        // 네트워크 데이터 요청 완료 뒤 실행
        @Override
        protected void onPostExecute(List<ModelItem> modelItems) {
            super.onPostExecute(modelItems);
            if (pdlg != null) {
                pdlg.dismiss();
                pdlg = null;
            }
        }
    }
}
