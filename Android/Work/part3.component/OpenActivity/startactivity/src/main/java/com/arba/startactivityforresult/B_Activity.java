package com.arba.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class B_Activity extends AppCompatActivity {

    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        textview1 = findViewById(R.id.textview1);

        Intent i = getIntent();

        textview1.setText(i.getStringExtra("val"));
    }
}
