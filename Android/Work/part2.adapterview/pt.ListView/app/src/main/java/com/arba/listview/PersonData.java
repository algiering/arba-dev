package com.arba.listview;

/**
 * Created by Administrator on 2017-12-28.
 */

public class PersonData {

    private String name;
    private String comp;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "name='" + name + '\'' +
                ", comp='" + comp + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public PersonData(String name, String comp, int num) {
        this.name = name;
        this.comp = comp;
        this.num = num;
    }

    public PersonData() {
    }
}
