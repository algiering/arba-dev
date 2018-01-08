package com.arba.checkablelistview2;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-05.
 */

public class ModelPerson {

    private String name;
    private int age;
    private Drawable photo;
    private boolean check;
    private boolean check_visible_stmt;

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


    public boolean isCheck_visible_stmt() {
        return check_visible_stmt;
    }

    public void setCheck_visible_stmt(boolean check_visible_stmt) {
        this.check_visible_stmt = check_visible_stmt;
    }

    @Override
    public String toString() {
        return "ModelPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", photo=" + photo +
                ", check=" + check +
                '}';
    }

    public ModelPerson(String name, int age, Drawable photo, boolean check, boolean check_visible_stmt) {
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.check = check;
        this.check_visible_stmt = check_visible_stmt;
    }

    public ModelPerson() {
    }
}
