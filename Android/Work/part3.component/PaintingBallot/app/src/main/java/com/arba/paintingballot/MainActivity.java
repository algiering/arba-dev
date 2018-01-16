package com.arba.paintingballot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    private Button    btn_finish;
    private TextView  text_vote;

    private int[] vote;
    private String[] title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        btn_finish = findViewById(R.id.btn_finish);

        text_vote = findViewById(R.id.text_vote);

        vote = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        title = new String[]{"월E", "써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투 동막골"};

        ClickListener cl = new ClickListener();

        image1.setOnClickListener(cl);
        image2.setOnClickListener(cl);
        image3.setOnClickListener(cl);
        image4.setOnClickListener(cl);
        image5.setOnClickListener(cl);
        image6.setOnClickListener(cl);
        image7.setOnClickListener(cl);
        image8.setOnClickListener(cl);
        image9.setOnClickListener(cl);

        btn_finish.setOnClickListener(cl);

    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image1:
                    Vote(0);
                    break;

                case R.id.image2:
                    Vote(1);
                    break;

                case R.id.image3:
                    Vote(2);
                    break;

                case R.id.image4:
                    Vote(3);
                    break;

                case R.id.image5:
                    Vote(4);
                    break;

                case R.id.image6:
                    Vote(5);
                    break;

                case R.id.image7:
                    Vote(6);
                    break;

                case R.id.image8:
                    Vote(7);
                    break;

                case R.id.image9:
                    Vote(8);
                    break;

                case R.id.btn_finish:
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("vote", vote);
                    intent.putExtra("title", title);

                    startActivity(intent);
                    break;
            }
        }
    }

    private void Vote(int i) {
        vote[i] = vote[i] + 1;
        text_vote.setText(title[i] + " : " + vote[i] + "표");
    }
}
