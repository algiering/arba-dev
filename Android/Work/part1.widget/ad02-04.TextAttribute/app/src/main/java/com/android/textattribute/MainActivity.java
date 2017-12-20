package com.android.textattribute;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //setTitle("속성 변경 후 : 타이핑");
        setTitle(R.string.app_name2);

        txt1.setTextSize(20);

        txt2.setTextColor(Color.parseColor("#0000FF"));

        txt3.setTypeface(null, Typeface.BOLD_ITALIC);

        txt4.setTypeface(Typeface.SERIF);

        txt5.setSingleLine();

        txt6.setText("안녕하세요");
        txt6.setTextColor(Color.RED);

        txt7.setTextSize(40);
        txt7.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);

        txt8.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하");
        txt8.setSingleLine();
    }
}
