package com.web2.juha.model;

public class ModelUser {
    
    private String user_no       ; // `user_no` INT(11) NOT NULL AUTO_INCREMENT,
    private String user_id       ; // `user_id` VARCHAR(20) NOT NULL,
    private String user_password ; // `user_password` VARCHAR(20) NOT NULL,
    private String user_email    ; // `user_email` VARCHAR(20) NOT NULL,
    private String user_use      ; // `user_use` TINYINT(1) NOT NULL,

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_use() {
        return user_use;
    }

    public void setUser_use(String user_use) {
        this.user_use = user_use;
    }

    public ModelUser() {
        super();
    }

    public ModelUser(String user_no, String user_id, String user_password, String user_email, String user_use) {
        super();
        this.user_no = user_no;
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_use = user_use;
    }

    @Override
    public String toString() {
        return "ModelUser [user_no=" + user_no + ", user_id=" + user_id + ", user_password=" + user_password
                + ", user_email=" + user_email + ", user_use=" + user_use + "]";
    }
}
