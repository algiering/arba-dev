package com.arba.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        ClickListener cl = new ClickListener();

        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);
        btn3.setOnClickListener(cl);
        btn4.setOnClickListener(cl);
        btn5.setOnClickListener(cl);

    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            switch (v.getId()) {
                case R.id.btn1:
                    intent.putExtra("data", "btn1 : test1");
                    break;

                case R.id.btn2:
                    int[] array = {0,1,2,3,4,5,6,7,8,9};
                    intent.putExtra("data",array);
                    break;

                case R.id.btn3:
                    ModelSerial serial = new ModelSerial();
                    serial.setIdata(55);
                    serial.setSdata("test3");

                    intent.putExtra("data", serial);
                    break;

                case R.id.btn4:
                    break;

                case R.id.btn5:
                    break;
            }
            startActivity(intent);
        }
    }
}
