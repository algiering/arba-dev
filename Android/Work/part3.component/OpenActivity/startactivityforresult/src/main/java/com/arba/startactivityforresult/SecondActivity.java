package com.arba.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnReturn = findViewById(R.id.btn_return);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                int[] val = i.getIntArrayExtra("val");

                int result = val[0] + val[1];
                i.putExtra("result", result);

                setResult(RESULT_OK, i);

                SecondActivity.this.finish();
            }
        });
    }
}
