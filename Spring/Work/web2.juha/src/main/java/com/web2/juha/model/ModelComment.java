package com.web2.juha.model;

import java.util.Date;

public class ModelComment {
    
    private Integer comment_no         ; // `comment_no` INT(11) NOT NULL AUTO_INCREMENT,
    private String  comment_content    ; // `comment_content` VARCHAR(3000) NULL DEFAULT NULL,
    private Date    comment_regdate    ; // `comment_regdate` DATETIME NULL DEFAULT NULL,
    private Date    comment_updatedate ; // `comment_updatedate` DATETIME NULL DEFAULT NULL,
    private Integer comment_use        ; // `comment_use` TINYINT(1) NULL DEFAULT '1',
    private Integer article_subno      ; // `article_subno` INT(11) NULL DEFAULT NULL,
    private String  board_id           ; // `board_id` VARCHAR(50) NULL DEFAULT NULL,
    private String  user_id            ; // `user_id` VARCHAR(50) NULL DEFAULT NULL COMMENT 'TODO FOREIGN KEY', PRIMARY KEY (`comment_no`)

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

    public Integer getComment_use() {
        return comment_use;
    }

    public void setComment_use(Integer comment_use) {
        this.comment_use = comment_use;
    }

    public Integer getArticle_subno() {
        return article_subno;
    }

    public void setArticle_subno(Integer article_subno) {
        this.article_subno = article_subno;
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

    public ModelComment() {
        super();
    }

    public ModelComment(Integer comment_no, String comment_content, Date comment_regdate, Date comment_updatedate,
            Integer comment_use, Integer article_subno, String board_id, String user_id) {
        super();
        this.comment_no = comment_no;
        this.comment_content = comment_content;
        this.comment_regdate = comment_regdate;
        this.comment_updatedate = comment_updatedate;
        this.comment_use = comment_use;
        this.article_subno = article_subno;
        this.board_id = board_id;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ModelComment [comment_no=" + comment_no + ", comment_content=" + comment_content + ", comment_regdate="
                + comment_regdate + ", comment_updatedate=" + comment_updatedate + ", comment_use=" + comment_use
                + ", article_subno=" + article_subno + ", board_id=" + board_id + ", user_id=" + user_id + "]";
    }

}
