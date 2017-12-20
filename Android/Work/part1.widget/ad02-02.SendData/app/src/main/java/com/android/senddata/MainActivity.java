package com.android.senddata;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText inputF;
    private TextView textF;
    private Button btnSend;


    private Button btnToast;
    private Button btnGoogle;

    /*
    private Button btnDial;
    private Button btnMyAct;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputF = findViewById(R.id.inputF);
        textF = findViewById(R.id.textF);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = inputF.getText().toString();
                textF.setText(tmp);
            }
        });

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = inputF.getText().toString();
                Toast.makeText(getApplicationContext(),tmp,Toast.LENGTH_SHORT).show();
            }
        });

        btnGoogle = findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = inputF.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q="+tmp));
                startActivity(i);
            }
        });
/*
        btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = inputF.getText().toString();
            }
        });

        btnMyAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
*/
    }
}
