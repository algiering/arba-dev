package com.arba.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-28.
 */

public class PersonView extends LinearLayout {

    private TextView txtName, txtComp, txtNum;
    private LinearLayout linearCustom;
    private PersonData person;

    public interface OnTextViewClickListener {
        void onTextViewClick(PersonView view, PersonData person);
     }

     OnTextViewClickListener textViewClickListener;

    public void setOnTextViewClickListner(OnTextViewClickListener listener) {
        this.textViewClickListener = listener;
    }

    public PersonView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PersonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PersonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_person, this, true);

        txtName = findViewById(R.id.txtName);
        txtComp = findViewById(R.id.txtComp);
        txtNum = findViewById(R.id.txtNum);
        linearCustom = findViewById(R.id.linearCustom);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
        String name = ta.getString(R.styleable.PersonView_name);
        String comp = ta.getString(R.styleable.PersonView_comp);
        int num = ta.getInt(R.styleable.PersonView_num, -1);

        txtName.setText(name);
        txtComp.setText(comp);
        txtNum.setText(num);

        ta.recycle();

        person = new PersonData(name, comp, num);

        linearCustom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PersonView.this.textViewClickListener != null) {
                    textViewClickListener.onTextViewClick(PersonView.this, person);
                }
            }
        });
    }

}
