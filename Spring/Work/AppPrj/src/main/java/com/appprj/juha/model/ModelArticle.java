package com.appprj.juha.model;

import java.util.Date;

public class ModelArticle {
    
    private Integer article_no      ;  // `article_no` INT(11) NOT NULL AUTO_INCREMENT,
    private Integer article_subno   ;
    private String  article_title   ;  // `article_title` VARCHAR(200) NULL DEFAULT NULL,
    private String  article_content ;  // `article_content` VARCHAR(3000) NULL DEFAULT NULL,
    private Integer article_hit     ;  // `article_hit` INT(11) NOT NULL DEFAULT '0',
    private Date    article_regdate ;  // `article_regdate` DATETIME NULL DEFAULT NULL,
    private Date    article_update  ;  // `article_update` DATETIME NULL DEFAULT NULL,
    private String  board_id        ;  // `board_id` VARCHAR(50) NULL DEFAULT NULL,
    private Integer comment_count   ;

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getArticle_hit() {
        return article_hit;
    }

    public void setArticle_hit(Integer article_hit) {
        this.article_hit = article_hit;
    }

    public Date getArticle_regdate() {
        return article_regdate;
    }

    public void setArticle_regdate(Date article_regdate) {
        this.article_regdate = article_regdate;
    }

    public Date getArticle_update() {
        return article_update;
    }

    public void setArticle_update(Date article_update) {
        this.article_update = article_update;
    }

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }
    
    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getArticle_subno() {
        return article_subno;
    }

    public void setArticle_subno(Integer article_subno) {
        this.article_subno = article_subno;
    }

    public ModelArticle() {
        super();
    }

    public ModelArticle(Integer article_no, Integer article_subno, String article_title, String article_content,
            Integer article_hit, Date article_regdate, Date article_update, String board_id, Integer comment_count) {
        super();
        this.article_no = article_no;
        this.article_subno = article_subno;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_hit = article_hit;
        this.article_regdate = article_regdate;
        this.article_update = article_update;
        this.board_id = board_id;
        this.comment_count = comment_count;
    }

    @Override
    public String toString() {
        return "ModelArticle [article_no=" + article_no + ", article_subno=" + article_subno + ", article_title="
                + article_title + ", article_content=" + article_content + ", article_hit=" + article_hit
                + ", article_regdate=" + article_regdate + ", article_update=" + article_update + ", board_id="
                + board_id + ", comment_count=" + comment_count + "]";
    }
    
}
