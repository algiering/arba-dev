package com.arba.multitypelistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arba.multitypelistview.R;
import com.arba.multitypelistview.model.ModelMovie;

/**
 * Created by Administrator on 2018-01-09.
 */

public class MovieView extends RelativeLayout {

    private ImageView image_picture;
    private TextView text_title;
    private TextView text_year;

    public MovieView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MovieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_movie,this, true);

        image_picture = rowView.findViewById(R.id.image_picture);
        text_title    = rowView.findViewById(R.id.text_title);
        text_year     = rowView.findViewById(R.id.text_year);
    }

    private ModelMovie movie;

    public ModelMovie getMovie() {
        return movie;
    }

    public void setMovie(ModelMovie movie) {
        this.movie = movie;

        image_picture.setImageDrawable(movie.getImagePicture());
        text_title.setText(movie.getTextTitle());
        text_year.setText(movie.getTextYear());
    }
}
