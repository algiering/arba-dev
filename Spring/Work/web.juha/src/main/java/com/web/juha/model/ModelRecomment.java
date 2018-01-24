package com.web.juha.model;

import java.util.Date;

public class ModelRecomment {
    
    private Integer recomment_no         ; // ` INT(11) NOT NULL AUTO_INCREMENT,
    private String  recomment_content    ; // ` VARCHAR(3000) NULL DEFAULT NULL,
    private Date    recomment_regdate    ; // ` DATETIME NULL DEFAULT NULL,
    private Date    recomment_updatedate ; // ` DATETIME NULL DEFAULT NULL,
    private Boolean use                  ; // ` TINYINT(1) NULL DEFAULT NULL,
    private Integer comment_no           ; // ` INT(11) NOT NULL,
    private String  user_id              ; // ` VARCHAR(50) NOT NULL,

    public Integer getRecomment_no() {
        return recomment_no;
    }

    public void setRecomment_no(Integer recomment_no) {
        this.recomment_no = recomment_no;
    }

    public String getRecomment_content() {
        return recomment_content;
    }

    public void setRecomment_content(String recomment_content) {
        this.recomment_content = recomment_content;
    }

    public Date getRecomment_regdate() {
        return recomment_regdate;
    }

    public void setRecomment_regdate(Date recomment_regdate) {
        this.recomment_regdate = recomment_regdate;
    }
    
    public Date getRecomment_updatedate() {
        return recomment_updatedate;
    }

    public void setRecomment_updatedate(Date recomment_updatedate) {
        this.recomment_updatedate = recomment_updatedate;
    }

    public Boolean getUse() {
        return use;
    }

    public void setUse(Boolean use) {
        this.use = use;
    }

    public Integer getComment_no() {
        return comment_no;
    }

    public void setComment_no(Integer comment_no) {
        this.comment_no = comment_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    @Override
    public String toString() {
        return "ModelRecomment [recomment_no=" + recomment_no + ", recomment_content=" + recomment_content
                + ", recomment_regdate=" + recomment_regdate + ", recomment_updatedate=" + recomment_updatedate
                + ", use=" + use + ", comment_no=" + comment_no + ", user_id=" + user_id + "]";
    }
    
    public ModelRecomment(Integer recomment_no, String recomment_content, Date recomment_regdate,
            Date recomment_updatedate, Boolean use, Integer comment_no, String user_id) {
        super();
        this.recomment_no = recomment_no;
        this.recomment_content = recomment_content;
        this.recomment_regdate = recomment_regdate;
        this.recomment_updatedate = recomment_updatedate;
        this.use = use;
        this.comment_no = comment_no;
        this.user_id = user_id;
    }

    public ModelRecomment() {
        super();
    }
}
