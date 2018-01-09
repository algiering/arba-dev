package com.arba.multitypelistview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelMovie {

    private Drawable imagePicture;
    private String textTitle;
    private String textYear;

    public Drawable getImagePicture() {
        return imagePicture;
    }

    public void setImagePicture(Drawable imagePicture) {
        this.imagePicture = imagePicture;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextYear() {
        return textYear;
    }

    public void setTextYear(String textYear) {
        this.textYear = textYear;
    }

    @Override
    public String toString() {
        return "ModelMovie{" +
                "imagePicture=" + imagePicture +
                ", textTitle='" + textTitle + '\'' +
                ", textYear='" + textYear + '\'' +
                '}';
    }

    public ModelMovie(Drawable imagePicture, String textTitle, String textYear) {
        this.imagePicture = imagePicture;
        this.textTitle = textTitle;
        this.textYear = textYear;
    }

    public ModelMovie() {
    }
}
