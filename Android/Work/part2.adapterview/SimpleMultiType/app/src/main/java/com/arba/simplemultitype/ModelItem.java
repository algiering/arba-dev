package com.arba.simplemultitype;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-10.
 */

public class ModelItem {
    // View Type
    private int type;

    // Item1
    private String   title ; // TextView
    private String   desc  ; // TextView

    // Item2
    private String   name  ; // TextView
    private Drawable image ; // ImageView

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModelItem{" +
                "type='" + type + '\'' +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                '}';
    }

    public ModelItem(String title, String desc) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_TEXT;
        this.title = title;
        this.desc = desc;
    }

    public ModelItem(String name, Drawable image) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_IMAGE;
        this.image = image;
        this.name = name;
    }

    public ModelItem() {
    }
}
