package com.arba.mainthread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView count;
    int mCount = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = findViewById(R.id.count);

        // Handler
        // Thread
        // Runnerble

        handler = new Handler();

        Thread countThread = new Thread(){
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    Log.i("superdroid", "Current Count" + mCount);

                    mCount++;



                    try {

                        // Runnerble construct
                        Runnable message = new Runnable() {
                            @Override
                            public void run() {
                                count.setText("Count : "+mCount);
                            }
                        };

                        handler.post(message);


                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        countThread.start();
    }
}
