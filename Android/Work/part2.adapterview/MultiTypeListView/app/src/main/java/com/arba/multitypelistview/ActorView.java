package com.arba.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ActorView extends RelativeLayout {

    private ImageView image_photo;
    private TextView text_name, text_age, text_description;


    public ActorView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ActorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ActorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_actor,this, true);

        image_photo      = rowView.findViewById(R.id.image_photo);
        text_name        = rowView.findViewById(R.id.text_name);
        text_age         = rowView.findViewById(R.id.text_age);
        text_description = rowView.findViewById(R.id.text_description);
    }

    private ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        image_photo.setImageDrawable(actor.getImagePhoto());
        text_name.setText(actor.getTextName());
        text_age.setText(actor.getTextAge());
        text_description.setText(actor.getTextDescription());
    }
}
