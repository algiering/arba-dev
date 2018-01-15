package com.arba.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = findViewById(R.id.textview1);

        new CounterTask().execute(20);
    }

    private class CounterTask extends AsyncTask<Integer, Integer, Boolean> {

        ProgressDialog pdlg;

        @Override
        protected void onPreExecute() {
            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("Loading...");
            pdlg.getWindow().setGravity(Gravity.TOP);
            pdlg.show();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            // execute 에서 넣은 값이 integers에 넘어옴

            int count = 0 ;
            for ( int i = 0; i < integers[0]; i++) {
                publishProgress( count++, i);

                SystemClock.sleep(1000);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // publishProgress 에서 넣은 값이 values로 넘어옴
            textview1.setText(values[0]+"");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (pdlg != null) {
                pdlg.dismiss();
                pdlg = null;
            }
        }
    }
}
