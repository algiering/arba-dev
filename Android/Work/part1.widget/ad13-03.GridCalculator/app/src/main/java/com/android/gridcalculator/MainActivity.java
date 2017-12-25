package com.android.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnDiv;
    Button btnMul;
    Button btnMinus;
    Button btnAdd;
    Button btnBrk;
    Button btnEQ;
    Button btnAC;
    Button btnC;
    Button btnDot;
    Button btnPM;
    Button btncList;
    Button btncAdd;
    Button btncRecent;

    TextView resultTxt;

    String result = "";
    List<String> cList = new ArrayList<>();
    String lastResult = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnMinus = findViewById(R.id.btnMinus);
        btnAdd = findViewById(R.id.btnAdd);
        btnDot = findViewById(R.id.btnDot);
        btnEQ = findViewById(R.id.btnEQ);
        btnPM = findViewById(R.id.btnPM);
        btnBrk = findViewById(R.id.btnBrk);
        btnAC = findViewById(R.id.btnAC);
        btnC = findViewById(R.id.btnC);

        btncList = findViewById(R.id.btncList);
        btncAdd = findViewById(R.id.btncAdd);
        btncRecent = findViewById(R.id.btncRecent);

        ButtonInner bi = new ButtonInner();

        btn0.setOnClickListener(bi);
        btn1.setOnClickListener(bi);
        btn2.setOnClickListener(bi);
        btn3.setOnClickListener(bi);
        btn4.setOnClickListener(bi);
        btn5.setOnClickListener(bi);
        btn6.setOnClickListener(bi);
        btn7.setOnClickListener(bi);
        btn8.setOnClickListener(bi);
        btn9.setOnClickListener(bi);
        btnDiv.setOnClickListener(bi);
        btnMul.setOnClickListener(bi);
        btnMinus.setOnClickListener(bi);
        btnAdd.setOnClickListener(bi);
        btnDot.setOnClickListener(bi);
        btnPM.setOnClickListener(bi);
        btnAC.setOnClickListener(bi);
        btnC.setOnClickListener(bi);
        btnEQ.setOnClickListener(bi);
        btnBrk.setOnClickListener(bi);

        btncList.setOnClickListener(bi);
        btncAdd.setOnClickListener(bi);
        btncRecent.setOnClickListener(bi);


        resultTxt = findViewById(R.id.resultTxt);

        resultTxt.setMovementMethod(new ScrollingMovementMethod());

    }

    private class ButtonInner implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn0:
                    result = result + "0";
                    resultTxt.setText(result);
                    break;

                case R.id.btn1:
                    result = result + "1";
                    resultTxt.setText(result);
                    break;

                case R.id.btn2:
                    result = result + "2";
                    resultTxt.setText(result);
                    break;

                case R.id.btn3:
                    result = result + "3";
                    resultTxt.setText(result);
                    break;

                case R.id.btn4:
                    result = result + "4";
                    resultTxt.setText(result);
                    break;

                case R.id.btn5:
                    result = result + "5";
                    resultTxt.setText(result);
                    break;

                case R.id.btn6:
                    result = result + "6";
                    resultTxt.setText(result);
                    break;

                case R.id.btn7:
                    result = result + "7";
                    resultTxt.setText(result);
                    break;

                case R.id.btn8:
                    result = result + "8";
                    resultTxt.setText(result);
                    break;

                case R.id.btn9:
                    result = result + "9";
                    resultTxt.setText(result);
                    break;

                case R.id.btnDiv:
                    result = result + "÷";
                    resultTxt.setText(result);
                    break;

                case R.id.btnMul:
                    result = result + "×";
                    resultTxt.setText(result);
                    break;

                case R.id.btnMinus:
                    result = result + "-";
                    resultTxt.setText(result);
                    break;

                case R.id.btnAdd:
                    result = result + "+";
                    resultTxt.setText(result);
                    break;

                case R.id.btnBrk:
                    break;

                case R.id.btnAC:
                    result = "";
                    resultTxt.setText(result);
                    break;

                case R.id.btnC:
                    result = "";
                    resultTxt.setText(result);
                    break;

                case R.id.btnEQ:
                    String infixExp = "";

                    if (result.equals("")) {
                        break;
                    }

                    String last = String.valueOf(result.charAt(result.length() - 1));

                    if (last.equals("×") || last.equals("÷") || last.equals("+") || last.equals("-")) {
                        Toast.makeText(getApplicationContext(), "수식은 숫자로 끝나야 합니다", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    infixExp = result.replace("÷", "/");
                    infixExp = infixExp.replace("×", "*");
                    Calc c = new Calc();
                    if (!c.bracketsBalance(infixExp)) {
                        break;
                    }
                    String postfixExp = c.postfix(infixExp);
                    Double dResult = c.result(postfixExp);
                    lastResult = result + "=" + String.valueOf(dResult);
                    resultTxt.setText(lastResult);
                    result = "";
                    break;

                case R.id.btnDot:
                    result = result + ".";
                    resultTxt.setText(result);
                    break;

                case R.id.btnPM:
                    break;

                case R.id.btncList:
                    break;

                case R.id.btncAdd:
                    cList.add(lastResult);
                    break;

                case R.id.btncRecent:
                    String tmp = "";
                    for (String a : cList
                            ) {
                        tmp = tmp + a + "\n";
                    }
                    resultTxt.setText(tmp);
                    result = "";
                    break;

            }
        }
    }
}
