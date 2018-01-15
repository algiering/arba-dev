package com.arba.st2intro;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // new ThreadTask().execute();

        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(i);
                IntroActivity.this.finish();
            }
        };
        h.postDelayed(r, 3000);
    }

    private class ThreadTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            SystemClock.sleep(3000);
            startActivity(intent);
            IntroActivity.this.finish();
            return true;
        }
    }
}
