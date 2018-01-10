package com.arba.multitypelistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arba.multitypelistview.R;
import com.arba.multitypelistview.model.ModelDrama;

/**
 * Created by Administrator on 2018-01-09.
 */

public class DramaView extends RelativeLayout {

    private ImageView image_picture;
    private TextView text_title;
    private TextView text_interval;

    public DramaView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public DramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DramaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_drama,this, true);

        image_picture = rowView.findViewById(R.id.image_picture);
        text_title    = rowView.findViewById(R.id.text_title);
        text_interval = rowView.findViewById(R.id.text_interval);
    }

    private ModelDrama drama;

    public ModelDrama getDrama() {
        return drama;
    }

    public void setDrama(ModelDrama drama) {
        this.drama = drama;

        image_picture.setImageDrawable(drama.getImagePicture());
        text_title.setText(drama.getTextTitle());
        text_interval.setText(drama.getTextInterval());
    }
}
