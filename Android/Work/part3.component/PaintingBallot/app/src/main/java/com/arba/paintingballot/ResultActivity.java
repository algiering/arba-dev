package com.arba.paintingballot;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {

    private ImageView image_result;
    private TextView text_result;

    private TextView textview1, textview2, textview3, textview4, textview5, textview6, textview7, textview8, textview9;
    private RatingBar rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8, rating9;
    private String[] title;
    private TextView text_rating1, text_rating2, text_rating3, text_rating4, text_rating5, text_rating6, text_rating7, text_rating8, text_rating9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        int[] vote = intent.getIntArrayExtra("vote");
        title = intent.getStringArrayExtra("title");

        image_result = findViewById(R.id.image_result);

        text_result = findViewById(R.id.text_result);

        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);
        textview4 = findViewById(R.id.textview4);
        textview5 = findViewById(R.id.textview5);
        textview6 = findViewById(R.id.textview6);
        textview7 = findViewById(R.id.textview7);
        textview8 = findViewById(R.id.textview8);
        textview9 = findViewById(R.id.textview9);

        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);
        rating4 = findViewById(R.id.rating4);
        rating5 = findViewById(R.id.rating5);
        rating6 = findViewById(R.id.rating6);
        rating7 = findViewById(R.id.rating7);
        rating8 = findViewById(R.id.rating8);
        rating9 = findViewById(R.id.rating9);

        text_rating1 = findViewById(R.id.text_rating1);
        text_rating2 = findViewById(R.id.text_rating2);
        text_rating3 = findViewById(R.id.text_rating3);
        text_rating4 = findViewById(R.id.text_rating4);
        text_rating5 = findViewById(R.id.text_rating5);
        text_rating6 = findViewById(R.id.text_rating6);
        text_rating7 = findViewById(R.id.text_rating7);
        text_rating8 = findViewById(R.id.text_rating8);
        text_rating9 = findViewById(R.id.text_rating9);

        TextView[] textViews = {textview1, textview2, textview3, textview4, textview5, textview6, textview7, textview8, textview9};
        RatingBar[] ratingBars = {rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8, rating9};
        TextView[] textRatings = {text_rating1, text_rating2, text_rating3, text_rating4, text_rating5, text_rating6, text_rating7, text_rating8, text_rating9};


        for (int i = 0; i < 9; i++) {
            textViews[i].setText(title[i]);
            ratingBars[i].setRating(vote[i] / 10f);
            textRatings[i].setText(vote[i] + "표");
        }

        int[] temp = Arrays.copyOf(vote, 9);

        Arrays.sort(temp);
        text_result.setText(temp.toString());

        for (int i = 0; i < 9; i++) {
            if (temp[temp.length - 1] == vote[i]) {
                text_result.setText(title[i]);
                image_result.setImageDrawable(MatchDrawable(title[i]));
            }
        }
    }

    private Drawable MatchDrawable(String s) {
        Drawable d;
        if (s.equals(title[0])) {
            d = getResources().getDrawable(R.drawable.mov00);
            return d;
        } else if (s.equals(title[1])) {
            d = getResources().getDrawable(R.drawable.mov01);
            return d;
        } else if (s.equals(title[2])) {
            d = getResources().getDrawable(R.drawable.mov02);
            return d;
        } else if (s.equals(title[3])) {
            d = getResources().getDrawable(R.drawable.mov03);
            return d;
        } else if (s.equals(title[4])) {
            d = getResources().getDrawable(R.drawable.mov04);
            return d;
        } else if (s.equals(title[5])) {
            d = getResources().getDrawable(R.drawable.mov05);
            return d;
        } else if (s.equals(title[6])) {
            d = getResources().getDrawable(R.drawable.mov06);
            return d;
        } else if (s.equals(title[7])) {
            d = getResources().getDrawable(R.drawable.mov07);
            return d;
        } else if (s.equals(title[8])) {
            d = getResources().getDrawable(R.drawable.mov08);
            return d;
        } else if (s.equals(title[9])) {
            d = getResources().getDrawable(R.drawable.mov09);
            return d;
        } else {
            return null;
        }
    }
}
