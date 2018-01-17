package com.arba.activitylifecycle;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String LIFE_CYCLE = "csrpsd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LIFE_CYCLE, "Create");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LIFE_CYCLE, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LIFE_CYCLE, "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LIFE_CYCLE, "Pause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LIFE_CYCLE, "SaveInstance");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(LIFE_CYCLE, "Stop");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LIFE_CYCLE, "RestoreInstance");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LIFE_CYCLE, "Destoroy");
    }
}
