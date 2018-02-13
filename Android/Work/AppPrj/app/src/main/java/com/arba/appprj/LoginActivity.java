package com.arba.appprj;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.arba.appprj.common.SiteAsyncTask;
import com.arba.appprj.https.HttpUser;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_id, edit_pw;
    private Button btn_login;

    private int result = -4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_id = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_pw);

        btn_login = findViewById(R.id.btn_login);

        mClickListener mClickListener = new mClickListener();

        btn_login.setOnClickListener(mClickListener);

    }

    private class mClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    new mAsyncTask(LoginActivity.this).execute();
                    break;
            }
        }
    }

    private class mAsyncTask extends SiteAsyncTask<Integer,Integer,Integer> {

        public mAsyncTask(Context context) {
            super(context);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {

            String user_id = edit_id.getText().toString();
            String user_pw = edit_pw.getText().toString();

            int result = new HttpUser().getLogin(user_id, user_pw);
            return result;
        }

        @Override
        protected void onPostExecute(Integer list) {
            super.onPostExecute(list);
            result = list;

            if (result == 1) {
                Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, IndexActivity.class);
                startActivity(i);
                finish();
            }

            else {
                Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
