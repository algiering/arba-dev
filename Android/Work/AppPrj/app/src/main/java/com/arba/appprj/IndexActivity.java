package com.arba.appprj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.arba.appprj.article.AdapterArticle;
import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpArticle;
import com.arba.appprj.model.ModelArticle;

import java.util.List;

public class IndexActivity extends AppCompatActivity {

    ListView indexlistview;
    AdapterArticle mAdapter;
    List<ModelArticle> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        new HttpGetData(IndexActivity.this).execute();

        indexlistview = findViewById(R.id.index_listview);

    }

    private class HttpGetData extends SiteAsyncTask<String, Integer, List<ModelArticle>> {
        public HttpGetData(Context context) {
            super(context);
        }

        @Override
        protected List<ModelArticle> doInBackground(String... strings) {

            List<ModelArticle> result = new HttpArticle().getArticleList();
            return result;
        }

        @Override
        protected void onPostExecute(List<ModelArticle> list) {
            super.onPostExecute(list);
            mData = list;

            mAdapter = new AdapterArticle(IndexActivity.this, R.layout.view_custom, mData);

            indexlistview.setAdapter(mAdapter);
        }
    }
}
