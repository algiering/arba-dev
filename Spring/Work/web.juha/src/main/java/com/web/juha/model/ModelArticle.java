package com.web.juha.model;

import java.util.Date;

public class ModelArticle {
    private Integer article_no         ;
    private Integer article_subno      ;
    private String  article_title      ;
    private String  article_content    ;
    private Date    article_regdate    ;
    private Date    article_updatedate ;
    private Boolean article_use        ;
    private Integer hit                ;
    private Integer good               ;
    private Integer bad                ;
    private Integer board_id           ;
    private String  user_id            ;

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

    public Boolean getArticle_use() {
        return article_use;
    }

    public void setArticle_use(Boolean article_use) {
        this.article_use = article_use;
    }

    public Integer getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Integer board_id) {
        this.board_id = board_id;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    @Override
    public String toString() {
        return "ModelArticle [article_no=" + article_no + ", article_subno=" + article_subno + ", article_title="
                + article_title + ", article_content=" + article_content + ", article_regdate=" + article_regdate
                + ", article_updatedate=" + article_updatedate + ", article_use=" + article_use + ", hit=" + hit
                + ", good=" + good + ", bad=" + bad + ", board_id=" + board_id + ", user_id=" + user_id + "]";
    }

    public ModelArticle(Integer article_no, Integer article_subno, String article_title, String article_content,
            Date article_regdate, Date article_updatedate , Boolean article_use, Integer hit,
            Integer good, Integer bad, Integer board_id, String user_id) {
        super();
        this.article_no = article_no;
        this.article_subno = article_subno;
        this.article_title = article_title;
        this.article_content = article_content;
        this.article_regdate = article_regdate;
        this.article_updatedate = article_updatedate;
        this.article_use = article_use;
        this.hit = hit;
        this.good = good;
        this.bad = bad;
        this.board_id = board_id;
        this.user_id = user_id;
    }

    public ModelArticle() {
        super();
    }
}
