package com.arba.st2personview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017-12-26.
 */

class PersonData {
    private String name;
    private int age;
    private Drawable photo;

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
        return "PersonData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", photo=" + photo +
                ", check_visible_stmp" + check_visible_stmt +
                '}';
    }

    public PersonData() {
    }

    public PersonData(String name, int age, Drawable photo, boolean check_visible_stmt) {
        this.name = name;
        this.age = age;
        this.photo = photo;
    }
}
