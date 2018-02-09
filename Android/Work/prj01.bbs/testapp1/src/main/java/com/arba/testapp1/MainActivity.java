package com.arba.testapp1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtId, edtPw;
    private Button btnLogin;

    public long result = -2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edt_id);
        edtPw = findViewById(R.id.edt_pw);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpGetData(MainActivity.this).execute();

            }
        });
    }

    private class HttpGetData extends SiteAsyncTask<Integer, Integer, Long> {

        public HttpGetData(Context context) {
            super(context);
        }

        @Override
        protected Long doInBackground(Integer... integers) {

            long result = -1;

            String id = edtId.getText().toString();
            String pw = edtPw.getText().toString();

            result = new HttpPerson().loginperson(id, pw);

            return result;
        }

        @Override
        protected void onPostExecute(Long list) {
            super.onPostExecute(list);
            result = list;
            Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
        }
    }
}
