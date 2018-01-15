package com.arba.startactivityforresult;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A_Activity extends AppCompatActivity {

    private EditText edit_text1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        edit_text1 = findViewById(R.id.edit_text1);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(A_Activity.this, B_Activity.class);
                i.putExtra("val", edit_text1.getText().toString());
                startActivity(i);
            }
        });
    }
}
