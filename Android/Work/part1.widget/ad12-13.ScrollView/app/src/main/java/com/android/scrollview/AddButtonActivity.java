package com.android.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AddButtonActivity extends AppCompatActivity {

    private Button btnAdd;
    private LinearLayout scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);

        btnAdd = findViewById(R.id.btnAdd);
        scroll = findViewById(R.id.scroll);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                lp.setMargins(10, 10, 10, 10);

                Button btn = new Button(getApplicationContext());
                btn.setText(R.string.app_name);
                btn.setText("push me");
                btn.setLayoutParams(lp);
                btn.setBackgroundColor(Color.BLACK);

                scroll.addView(btn);
            }
        });
    }
}
