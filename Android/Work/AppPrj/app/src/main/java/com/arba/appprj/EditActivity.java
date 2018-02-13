package com.arba.appprj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpArticle;
import com.arba.appprj.model.ModelArticle;

public class EditActivity extends AppCompatActivity {

    private EditText edit_title;
    private EditText edit_content;
    private Button btn_list;
    private Button btn_cancel;
    private Button btn_write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int article_no = getIntent().getIntExtra("article_no", -1);

        new mAsyncTask(EditActivity.this).execute(article_no);
    }

    private class mClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_list:
                    setResult(10020);
                    finish();
                    break;

                case R.id.btn_cancel:
                    finish();
                    break;

                case R.id.btn_write:
                    String article_title = edit_title.getText().toString();
                    String article_content = edit_content.getText().toString();

                    new mAsyncTask2(EditActivity.this).execute(article_title, article_content);
                    break;
            }
        }
    }

    private class mAsyncTask extends SiteAsyncTask<Integer, Integer, ModelArticle> {
        public mAsyncTask(Context context) {
            super(context);
        }

        @Override
        protected ModelArticle doInBackground(Integer... integers) {
            int article_no = integers[0];
            String board_id = getIntent().getStringExtra("board_id");

            ModelArticle result = new HttpArticle().getArticleOne(board_id, article_no);

            return result;
        }

        @Override
        protected void onPostExecute(ModelArticle list) {
            super.onPostExecute(list);

            edit_title = findViewById(R.id.edit_title);
            edit_content = findViewById(R.id.edit_content);

            btn_write = findViewById(R.id.btn_write);
            btn_cancel = findViewById(R.id.btn_cancel);
            btn_list = findViewById(R.id.btn_list);

            mClickListener mClickListener = new mClickListener();

            btn_list.setOnClickListener(mClickListener);
            btn_cancel.setOnClickListener(mClickListener);
            btn_write.setOnClickListener(mClickListener);

            String origtitle = list.getArticle_title();
            String origcontent = list.getArticle_content();

            edit_title.setText(origtitle);
            edit_content.setText(origcontent);
        }
    }

    private class mAsyncTask2 extends SiteAsyncTask<String, Integer, Integer> {

        public mAsyncTask2(Context context) {
            super(context);
        }

        @Override
        protected Integer doInBackground(String... strings) {
            int article_no = getIntent().getIntExtra("article_no", -1);

            int result = new HttpArticle().updateArticle(article_no, strings[0], strings[1]);

            return result;
        }

        @Override
        protected void onPostExecute(Integer list) {
            super.onPostExecute(list);

            if (list == 1) {
                Toast.makeText(EditActivity.this, "수정 되었습니다", Toast.LENGTH_SHORT).show();
                setResult(10010);
                finish();
            }

            else {
                Toast.makeText(EditActivity.this, "수정에 실패하였습니다", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}
