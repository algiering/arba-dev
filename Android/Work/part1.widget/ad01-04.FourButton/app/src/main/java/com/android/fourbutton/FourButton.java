package com.android.fourbutton;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourButton extends AppCompatActivity {

    Button onNate;
    Button on911;
    Button onGallary;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_button);

        onNate = findViewById(R.id.onNate);

        onNate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),R.string.onNateMsg,Toast.LENGTH_SHORT).show();
               startActivity
                       (new Intent(Intent.ACTION_VIEW,
                               Uri.parse("http://www.nate.com")));
            }
        });

        on911 = findViewById(R.id.on911);

        on911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),R.string.on911Msg,Toast.LENGTH_SHORT).show();
                startActivity
                        (new Intent(Intent.ACTION_VIEW)
                                .setData(Uri.parse("tel://911")));
            }
        });

        onGallary = findViewById(R.id.onGallary);

        onGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),R.string.onGallaryMsg,Toast.LENGTH_SHORT).show();
                startActivity
                        (new Intent(Intent.ACTION_VIEW)
                                .setData(Uri.parse("content://media/internal/images/media")));
            }
        });

        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),R.string.exitMsg,Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
