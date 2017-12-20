package com.android.compoundwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioG1;
    private RadioGroup radioG2;

    private CheckBox chkAnd;
    private CheckBox chkIos;
    private CheckBox chkWin;

    private Switch switch1;

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioG1 = findViewById(R.id.radioG1);
        radioG2 = findViewById(R.id.radioG2);

        chkAnd = findViewById(R.id.chkAnd);
        chkIos = findViewById(R.id.chkIos);
        chkWin = findViewById(R.id.chkWin);

        switch1 = findViewById(R.id.switch1);

        button1 = findViewById(R.id.button1);

        RadioInner ri = new RadioInner();
        radioG1.setOnCheckedChangeListener(ri);
        radioG2.setOnCheckedChangeListener(ri);
    }

    private class RadioInner implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int chkId) {
            if ( chkId == R.id.g1H) {
                radioG1.setOrientation(LinearLayout.HORIZONTAL);
            }
            else if ( chkId == R.id.g1V) {
                radioG1.setOrientation(LinearLayout.VERTICAL);
            }
            else if ( chkId == R.id.g2L) {
                radioG2.setGravity(Gravity.LEFT);
            }
            else if ( chkId == R.id.g2C) {
                radioG2.setGravity(Gravity.CENTER);
            }
            else if ( chkId == R.id.g2R) {
                radioG2.setGravity(Gravity.RIGHT);
            }
        }
    }
}
