package com.arba.checkablelistview3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ViewPerson extends RelativeLayout {

    ImageView image_photo = null;
    TextView  text_name   = null;
    TextView  text_age    = null;
    CheckBox  image_check = null;

    public ViewPerson(@NonNull Context context) {
        super(context);
        init(context, null , 0);
    }

    public ViewPerson(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewPerson(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_person, this, true);

        image_photo = rowView.findViewById(R.id.image_photo);
        text_name   = rowView.findViewById(R.id.text_name);
        text_age    = rowView.findViewById(R.id.text_age);
        image_check = rowView.findViewById(R.id.image_check);

        image_check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setImageCheck(!person.getImageCheck());
                redraw();
            }
        });
    }

    private void redraw() {
        if(person.getImageCheck()) {
            this.setBackgroundColor(Color.GRAY);
        }
        else {
            this.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private ModelPerson person;

    public ModelPerson getPerson() {
        return person;
    }

    public void setPerson(ModelPerson person) {
        this.person = person;

        image_photo.setImageDrawable(person.getImagePhoto());
        text_name  .setText(person.getTextName());
        text_age   .setText(person.getTextAge());
        image_check.setChecked(person.getImageCheck());
        redraw();
    }
}
