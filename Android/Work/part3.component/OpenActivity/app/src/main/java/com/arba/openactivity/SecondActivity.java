package com.arba.openactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private Button btn_finish;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_finish = findViewById(R.id.btn_finish);
        textView1  = findViewById(R.id.textview1 );

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String val = intent.getStringExtra("val");
        textView1.setText(val);

    }
}
