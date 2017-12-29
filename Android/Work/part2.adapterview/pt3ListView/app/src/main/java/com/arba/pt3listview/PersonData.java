package com.arba.pt3listview;

/**
 * Created by Administrator on 2017-12-29.
 */

public class PersonData {

    String name;
    int number;
    String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", department='" + department + '\'' +
                '}';
    }

    public PersonData(String name, int number, String department) {
        this.name = name;
        this.number = number;
        this.department = department;
    }

    public PersonData() {
    }
}
