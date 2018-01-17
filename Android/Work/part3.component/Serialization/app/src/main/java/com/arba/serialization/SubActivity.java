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

        int[] array = intent.getIntArrayExtra("array");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                text.setText(text.getText() + String.valueOf(array[i]));
            }
        }

        ModelSerial serial = (ModelSerial) intent.getSerializableExtra("serial");
        if (serial != null) {
            text.setText(serial.getIdata() + " : " + serial.getSdata());
        }

        ModelParcel parcel = intent.getParcelableExtra("parcel");
        if (parcel != null) {
            text.setText(parcel.getIdata() + " : " + parcel.getSdata());
        }

        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle != null) {
            text.setText(bundle.getInt("idata") + " : " + bundle.getString("sdata"));
        }
    }
}
