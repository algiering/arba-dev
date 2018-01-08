package com.arba.checkablelistview3;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-08.
 */

public class ModelPerson {

    private Drawable imagePhoto = null;
    private String textName = "";
    private String textAge = "";
    private Boolean imageCheck = null;

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

    public Boolean getImageCheck() {
        return imageCheck;
    }

    public void setImageCheck(Boolean imageCheck) {
        this.imageCheck = imageCheck;
    }

    @Override
    public String toString() {
        return "ModelPerson{" +
                "imagePhoto=" + imagePhoto +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                ", imageCheck=" + imageCheck +
                '}';
    }

    public ModelPerson(Drawable imagePhoto, String textName, String textAge, Boolean imageVheck) {
        this.imagePhoto = imagePhoto;
        this.textName = textName;
        this.textAge = textAge;
        this.imageCheck = imageVheck;
    }

    public ModelPerson() {
    }
}
