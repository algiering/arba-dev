package com.arba.multitypelistview;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelDrama {

    private Drawable imagePicture;
    private String textTitle;
    private String textInterval;

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

    public String getTextInterval() {
        return textInterval;
    }

    public void setTextInterval(String textInterval) {
        this.textInterval = textInterval;
    }

    @Override
    public String toString() {
        return "ModelDrama{" +
                "imagePicture=" + imagePicture +
                ", textTitle='" + textTitle + '\'' +
                ", textInterval='" + textInterval + '\'' +
                '}';
    }

    public ModelDrama(Drawable imagePicture, String textTitle, String textInterval) {
        this.imagePicture = imagePicture;
        this.textTitle = textTitle;
        this.textInterval = textInterval;
    }

    public ModelDrama() {
    }
}
