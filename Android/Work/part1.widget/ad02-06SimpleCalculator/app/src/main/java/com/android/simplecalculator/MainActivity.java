package com.android.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;

    private TextView txt1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);

        edit1 = findViewById(R.id.editText1);
        edit2 = findViewById(R.id.editText2);

        txt1 = findViewById(R.id.textView1);


        InnerClass cal = new InnerClass();

        btn1.setOnClickListener(cal);
        btn2.setOnClickListener(cal);
        btn3.setOnClickListener(cal);
        btn4.setOnClickListener(cal);
        btn5.setOnClickListener(cal);
    }

    private class InnerClass implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Double a = null;
            Double b = null;

            String result;

            if (!edit1.getText().toString().equals("") && !edit2.getText().toString().equals("")) {
                a = Double.valueOf(edit1.getText().toString());
                b = Double.valueOf(edit2.getText().toString());
            }

            if (a == null || b == null) {
                Toast.makeText(getApplicationContext(), "숫자를 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            switch (view.getId()) {
                case R.id.button1:
                    result = String.valueOf(a + b);
                    txt1.setText(result);
                    break;

                case R.id.button2:
                    result = String.valueOf(a - b);
                    txt1.setText(result);
                    break;

                case R.id.button3:
                    result = String.valueOf(a * b);
                    txt1.setText(result);
                    break;

                case R.id.button4:
                    if (b == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        result = String.valueOf(a / b);
                        txt1.setText(result);
                        break;
                    }

                case R.id.button5:
                    if (b == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        result = String.valueOf(a % b);
                        txt1.setText(result);
                        break;
                    }
            }
        }
    }
}
