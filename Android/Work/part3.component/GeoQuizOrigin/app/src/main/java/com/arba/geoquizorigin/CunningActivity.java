package com.arba.geoquizorigin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class CunningActivity extends AppCompatActivity {

    private TextView textCunning, textAnswer;
    private Button   btn_answer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cunning);

        textCunning = findViewById(R.id.text_cunning);
        textAnswer  = findViewById(R.id.text_answer);
        btn_answer  = findViewById(R.id.btn_answer);

        final Intent intent = getIntent();
        boolean b = intent.getBooleanExtra("data", false);
        textAnswer.setText(String.valueOf(b).toUpperCase());

        btn_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAnswer.setVisibility(View.VISIBLE);
                intent.putExtra("data", true);
                setResult(RESULT_OK, intent);
            }
        });
    }
}
