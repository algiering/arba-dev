package com.arba.countdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Thread thread;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        thread = new Thread() {
            @Override
            public void run() {
                for (int i = 20; i >= 0; i--) {
                    // 1. Runnerble
                    // 2. Handler
                    count = i;

                    Runnable message = new Runnable() {
                        @Override
                        public void run() {
                            textView.setText( count + "" );

                        }
                    };

                    // Main 으로 전송
                    MainActivity.this.runOnUiThread(message);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
