package com.arba.startactivityforresult;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button   btnAdd;
    private TextView textResult;
    private final int REQUEST_CODE_MAIN = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1  = findViewById(R.id.edit_text1 );
        editText2  = findViewById(R.id.edit_text2 );
        btnAdd     = findViewById(R.id.btn_add    );
        textResult = findViewById(R.id.text_result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                int[] val = new int[]{Integer.valueOf(editText1.getText().toString()), Integer.valueOf(editText2.getText().toString())};
                i.putExtra("val", val);
                startActivityForResult(i, REQUEST_CODE_MAIN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (REQUEST_CODE_MAIN == requestCode && resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            textResult.setText(String.valueOf(result));
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setIcon(R.mipmap.ic_launcher);
            alert.setMessage("계산결과 :" + result);
            alert.setPositiveButton("확인", null);
            alert.show();
        }
        else {

        }
    }
}
