package com.arba.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class CunningActivity extends AppCompatActivity {

    private TextView  textCunning, textAnswer;
    private Button    btnAnswer;
    private ModelQuiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cunning);

        textCunning = findViewById(R.id.text_cunning);
        textAnswer  = findViewById(R.id.text_answer );

        btnAnswer   = findViewById(R.id.btn_answer  );

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textCunning.setText("정답은");
                quiz = getIntent().getParcelableExtra("quiz");
                textAnswer.setText(String.valueOf(quiz.isAnswer()).toUpperCase());
                textAnswer.setVisibility(View.VISIBLE);

                Intent intent = new Intent();
                intent.putExtra("cunning", true);
                setResult(RESULT_OK, intent);
            }
        });
    }

    @Override
    protected void onStop() {
        Toast.makeText(CunningActivity.this, "컨닝은 나쁜거에요", Toast.LENGTH_SHORT).show();
        super.onStop();
    }


}
