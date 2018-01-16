package com.arba.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        text = findViewById(R.id.text);

        Intent intent = getIntent();

        String d1 = intent.getStringExtra("data");

        if (d1 != null && !d1.isEmpty()) {
            text.setText(text.getText() + d1 + "\n");
        }

        int[] array = intent.getIntArrayExtra("data");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                text.setText(text.getText() + String.valueOf(array[i]));
            }
        }

        ModelSerial serial = (ModelSerial) intent.getSerializableExtra("data");
        if (serial != null) {
            text.setText(serial.getIdata() + " : " + serial.getSdata());
        }
    }
}
