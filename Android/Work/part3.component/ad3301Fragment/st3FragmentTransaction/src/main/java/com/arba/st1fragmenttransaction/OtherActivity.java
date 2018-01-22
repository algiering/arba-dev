package com.arba.st1fragmenttransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class OtherActivity extends AppCompatActivity {

    private Button btnOther;
    private EditText editOther;
    private TextView textOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        btnOther = findViewById(R.id.btn_other);
        editOther = findViewById(R.id.edit_other);
        textOther = findViewById(R.id.text_other);

        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editOther.getText().toString();
                Intent i = new Intent();

                i.putExtra(Common.OTHER_RESULT, result);

                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
