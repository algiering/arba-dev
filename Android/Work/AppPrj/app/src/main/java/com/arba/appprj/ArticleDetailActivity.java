package com.arba.appprj;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpArticle;
import com.arba.appprj.https.HttpRequest;
import com.arba.appprj.model.ModelArticle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticleDetailActivity extends AppCompatActivity {

    private TextView article_title;
    private TextView article_content;
    private TextView article_regdate;
    private TextView article_hit;

    private Button btn_list;
    private Button btn_edit;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        new mAsyncTask3(ArticleDetailActivity.this).execute();
        new mAsyncTask(ArticleDetailActivity.this).execute();
    }

    private class mAsyncTask extends SiteAsyncTask<Integer, Integer, ModelArticle> {
        public mAsyncTask(Context context) {
            super(context);
        }

        @Override
        protected ModelArticle doInBackground(Integer... integers) {

            Intent i = getIntent();

            int article_no = i.getIntExtra("article_no", -1);
            String board_id = i.getStringExtra("board_id");

            ModelArticle result = new HttpArticle().getArticleOne(board_id, article_no);

            return result;
        }

        @Override
        protected void onPostExecute(ModelArticle list) {
            super.onPostExecute(list);

            article_title = findViewById(R.id.article_title);
            article_content = findViewById(R.id.article_content);
            article_regdate = findViewById(R.id.article_regdate);
            article_hit = findViewById(R.id.article_hit);

            article_title.setText(list.getArticle_title());
            article_content.setText(list.getArticle_content());

            Date regdate = list.getArticle_regdate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            article_regdate.setText(String.valueOf(format.format(regdate)));

            article_hit.setText(String.valueOf(list.getArticle_hit()));

            btn_list = findViewById(R.id.btn_list);
            btn_edit = findViewById(R.id.btn_edit);
            btn_delete = findViewById(R.id.btn_delete);

            mClickListener mClickListener = new mClickListener();

            btn_list.setOnClickListener(mClickListener);
            btn_edit.setOnClickListener(mClickListener);
            btn_delete.setOnClickListener(mClickListener);

        }
    }

    private class mClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_list:
                    int mCode = 1;

                    Intent i = getIntent();
                    i.putExtra("mCode", mCode);

                    setResult(10000, i);
                    finish();
                    break;

                case R.id.btn_edit:
                    int article_no = getIntent().getIntExtra("article_no", -1);
                    String board_id = getIntent().getStringExtra("board_id");

                    Intent data = new Intent(ArticleDetailActivity.this, EditActivity.class);
                    data.putExtra("article_no", article_no);
                    data.putExtra("board_id", board_id);

                    startActivityForResult(data, 10600);

                    break;

                case R.id.btn_delete:
                    new AlertDialog.Builder(ArticleDetailActivity.this)
                            .setTitle("글 삭제")
                            .setMessage("글을 삭제 할까요?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    new mAsyncTask2(ArticleDetailActivity.this).execute();
                                }
                            })
                            .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    return;
                                }
                            })
                            .show();
                    break;
            }
        }
    }

    private class mAsyncTask2 extends SiteAsyncTask<Integer, Integer, Integer> {
        public mAsyncTask2(Context context) {
            super(context);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int article_no = getIntent().getIntExtra("article_no", -1);
            int result = new HttpArticle().deleteArticle(article_no);
            return result;
        }

        @Override
        protected void onPostExecute(Integer list) {
            super.onPostExecute(list);

            if (list == 1) {
                Toast.makeText(ArticleDetailActivity.this, "글을 삭제 했습니다", Toast.LENGTH_SHORT).show();
                setResult(10000);
                finish();
            }
            else {
                Toast.makeText(ArticleDetailActivity.this, "삭제에 실패했습니다", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    private class mAsyncTask3 extends SiteAsyncTask<Integer, Integer, Integer> {

        public mAsyncTask3(Context context) {
            super(context);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int article_no = getIntent().getIntExtra("article_no", -1);
            int result = new HttpArticle().updateIncreseHit(article_no);
            return result;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 10010) {
            new mAsyncTask(ArticleDetailActivity.this).execute();
        }
        else if(resultCode == 10020) {
            finish();
        }
    }
}
