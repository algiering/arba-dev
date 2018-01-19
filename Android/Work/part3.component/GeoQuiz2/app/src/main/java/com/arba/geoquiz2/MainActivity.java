package com.arba.geoquiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textQuiz;
    private Button btnTrue, btnFalse, btnCunning, btnNext, btnPrev;

    private List<ModelQuiz> quizList;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuiz = findViewById(R.id.text_quiz);

        btnTrue = findViewById(R.id.btn_true);
        btnFalse = findViewById(R.id.btn_false);
        btnCunning = findViewById(R.id.btn_cunning);
        btnNext = findViewById(R.id.btn_next);
        btnPrev = findViewById(R.id.btn_prev);

        initData();

        textQuiz.setText(quizList.get(0).getQuiz());

        ClickListener cl = new ClickListener();

        btnTrue.setOnClickListener(cl);
        btnFalse.setOnClickListener(cl);
        btnCunning.setOnClickListener(cl);
        btnNext.setOnClickListener(cl);
        btnPrev.setOnClickListener(cl);

    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_true:
                    break;

                case R.id.btn_false:
                    break;

                case R.id.btn_cunning:
                    Intent intent = new Intent(getApplicationContext(), CunningActivity.class);
                    ModelQuiz quiz = quizList.get(count);
                    intent.putExtra("quiz", quiz);
                    startActivityForResult(intent, Quiz.REQUSET_CODE_CUNNING);
                    break;

                case R.id.btn_next:
                    break;

                case R.id.btn_prev:
                    break;
            }
        }
    }

    private void initData() {
        quizList = new ArrayList<>();

        ModelQuiz quiz1 = new ModelQuiz();
        quiz1.setQuiz("태평양은 대서양보다 더 크다");
        quiz1.setAnswer(true);
        quizList.add(quiz1);

        ModelQuiz quiz2 = new ModelQuiz();
        quiz2.setQuiz("수에즈 운하는 홍해와 인도양을 연결한다");
        quiz2.setAnswer(false);
        quizList.add(quiz2);

        ModelQuiz quiz3 = new ModelQuiz();
        quiz3.setQuiz("나일강은 이집트에서 시작된다");
        quiz3.setAnswer(false);
        quizList.add(quiz3);

        ModelQuiz quiz4 = new ModelQuiz();
        quiz4.setQuiz("아마존강은 아메리카 대륙에서 가장 긴 강이다");
        quiz4.setAnswer(true);
        quizList.add(quiz4);

        ModelQuiz quiz5 = new ModelQuiz();
        quiz5.setQuiz("바이칼 호수는 세계에서 가장 오래되고 가장 깊은 담수호이다");
        quiz5.setAnswer(true);
        quizList.add(quiz5);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            quizList.get(count).setCunning(data.getBooleanExtra("cunning", false));
        }
    }
}
