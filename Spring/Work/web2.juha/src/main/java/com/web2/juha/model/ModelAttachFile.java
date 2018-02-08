package com.web2.juha.model;

import java.util.Date;

public class ModelAttachFile {
    
    private Integer attachfile_no ; // `attachfile_no` INT(11) NOT NULL,
    private String  filenameorig  ; // `filenameorig` VARCHAR(255) NOT NULL,
    private String  filenametemp  ; // `filenametemp` VARCHAR(255) NOT NULL,
    private Long    filesize      ; // `filesize` INT(255) NOT NULL,
    private String  filetype      ; // `filetype` VARCHAR(50) NOT NULL,
    private Date    regdate       ; // `regdate` DATETIME NOT NULL,
    private Date    updatedate    ; // `updatedate` DATETIME NOT NULL,
    private Integer article_subno ; // `article_subno` INT(11) NOT NULL,
    private String  board_id      ; // `board_id` INT(11) NOT NULL,

    public Integer getAttachfile_no() {
        return attachfile_no;
    }

    public void setAttachfile_no(Integer attachfile_no) {
        this.attachfile_no = attachfile_no;
    }

    public String getFilenameorig() {
        return filenameorig;
    }

    public void setFilenameorig(String filenameorig) {
        this.filenameorig = filenameorig;
    }

    public String getFilenametemp() {
        return filenametemp;
    }

    public void setFilenametemp(String filenametemp) {
        this.filenametemp = filenametemp;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
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

    public ModelAttachFile() {
        super();
    }

    public ModelAttachFile(Integer attachfile_no, String filenameorig, String filenametemp, Long filesize,
            String filetype, Date regdate, Date updatedate, Integer article_subno, String board_id) {
        super();
        this.attachfile_no = attachfile_no;
        this.filenameorig = filenameorig;
        this.filenametemp = filenametemp;
        this.filesize = filesize;
        this.filetype = filetype;
        this.regdate = regdate;
        this.updatedate = updatedate;
        this.article_subno = article_subno;
        this.board_id = board_id;
    }

    @Override
    public String toString() {
        return "ModelAttachFile [attachfile_no=" + attachfile_no + ", filenameorig=" + filenameorig + ", filenametemp="
                + filenametemp + ", filesize=" + filesize + ", filetype=" + filetype + ", regdate=" + regdate
                + ", updatedate=" + updatedate + ", article_subno=" + article_subno + ", board_id=" + board_id + "]";
    }
}
