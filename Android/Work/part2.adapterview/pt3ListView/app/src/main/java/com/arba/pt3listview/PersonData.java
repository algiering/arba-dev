package com.arba.pt3listview;

import android.support.annotation.NonNull;

import org.apache.commons.collections.Predicate;

import java.util.Comparator;

/**
 * Created by Administrator on 2017-12-29.
 */

public class PersonData implements Comparable<PersonData> {

    String name;
    int number;
    String department;
    int ukey;

    public int getUkey() {
        return ukey;
    }

    public void setUkey(int ukey) {
        this.ukey = ukey;
    }

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
                ", ukey=" + ukey +
                '}';
    }

    public PersonData(String name, int number, String department, int ukey) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.ukey = ukey;
    }

    public PersonData() {
    }

    @Override
    public int compareTo(@NonNull PersonData o) {
        return this.number - o.number;
    }

    public static class NameCompare implements Comparator<PersonData> {

        private int mode = 1;

        public NameCompare() {
            mode = 1;
        }

        public NameCompare(boolean desc) {
            if (desc == false) {
                mode = 1;
            } else if (desc == true) {
                mode = -1;
            }
        }

        @Override
        public int compare(PersonData o1, PersonData o2) {
            return o1.getName().compareTo(o2.getName()) * mode;
        }
    }

    public static class NumberCompare implements Comparator<PersonData> {
        private int mode = 1;

        public NumberCompare() {
            mode = 1;
        }

        public NumberCompare(boolean desc) {
            if (desc == false) {
                mode = 1;
            } else if (desc == true) {
                mode = -1;
            }
        }

        @Override
        public int compare(PersonData o1, PersonData o2) {
            if (o1.getNumber() < o2.getNumber()) {
                return -1 * mode;
            } else if (o1.getNumber() > o2.getNumber()) {
                return 1 * mode;
            } else {
                return 0;
            }
        }
    }

    public static class DeptCompare implements Comparator<PersonData> {

        private int mode = 1;

        public DeptCompare() {
            mode = 1;
        }

        public DeptCompare(boolean desc) {
            if (desc == false) {
                mode = 1;
            } else if (desc == true) {
                mode = -1;
            }
        }

        @Override
        public int compare(PersonData o1, PersonData o2) {
            return o1.getName().compareTo(o2.getName()) * mode;
        }
    }

    public static class MyPredicateContains implements Predicate {

        private String fieldName;
        private Object expected;

        @Override
        public boolean evaluate(Object object) {
            if (fieldName.equals("name")) {
                return ((PersonData) object).getName().contains(expected.toString());
            } else if (fieldName.equals("number")) {
                return String.valueOf(((PersonData) object).getNumber()).contains(expected.toString());
            } else if (fieldName.equals("department")) {
                return ((PersonData) object).getDepartment().contains(expected.toString());
            } else {
                return false;
            }
        }

        public MyPredicateContains(String fieldName, Object expected) {
            super();
            this.fieldName = fieldName;
            this.expected = expected;
        }
    }
}
