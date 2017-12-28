package com.arba.st2personview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-26.
 */

public class PersonView extends RelativeLayout{

    private ImageView imageCheck,imagePhoto;
    private TextView textName,textAge;

    private PersonData person;

    // 인터페이스 정의
    public interface OnImageClickListener {
        void onImageClick(PersonView view, PersonData person);
    }

    // 인터페이스 선언
    OnImageClickListener imageClickListener;

    public void setOnImageClickListener(OnImageClickListener listener) {
        this.imageClickListener = listener;
    }

    public PersonView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_person, this, true);

        textName = findViewById(R.id.text_name);
        textAge = findViewById(R.id.text_age);
        imagePhoto = findViewById(R.id.image_photo);
        imageCheck = findViewById(R.id.image_check);

        if(attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
            String name = ta.getString(R.styleable.PersonView_my_name);
            textName.setText(name);

            int age = ta.getInt(R.styleable.PersonView_my_age, -1);
            textAge.setText(age + "");


            Drawable photo = ta.getDrawable(R.styleable.PersonView_my_photo);
            imagePhoto.setImageDrawable(photo);

            ta.recycle();

            person = new PersonData(name, age, photo);


        }

        imagePhoto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PersonView.this.imageClickListener != null) {
                    // 컨테이너 위젯으로 이벤트 발생
                    // 부모로 이벤트 발생
                    imageClickListener.onImageClick(PersonView.this, person);
                }
            }
        });

        imageCheck.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PersonView.this.imageClickListener != null) {
                    imageClickListener.onImageClick(PersonView.this, person);
                    Drawable dr = getResources().getDrawable(android.R.drawable.checkbox_off_background);
                    if (imageCheck.getDrawable() == dr) {
                        imageCheck.setImageDrawable(getResources().getDrawable(android.R.drawable.checkbox_on_background));
                    }
                    else {
                        imageCheck.setImageDrawable(getResources().getDrawable(android.R.drawable.checkbox_off_background));
                    }
                }
            }
        });
    }
}
