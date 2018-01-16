package com.arba.serialization;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-01-16.
 */

public class ModelSerial implements Serializable {

    private int    idata = 0;
    private String sdata = "";

    public int getIdata() {
        return idata;
    }

    public void setIdata(int idata) {
        this.idata = idata;
    }

    public String getSdata() {
        return sdata;
    }

    public void setSdata(String sdata) {
        this.sdata = sdata;
    }

    @Override
    public String toString() {
        return "ModelSerial{" +
                "idata=" + idata +
                ", sdata='" + sdata + '\'' +
                '}';
    }

    public ModelSerial(int idata, String sdata) {
        this.idata = idata;
        this.sdata = sdata;
    }

    public ModelSerial() {
    }
}
