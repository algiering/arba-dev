package com.arba.ad33_01fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_image0);
        btn1 = findViewById(R.id.btn_image1);
        btn2 = findViewById(R.id.btn_image2);

        ClickListener cl = new ClickListener();

        btn0.setOnClickListener(cl);
        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);

    }

    private class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            FragmentThr fragment = (FragmentThr) getSupportFragmentManager().findFragmentById(R.id.fragment3);

            switch (v.getId()) {
                case R.id.btn_image0:
                    fragment.update(0);
                    break;

                case R.id.btn_image1:
                    fragment.update(1);
                    break;

                case R.id.btn_image2:
                    fragment.update(2);
                    break;
            }
        }
    }
}
