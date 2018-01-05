package com.arba.checkablelistview2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-05.
 */

public class ViewPerson extends LinearLayout implements Checkable {

    private ImageView img_photo;
    private TextView text_name, text_age;
    private CheckBox checkBox;

    boolean isChecked;

    ModelPerson person;

    public ViewPerson(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewPerson(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewPerson(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.view_person, this, true);

        text_name = findViewById(R.id.text_name);
        text_age = findViewById(R.id.text_age);
        img_photo = findViewById(R.id.img_photo);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            this.isChecked = checked;
            drawCheck();
        }
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {
        this.setChecked(!this.isChecked);
    }

    private void drawCheck() {
        if (this.isChecked()) {
            checkBox.setChecked(this.isChecked);
            this.setBackgroundColor(Color.MAGENTA);
        } else {
            checkBox.setChecked(this.isChecked);
            this.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public ModelPerson getPerson() {
        return person;
    }

    public void setPerson(ModelPerson person) {
        this.person = person;

        img_photo.setImageDrawable(person.getPhoto());
        text_name.setText(person.getName());
        text_age.setText(String.valueOf(person.getAge()));
        this.setChecked(person.isCheck());
    }

    // 1 인터페이스 선언
    public static interface OnCheckedChangedListener {
        void onCheckedChangedListener(View checkableView, boolean isChecked);
    }

    // 2 리스너 선언
    private OnCheckedChangedListener checkedChangedListener;
    public void setOnCheckedChangedListener(OnCheckedChangedListener listener) {
        this.checkedChangedListener = listener;
    }

}
