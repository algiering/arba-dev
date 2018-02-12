package com.appprj.juha.model;

public class ModelUser {
    
    private String  user_id    ; // `user_id` VARCHAR(50) NOT NULL,
    private String  user_pw    ; // `user_pw` VARCHAR(50) NOT NULL,
    private String  user_email ; // `user_email` VARCHAR(50) NULL DEFAULT NULL,
    private String  user_name  ; // `user_name` VARCHAR(50) NULL DEFAULT NULL,
    private Integer user_use   ; // `user_use` TINYINT(1) NULL DEFAULT '1',

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
        super();
    }

    public ModelUser(String user_id, String user_pw, String user_email, String user_name,
            Integer user_use) {
        super();
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_use = user_use;
    }

    @Override
    public String toString() {
        return "ModelUser [user_id=" + user_id + ", user_pw=" + user_pw + ", user_email="
                + user_email + ", user_name=" + user_name + ", user_use=" + user_use + "]";
    }
}
