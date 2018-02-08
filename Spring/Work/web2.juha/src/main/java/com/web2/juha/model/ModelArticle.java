package com.web2.juha.model;

import java.util.Date;

public class ModelArticle {
    
    private Integer article_no         ; // `article_no` INT(11) NOT NULL AUTO_INCREMENT,
    private Integer article_subno      ; // `article_subno` INT(11) NOT NULL DEFAULT '0',
    private String  article_title      ; // `article_title` VARCHAR(100) NOT NULL,
    private String  article_content    ; // `article_content` VARCHAR(3000) NULL DEFAULT NULL,
    private Date    article_regdate    ; // `article_regdate` DATETIME NULL DEFAULT NULL,
    private Date    article_updatedate ; // `article_updatedate` DATETIME NULL DEFAULT NULL,
    private Integer article_use        ; // `article_use` TINYINT(1) NOT NULL DEFAULT '1',
    private Integer article_hit        ; // `article_hit` INT(11) NULL DEFAULT '0',
    private Integer article_good       ; // `article_good` INT(11) NULL DEFAULT '0',
    private Integer article_bad        ; // `article_bad` INT(11) NULL DEFAULT '0',
    private String  board_id           ; // `board_id` VARCHAR(100) NOT NULL DEFAULT '-1' COMMENT 'TODO FORIEGN KEY',
    private String  user_id            ; // `user_id` VARCHAR(50) NOT NULL COMMENT 'TODO FORIEGN KEY',
    private Integer comment_count      ;
    private Integer vote_count         ;

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
    }

    public Integer getArticle_subno() {
        return article_subno;
    }

    public void setArticle_subno(Integer article_subno) {
        this.article_subno = article_subno;
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

    public Date getArticle_regdate() {
        return article_regdate;
    }

    public void setArticle_regdate(Date article_regdate) {
        this.article_regdate = article_regdate;
    }

    public Date getArticle_updatedate() {
        return article_updatedate;
    }

    public void setArticle_updatedate(Date article_updatedate) {
        this.article_updatedate = article_updatedate;
    }

    public Integer getArticle_use() {
        return article_use;
    }

    public void setArticle_use(Integer article_use) {
        this.article_use = article_use;
    }

    public Integer getArticle_hit() {
        return article_hit;
    }

    public void setArticle_hit(Integer article_hit) {
        this.article_hit = article_hit;
    }

    public Integer getArticle_good() {
        return article_good;
    }

    public void setArticle_good(Integer article_good) {
        this.article_good = article_good;
    }

    public Integer getArticle_bad() {
        return article_bad;
    }

    public void setArticle_bad(Integer article_bad) {
        this.article_bad = article_bad;
    }

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public ModelArticle() {
        super();
    }

    public ModelArticle(Integer article_no, Integer article_subno, String article_title, String article_content,
            Date article_regdate, Date article_updatedate, Integer article_use, Integer article_hit,
            Integer article_good, Integer article_bad, String board_id, String user_id, Integer comment_count,
            Integer vote_count) {
        super();
        this.article_no = article_no;
        this.article_subno = article_subno;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_regdate = article_regdate;
        this.article_updatedate = article_updatedate;
        this.article_use = article_use;
        this.article_hit = article_hit;
        this.article_good = article_good;
        this.article_bad = article_bad;
        this.board_id = board_id;
        this.user_id = user_id;
        this.comment_count = comment_count;
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "ModelArticle [article_no=" + article_no + ", article_subno=" + article_subno + ", article_title="
                + article_title + ", article_content=" + article_content + ", article_regdate=" + article_regdate
                + ", article_updatedate=" + article_updatedate + ", article_use=" + article_use + ", article_hit="
                + article_hit + ", article_good=" + article_good + ", article_bad=" + article_bad + ", board_id="
                + board_id + ", user_id=" + user_id + ", comment_count=" + comment_count + ", vote_count=" + vote_count
                + "]";
    }
}
