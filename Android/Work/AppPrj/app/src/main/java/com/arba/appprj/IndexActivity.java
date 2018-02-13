package com.arba.appprj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

import com.arba.appprj.article.AdapterArticle;
import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpArticle;
import com.arba.appprj.model.ModelArticle;

import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private ListView indexlistview;
    private AdapterArticle mAdapter;
    private List<ModelArticle> mData;

    private Button btn_list;
    private Button btn_write;

    private String board_id = "mhw";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        setTitle("게시판");

        new HttpGetData(IndexActivity.this).execute();

    }

    private class HttpGetData extends SiteAsyncTask<String, Integer, List<ModelArticle>> {
        public HttpGetData(Context context) {
            super(context);
        }

        @Override
        protected List<ModelArticle> doInBackground(String... strings) {

            return new HttpArticle().getArticlePaging("mhw", 1,20);
        }

        @Override
        protected void onPostExecute(List<ModelArticle> list) {
            super.onPostExecute(list);

            indexlistview = findViewById(R.id.index_listview);

            mData = list;

            mAdapter = new AdapterArticle(IndexActivity.this, R.layout.view_custom, mData);

            indexlistview.setAdapter(mAdapter);
            mItemClickListener mItemClickListener = new mItemClickListener();
            indexlistview.setOnItemClickListener(mItemClickListener);


            btn_list = findViewById(R.id.btn_list);
            btn_write = findViewById(R.id.btn_write);

            mClickListener mClickListener = new mClickListener();

            btn_list.setOnClickListener(mClickListener);
            btn_write.setOnClickListener(mClickListener);

        }
    }

    private class mItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int article_no = mData.get(position).getArticle_no();
            Intent i = new Intent(IndexActivity.this, ArticleDetailActivity.class);
            i.putExtra("article_no", article_no);

            String board_id = mData.get(position).getBoard_id();
            i.putExtra("board_id", board_id);

            startActivityForResult(i, 10000);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==10000 || requestCode == 10) {
            new HttpGetData(IndexActivity.this).execute();
            mAdapter.notifyDataSetChanged();
        }
    }

    private class mClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_list:
                    Toast.makeText(IndexActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_write:
                    Intent i = new Intent(IndexActivity.this, WriteActivity.class);
                    i.putExtra("board_id", board_id);
                    startActivityForResult(i, 10400);
                    break;
            }
        }
    }
}
