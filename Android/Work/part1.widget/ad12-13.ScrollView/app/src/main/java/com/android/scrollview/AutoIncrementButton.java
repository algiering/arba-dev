package com.android.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class AutoIncrementButton extends AppCompatActivity {

    private ScrollView scroll;
    private LinearLayout linear;

    private int cnt = 1;

    LinearLayout.LayoutParams lp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_increment_button);

        scroll = findViewById(R.id.scroll);
        linear = findViewById(R.id.linear);

        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp.setMargins(10, 10, 10, 10);

        ScrollInner si = new ScrollInner();

        scroll.getViewTreeObserver().addOnScrollChangedListener(si);

    }

    private class ScrollInner implements ViewTreeObserver.OnScrollChangedListener {
        @Override
        public void onScrollChanged() {
            if (linear.getHeight() == scroll.getScrollY() + scroll.getHeight()) {
                AddButton(lp);
            }
        }
    }

    private void AddButton(LinearLayout.LayoutParams lp) {
        Button btn = new Button(getApplicationContext());
        btn.setLayoutParams(lp);
        btn.setBackgroundColor(Color.BLACK);
        btn.setText("Added Button " + cnt);
        linear.addView(btn);

        cnt++;
    }
}