package com.arba.paginglistview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-05.
 */

public class ModelItem {

    private String dataItem01;
    private String dataItem02;
    private String dataItem03;
    private Drawable iconItem;

    public String getDataItem01() {
        return dataItem01;
    }

    public void setDataItem01(String dataItem01) {
        this.dataItem01 = dataItem01;
    }

    public String getDataItem02() {
        return dataItem02;
    }

    public void setDataItem02(String dataItem02) {
        this.dataItem02 = dataItem02;
    }

    public String getDataItem03() {
        return dataItem03;
    }

    public void setDataItem03(String dataItem03) {
        this.dataItem03 = dataItem03;
    }

    public Drawable getIconItem() {
        return iconItem;
    }

    public void setIconItem(Drawable iconItem) {
        this.iconItem = iconItem;
    }

    @Override
    public String toString() {
        return "ModelItem{" +
                "dataItem01='" + dataItem01 + '\'' +
                ", dataItem02='" + dataItem02 + '\'' +
                ", dataItem03='" + dataItem03 + '\'' +
                ", iconItem=" + iconItem +
                '}';
    }

    public ModelItem(String dataItem01, String dataItem02, String dataItem03, Drawable iconItem) {
        this.dataItem01 = dataItem01;
        this.dataItem02 = dataItem02;
        this.dataItem03 = dataItem03;
        this.iconItem = iconItem;
    }

    public ModelItem() {
    }
}
