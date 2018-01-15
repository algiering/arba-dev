package com.arba.openactivity;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonListener bl = new ButtonListener();

        btn1.setOnClickListener(bl);
        btn2.setOnClickListener(bl);
        btn3.setOnClickListener(bl);
    }

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                    intent.putExtra("val", "1");
                    startActivity(intent);
                    break;

                case R.id.btn2:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("val", "2");
                    startActivity(intent);
                    break;

                case R.id.btn3:
                    ComponentName compName = new ComponentName("com.arba.openactivity", "com.arba.openactivity.SecondActivity");

                    intent = new Intent();
                    intent.setComponent(compName);
                    intent.putExtra("val", "3");
                    startActivity(intent);
                    break;
            }
        }
    }
}
