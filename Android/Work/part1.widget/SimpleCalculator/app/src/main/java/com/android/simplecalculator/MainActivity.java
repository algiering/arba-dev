package com.android.simplecalculator;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;

    private TextView txt1;

    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(R.string.app_name2);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);

        edit1 = findViewById(R.id.editText1);
        edit2 = findViewById(R.id.editText2);

        txt1 = findViewById(R.id.textView1);

        linear = findViewById(R.id.linear);

        InnerClass cal = new InnerClass();

        btn1.setOnClickListener(cal);
        btn2.setOnClickListener(cal);
        btn3.setOnClickListener(cal);
        btn4.setOnClickListener(cal);
        btn5.setOnClickListener(cal);

        linear.setOnClickListener(cal);
    }

    private class InnerClass implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            int tmp = view.getId();

            Double a = null;
            Double b = null;

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(linear.getWindowToken(), 0);
            }

            String result;

            if (!edit1.getText().toString().equals("") && !edit2.getText().toString().equals("")) {
                a = Double.valueOf(edit1.getText().toString());
                b = Double.valueOf(edit2.getText().toString());
            }

            if ((a == null || b == null) && tmp != R.id.linear) {
                Toast.makeText(getApplicationContext(), "두 값을 모두 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (b == 0 &&(tmp == R.id.button4 || tmp == R.id.button5 )) {
                Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            switch (tmp) {
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
                    result = String.valueOf(a / b);
                    txt1.setText(result);
                    break;

                case R.id.button5:
                    result = String.valueOf(a % b);
                    txt1.setText(result);
                    break;
            }
        }
    }
}