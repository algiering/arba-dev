package com.web.juha.model;

import java.util.Date;

public class ModelComment {
    
    private Integer comment_no         ;
    private String  comment_content    ;
    private Date    comment_regdate    ;
    private Date    comment_updatedate ;
    private Boolean comment_use        ;
    private Integer article_no         ;
    private String  user_id            ;

    public Integer getComment_no() {
        return comment_no;
    }

    public void setComment_no(Integer comment_no) {
        this.comment_no = comment_no;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Date getComment_regdate() {
        return comment_regdate;
    }

    public void setComment_regdate(Date comment_regdate) {
        this.comment_regdate = comment_regdate;
    }

    public Date getComment_updatedate() {
        return comment_updatedate;
    }

    public void setComment_updatedate(Date comment_updatedate) {
        this.comment_updatedate = comment_updatedate;
    }

    public Boolean getComment_use() {
        return comment_use;
    }

    public void setComment_use(Boolean comment_use) {
        this.comment_use = comment_use;
    }
    
    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ModelComment [comment_no=" + comment_no + ", comment_content=" + comment_content + ", comment_regdate="
                + comment_regdate + ", comment_updatedate=" + comment_updatedate + ", comment_use=" + comment_use
                + ", article_no=" + article_no + ", user_id=" + user_id + "]";
    }

    public ModelComment(Integer comment_no, String comment_content, Date comment_regdate, Date comment_updatedate,
            Boolean comment_use, Integer article_no , String user_id) {
        super();
        this.comment_no = comment_no;
        this.comment_content = comment_content;
        this.comment_regdate = comment_regdate;
        this.comment_updatedate = comment_updatedate;
        this.comment_use = comment_use;
        this.article_no = article_no;
        this.user_id = user_id;
    }

    public ModelComment() {
        super();
    }
}
