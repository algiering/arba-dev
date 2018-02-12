package com.arba.appprj.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018-02-12.
 */

public class ModelUser implements Parcelable {

     private String  user_id    ; // `user_id` VARCHAR(50) NOT NULL,
     private String  user_pw    ; // `user_pw` VARCHAR(50) NOT NULL,
     private String  user_email ; // `user_email` VARCHAR(50) NULL DEFAULT NULL,
     private String  user_name  ; // `user_name` VARCHAR(50) NULL DEFAULT NULL,
     private Integer user_use   ; // `user_use` TINYINT(1) NOT NULL DEFAULT '1',

    protected ModelUser(Parcel in) {
        user_id = in.readString();
        user_pw = in.readString();
        user_email = in.readString();
        user_name = in.readString();
        if (in.readByte() == 0) {
            user_use = null;
        } else {
            user_use = in.readInt();
        }
    }

    public static final Creator<ModelUser> CREATOR = new Creator<ModelUser>() {
        @Override
        public ModelUser createFromParcel(Parcel in) {
            return new ModelUser(in);
        }

        @Override
        public ModelUser[] newArray(int size) {
            return new ModelUser[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_use() {
        return user_use;
    }

    public void setUser_use(Integer user_use) {
        this.user_use = user_use;
    }

    public ModelUser() {
    }

    public ModelUser(String user_id, String user_pw, String user_email, String user_name, Integer user_use) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_use = user_use;
    }

    @Override
    public String toString() {
        return "ModelUser{" +
                "user_id='" + user_id + '\'' +
                ", user_pw='" + user_pw + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_use=" + user_use +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(user_pw);
        dest.writeString(user_email);
        dest.writeString(user_name);
        if (user_use == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(user_use);
        }
    }
}
