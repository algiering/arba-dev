package com.arba.checkablecustomlistview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-04.
 */

public class ModelDog {

    private String name;
    private int age;
    private Drawable photo;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ModelDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", photo=" + photo +
                '}';
    }

    public ModelDog(String name, int age, Drawable photo, boolean check) {
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.check = check;
    }

    public ModelDog() {
    }
}
