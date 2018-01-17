package com.arba.geoquiz;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

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
                    CheckTF(quizList.get(count).isAnswer());
                    break;

                case R.id.btn_false:
                    CheckTF(!quizList.get(count).isAnswer());
                    break;

                case R.id.btn_cunning:
                    if (count == quizList.size() - 1) {
                        break;
                    }
                    Intent intent = new Intent(MainActivity.this, CunningActivity.class);
                    ModelQuiz quiz = quizList.get(count);
                    intent.putExtra("quiz", quiz);
                    startActivityForResult(intent, Quiz.REQUSET_CODE_CUNNING);
                    break;

                case R.id.btn_next:
                    if (count == quizList.size() - 1) {
                        ShowToast(Quiz.TEXT_NO_MORE_QUIZ);

                        CheckCunning();
                        break;
                    } else {
                        SetQuiz();
                        break;
                    }

                case R.id.btn_prev:
                    if (count == 0) {
                        ShowToast("1번 문제 입니다");
                        break;
                    } else {
                        count--;
                        textQuiz.setText(quizList.get(count).getQuiz());
                        break;
                    }
            }
        }
    }

    private void CheckTF(boolean check) {
        if (count == quizList.size() - 1) {
            ShowToast(Quiz.TEXT_NO_MORE_QUIZ);
            CheckCunning();
            return;
        }
        if (check) {
            ShowToast(Quiz.TEXT_CORRECT);
            quizList.get(count).setCorrect(true);
            SetQuiz();
        } else {
            ShowToast(Quiz.TEXT_INCORRECT);
            quizList.get(count).setCorrect(false);
            SetQuiz();
        }
    }

    private void ShowToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    private void SetQuiz() {
        count++;
        textQuiz.setText(quizList.get(count).getQuiz());
    }

    private void CheckCunning() {
        int temp_count = 0;
        int correct_count = 0;
        for (ModelQuiz temp : quizList) {
            if (temp.isCunning()) {
                temp_count++;
            }
            if (temp.isCorrect()) {
                correct_count++;
            }
        }

        textQuiz.setText(correct_count + "개 정답"+"\n" + "커닝을 " + temp_count + " 번 했습니다");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            quizList.get(count).setCunning(data.getBooleanExtra("cunning", false));
            this.quizList = data.getParcelableArrayListExtra("quiztemp");
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
        outState.putInt("count", count);
        outState.putParcelableArrayList("quiztemp", (ArrayList<? extends Parcelable>) quizList);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        this.count = savedInstanceState.getInt("count");
        textQuiz.setText(quizList.get(count).getQuiz());
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
