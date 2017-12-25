package com.android.addbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn5;
    private LinearLayout scroll;
    private int cnt = 1;
    LinearLayout.LayoutParams lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn5 = findViewById(R.id.btn5);

        scroll = findViewById(R.id.scroll);

        ButtonInner bi = new ButtonInner();

        btn1.setOnClickListener(bi);
        btn5.setOnClickListener(bi);

        lp  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(10, 10, 10, 10);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn1:
                    AddButton(lp);
                    break;

                case R.id.btn5:
                    for (int i = 0; i < 5; i++) {
                        AddButton(lp);
                    }
                    break;
            }
        }
    }

    private void AddButton(LinearLayout.LayoutParams lp) {
        Button btn = new Button(getApplicationContext());
        btn.setLayoutParams(lp);
        btn.setBackgroundColor(Color.BLACK);
        btn.setText("Added Button " + cnt);
        scroll.addView(btn);

        cnt++;
    }
}
