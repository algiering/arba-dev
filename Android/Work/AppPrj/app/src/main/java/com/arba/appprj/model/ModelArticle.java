package com.arba.appprj.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Administrator on 2018-02-12.
 */

public class ModelArticle implements Parcelable {

    private Integer article_no      ; //`article_no` INT(11) NOT NULL AUTO_INCREMENT,
    private Integer article_subno   ;
    private String  article_title   ; //`article_title` VARCHAR(200) NULL DEFAULT NULL,
    private String  article_content ; //`article_content` VARCHAR(3000) NULL DEFAULT NULL,
    private Integer article_hit     ; //`article_hit` INT(11) NOT NULL DEFAULT '0',
    private Date    article_regdate ; //`article_regdate` DATETIME NULL DEFAULT NULL,
    private Date    article_update  ; //`article_update` DATETIME NULL DEFAULT NULL,
    private String  board_id        ; //`board_id` VARCHAR(50) NULL DEFAULT NULL,
    private Integer comment_count   ;

    protected ModelArticle(Parcel in) {
        if (in.readByte() == 0) {
            article_no = null;
        } else {
            article_no = in.readInt();
        }
        if (in.readByte() == 0) {
            article_subno = null;
        } else {
            article_subno = in.readInt();
        }
        article_title = in.readString();
        article_content = in.readString();
        if (in.readByte() == 0) {
            article_hit = null;
        } else {
            article_hit = in.readInt();
        }
        board_id = in.readString();
        if (in.readByte() == 0) {
            comment_count = null;
        } else {
            comment_count = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (article_no == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(article_no);
        }
        if (article_subno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(article_subno);
        }
        dest.writeString(article_title);
        dest.writeString(article_content);
        if (article_hit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(article_hit);
        }
        dest.writeString(board_id);
        if (comment_count == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(comment_count);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelArticle> CREATOR = new Creator<ModelArticle>() {
        @Override
        public ModelArticle createFromParcel(Parcel in) {
            return new ModelArticle(in);
        }

        @Override
        public ModelArticle[] newArray(int size) {
            return new ModelArticle[size];
        }
    };

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

    public Integer getArticle_no() {
        return article_no;
    }

    public void setArticle_no(Integer article_no) {
        this.article_no = article_no;
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
    }

    public ModelArticle(Integer article_no, Integer article_subno, String article_title, String article_content, Integer article_hit, Date article_regdate, Date article_update, String board_id, Integer comment_count) {
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
        return "ModelArticle{" +
                "article_no=" + article_no +
                ", article_subno=" + article_subno +
                ", article_title='" + article_title + '\'' +
                ", article_content='" + article_content + '\'' +
                ", article_hit=" + article_hit +
                ", article_regdate=" + article_regdate +
                ", article_update=" + article_update +
                ", board_id='" + board_id + '\'' +
                ", comment_count=" + comment_count +
                '}';
    }
}
