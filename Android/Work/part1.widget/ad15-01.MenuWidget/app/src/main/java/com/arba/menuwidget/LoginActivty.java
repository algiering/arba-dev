package com.arba.menuwidget;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("ID", edtId.getText().toString());
                editor.putString("PASSWORD", edtPw.getText().toString());
                editor.apply();
            }
        });

        pref = getSharedPreferences("settings", MODE_PRIVATE);

        String id = pref.getString("ID","");
        String pw = pref.getString("PASSWORD","");

        edtId.setText(id);
        edtPw.setText(pw);
    }
}
