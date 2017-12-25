package com.arba.menuwidget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivty extends AppCompatActivity {

    private Button btnlogin;
    private EditText edtId;
    private EditText edtPw;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btnLogin);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtId.getText().toString().trim().equals("111") && edtPw.getText().toString().trim().equals("111")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(CommonCode.LOGIN_ID, edtId.getText().toString());
                    //editor.putString("PASSWORD", edtPw.getText().toString());
                    editor.putBoolean(CommonCode.LOGIN_STATUS, true);
                    editor.apply();

                    Intent i = new Intent();
                    i.putExtra("LOGIN_STATUS", true);

                    setResult(RESULT_OK, i);

                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),R.string.login_fail, Toast.LENGTH_SHORT).show();
                }

            }
        });

        pref = getSharedPreferences(CommonCode.FILE_PRIFERENCE, MODE_PRIVATE);

        String id = pref.getString(CommonCode.LOGIN_ID, "");
        String pw = pref.getString(CommonCode.LOGIN_PW, "");

        edtId.setText(id);
        edtPw.setText(pw);
    }
}
