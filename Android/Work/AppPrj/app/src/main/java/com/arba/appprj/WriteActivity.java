package com.arba.appprj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpArticle;

public class WriteActivity extends AppCompatActivity {

    private EditText edit_title;
    private EditText edit_content;
    private Button btn_list;
    private Button btn_write;
    private Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        edit_title = findViewById(R.id.edit_title);
        edit_content = findViewById(R.id.edit_content);
        btn_list = findViewById(R.id.btn_list);
        btn_write = findViewById(R.id.btn_write);
        btn_cancel = findViewById(R.id.btn_cancel);

        mClickListener mClickListener = new mClickListener();

        btn_list.setOnClickListener(mClickListener);
        btn_write.setOnClickListener(mClickListener);
        btn_cancel.setOnClickListener(mClickListener);

    }

    private class mClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_list:
                    setResult(10400);
                    finish();
                    break;

                case R.id.btn_write:
                    String article_title = edit_title.getText().toString();
                    String article_content = edit_content.getText().toString();
                    String board_id = getIntent().getStringExtra("board_id");

                    new mAsyncTask(WriteActivity.this).execute(article_title, article_content, board_id);

                    break;

                case R.id.btn_cancel:
                    setResult(10400);
                    finish();
                    break;
            }
        }
    }

    private class mAsyncTask extends SiteAsyncTask<String, Integer, Integer> {
        public mAsyncTask(Context context) {
            super(context);
        }

        @Override
        protected Integer doInBackground(String... strings) {
            int result = -3;

            result = new HttpArticle().insertArticle(strings[0], strings[1], strings[2]);
            return result;
        }

        @Override
        protected void onPostExecute(Integer list) {
            super.onPostExecute(list);

            if (list == 1) {
                setResult(10400);
                finish();
            }
        }
    }
}
