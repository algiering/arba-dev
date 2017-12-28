package com.example.algieba.pt2listview;

/**
 * Created by Algieba on 2017-12-28.
 */

public class PersonData {

    private String name;
    private String num;
    private String depart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", depart='" + depart + '\'' +
                '}';
    }

    public PersonData(String name, String num, String depart) {
        this.name = name;
        this.num = num;
        this.depart = depart;
    }

    public PersonData() {
    }
}
