package com.arba.multitypelistview;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelActor {

    private Drawable imagePhoto;
    private String textName;
    private String textAge;
    private String textDescription;

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
        this.imagePhoto = imagePhoto;
        this.textName = textName;
        this.textAge = textAge;
        this.textDescription = textDescription;
    }

    public ModelActor() {
    }
}
