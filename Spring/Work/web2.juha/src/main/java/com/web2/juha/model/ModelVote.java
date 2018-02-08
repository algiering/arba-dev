package com.web2.juha.model;

public class ModelVote {
    
    private Integer article_no ; // `article_no` INT(11) NULL DEFAULT NULL,
    private String  user_id    ; // `user_id` VARCHAR(50) NULL DEFAULT NULL,
    private Integer vote       ; // `vote` TINYINT(1) NULL DEFAULT NULL COMMENT '0=bad 1=good'

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

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public ModelVote() {
        super();
    }

    public ModelVote(Integer article_no, String user_id, Integer vote) {
        super();
        this.article_no = article_no;
        this.user_id = user_id;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "ModelVote [article_no=" + article_no + ", user_id=" + user_id + ", vote=" + vote + "]";
    }
}
