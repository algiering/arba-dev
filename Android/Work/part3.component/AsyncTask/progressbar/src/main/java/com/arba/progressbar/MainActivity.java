package com.arba.progressbar;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private Button btnInc;
    private Button btnDec;
    private Button button1;
    private TextView tvSeek;
    private SeekBar seekBar1;
    private TextView tv1;
    private SeekBar pb1;
    private TextView tv2;
    private SeekBar pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        btnInc = findViewById(R.id.btnInc);
        btnDec = findViewById(R.id.btnDec);
        button1 = findViewById(R.id.button1);
        tvSeek = findViewById(R.id.tvSeek);
        seekBar1 = findViewById(R.id.seekBar1);
        tv1 = findViewById(R.id.tv1);
        pb1 = findViewById(R.id.pb1);
        tv2 = findViewById(R.id.tv2);
        pb2 = findViewById(R.id.pb2);

        ButtonListener bl = new ButtonListener();

        btnInc.setOnClickListener(bl);
        btnDec.setOnClickListener(bl);
        button1.setOnClickListener(bl);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행률 : " + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnInc:
                    progressBar1.incrementProgressBy(10);
                    break;

                case R.id.btnDec:
                    progressBar1.incrementProgressBy(-10);
                    break;

                case R.id.button1:
                    new ThreadTask().execute(2, 1);
                    break;
            }
        }
    }

    private class ThreadTask extends AsyncTask<Integer, Integer, Boolean> {

        private ProgressDialog pdlg;

        @Override
        protected void onPreExecute() {
            button1.setEnabled(false);
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            for (;;) {
                if ((pb1.getProgress() != pb1.getMax())||(pb2.getProgress() != pb2.getMax())) {
                    publishProgress(integers[0], integers[1]);

                    SystemClock.sleep(100);
                }
                else {
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (pb1.getProgress()==pb1.getMax()) {
            }
            else {
                pb1.setProgress(pb1.getProgress() + values[0]);
                tv1.setText("진행률 : " + pb1.getProgress() + " %");
            }

            if (pb2.getProgress()==pb2.getMax()) {
            }
            else {
                pb2.setProgress(pb2.getProgress() + values[1]);
                tv2.setText("진행률 : " + pb2.getProgress() + " %");
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            button1.setEnabled(true);
        }
    }
}
