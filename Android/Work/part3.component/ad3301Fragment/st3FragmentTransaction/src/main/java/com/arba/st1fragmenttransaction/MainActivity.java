package com.arba.st1fragmenttransaction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentTwo.OnMessegeCallBack{

    private static final String FRAGMENT_TAG_ONE = "one";
    private static final String FRAGMENT_TAG_TWO = "two";
    private Button btn0, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);

        ClickListener cl = new ClickListener();

        btn0.setOnClickListener(cl);
        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);
    }

    private class ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_0:
                    Fragment old = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_ONE);

                    if (old == null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentOne f = new FragmentOne();
                        ft.replace(R.id.container, f, FRAGMENT_TAG_ONE);
                        ft.commit();
                    }

                    else {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, old, FRAGMENT_TAG_ONE);
                        ft.commit();
                    }
                    break;

                case R.id.btn_1:
                    Fragment old2 = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_TWO);

                    if (old2 == null) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentTwo f = FragmentTwo.newInstance("fragment two");
                        ft.replace(R.id.container, f, FRAGMENT_TAG_TWO);
                        ft.commit();
                    }

                    else {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container, old2, FRAGMENT_TAG_TWO);
                        ft.commit();
                    }
                    break;

                case R.id.btn_2:
                    break;
            }
        }
    }

    public void update(String msg) {
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText(msg);
    }

    @Override
    public void displayMessage(String message) {
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText(message);
    }
}
