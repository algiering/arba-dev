package com.arba.st5backstack;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_back, btn_next, btn_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);
        btn_empty = findViewById(R.id.btn_empty);

        ButtonListener bl = new ButtonListener();

        btn_back.setOnClickListener(bl);
        btn_next.setOnClickListener(bl);
        btn_empty.setOnClickListener(bl);
    }


    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            int count = -1;
            FragmentManager fm = getSupportFragmentManager();
            switch (v.getId()) {

                case R.id.btn_back:
                    count = fm.getBackStackEntryCount();
                    if (count > 0) {
                        fm.popBackStack();
                    }
                    break;

                case R.id.btn_next:
                    count = fm.getBackStackEntryCount();
                    if (count < 10) {
                        // Message Fragment make a instance
                        // and add at BackStack

//                        // 방법1
//                        MessageFragment f = new MessageFragment();
//                        Bundle b = new Bundle();
//                        count++;
//                        b.putString(MessageFragment.ARG_PARAM1,"Next Button : " + count);
//                        f.setArguments(b);

                        // 방법2
                        count++;
                        MessageFragment f = MessageFragment.newInstance("Next Button: " + count);

                        fm.beginTransaction()
                                .replace(R.id.container, f)
                                .addToBackStack("Entry + " + count)
                                .commit();
                    }
                    break;

                case R.id.btn_empty:
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    break;
            }
        }
    }
}
