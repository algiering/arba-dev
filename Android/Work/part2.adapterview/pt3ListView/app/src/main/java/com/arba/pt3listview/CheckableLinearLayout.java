package com.arba.pt3listview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

/**
 * Created by Algieba on 2017-12-31.
 */

public class CheckableLinearLayout extends LinearLayout implements Checkable {

    public CheckableLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {

        CheckBox checkBox = findViewById(R.id.custom_checkbox);

        if (checkBox.isChecked() != checked) {
            checkBox.setChecked(checked);
        }

    }

    @Override
    public boolean isChecked() {

        CheckBox checkBox = findViewById(R.id.custom_checkbox);

        return checkBox.isChecked();
    }

    @Override
    public void toggle() {

        CheckBox cb = findViewById(R.id.custom_checkbox);

        setChecked(cb.isChecked() ? false : true);

    }
}
