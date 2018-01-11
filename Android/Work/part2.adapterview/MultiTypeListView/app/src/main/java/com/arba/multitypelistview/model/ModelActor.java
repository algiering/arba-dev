package com.arba.multitypelistview.model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelActor {

    private Drawable imagePhoto      ;
    private String   textName        ;
    private String   textAge         ;
    private String   textDescription ;

    // child data
    List<ModelComment> comments = new ArrayList<>();
    List<ModelDrama>   dramas   = new ArrayList<>();
    List<ModelMovie>   movies   = new ArrayList<>();

    public List<ModelComment> getComments() {
        return comments;
    }

    public List<ModelDrama> getDramas() {
        return dramas;
    }

    public List<ModelMovie> getMovies() {
        return movies;
    }

    public void setComments(List<ModelComment> comments) {
        this.comments = comments;
    }

    public void setDramas(List<ModelDrama> dramas) {
        this.dramas = dramas;
    }

    public void setMovies(List<ModelMovie> movies) {
        this.movies = movies;
    }

    public Drawable getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(Drawable imagePhoto) {
        this.imagePhoto = imagePhoto;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextAge() {
        return textAge;
    }

    public void setTextAge(String textAge) {
        this.textAge = textAge;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Override
    public String toString() {
        return "ModelActor{" +
                "imagePhoto=" + imagePhoto +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                ", textDescription='" + textDescription + '\'' +
                '}';
    }

    public ModelActor(Drawable imagePhoto, String textName, String textAge, String textDescription) {
        this.imagePhoto      = imagePhoto;
        this.textName        = textName;
        this.textAge         = textAge;
        this.textDescription = textDescription;
    }

    public ModelActor() {
    }
}
