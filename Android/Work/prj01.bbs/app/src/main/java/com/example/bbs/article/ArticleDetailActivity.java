package com.example.bbs.article;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bbs.R;
import com.example.bbs.SiteAsyncTask;
import com.example.bbs.http.HttpBoard;
import com.example.bbs.model.ModelArticle;
import com.example.bbs.model.ModelBoard;
import com.example.bbs.model.ModelComments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

public class ArticleDetailActivity extends AppCompatActivity {

    public static final String ARG_ARTICLENO = "articleno";
    private static final String ARG_ARTICLE = "article";
    private static final String ARG_COMMENTS = "commentslist";

    private TextView mNo;
    private TextView mTitle;
    private TextView mHit;
    private TextView mContent;

    private ListView mListview;

    private AdapterComment mAdapter;
    ModelArticle mArticle;
    List<ModelComments> mComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Intent i = getIntent();
        int articleno = i.getIntExtra(ARG_ARTICLENO, 0);

        new ArticleDetailTask(ArticleDetailActivity.this).execute(articleno);
    }

    private class ArticleDetailTask extends SiteAsyncTask<Integer, Integer, Map<String, Object>> {

        public ArticleDetailTask(Context context) {
            super(context);
        }

        @Override
        protected Map<String, Object> doInBackground(Integer... integers) {
            HttpBoard http = new HttpBoard();
            ModelArticle article = http.getArticle(integers[0]);
            List<ModelComments> comments = http.getCommentList(integers[0]);

            Map<String, Object> map = new HashMap<>();
            map.put(ARG_ARTICLE, article);
            map.put(ARG_COMMENTS, comments);
            return map;
        }

        @Override
        protected void onPostExecute(Map<String, Object> map) {
            super.onPostExecute(map);

            mNo = findViewById(R.id.no);
            mHit = findViewById(R.id.hit);
            mTitle = findViewById(R.id.title);
            mContent = findViewById(R.id.content);

            mListview = findViewById(R.id.listview_comment);

            mArticle = (ModelArticle) map.get(ARG_ARTICLE);
            mComments = (List<ModelComments>) map.get(ARG_COMMENTS);

            mNo.setText(mArticle.getArticleno()+"");
            mHit.setText(mArticle.getHit()+"");
            mTitle.setText(mArticle.getTitle());
            mContent.setText(mArticle.getContent());

            setTitle(mArticle.getTitle());

            mAdapter = new AdapterComment(this.mContext, R.layout.activity_article_detail_customview, mComments);

            mListview.setAdapter(mAdapter);

        }
    }
}
