package com.arba.inflation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn2;
    private Button btn3;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = findViewById(R.id.container);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.layout_sub1, container, true);

                CheckBox chk = container.findViewById(R.id.checkBox);
                chk.setText("inflation 완료");

                Button btn_sub = container.findViewById(R.id.btn_sub);
                btn_sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = container.findViewById(R.id.textView);
                        textView.setText("inflation후 버튼클릭리스너 완료");

                    }
                });
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = findViewById(R.id.container);
                LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_sub1, container, true);

                Button btn_sub = container.findViewById(R.id.btn_sub);
                btn_sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = container.findViewById(R.id.textView);
                        textView.setText("inflation후 버튼클릭리스너 완료");

                    }
                });

            }

        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container = findViewById(R.id.container);
                View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_sub1, null);
                container.addView(v);

                Button btn_sub = container.findViewById(R.id.btn_sub);
                btn_sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView textView = container.findViewById(R.id.textView);
                        textView.setText("inflation후 버튼클릭리스너 완료");
                    }
                });

            }

        });
    }
}
