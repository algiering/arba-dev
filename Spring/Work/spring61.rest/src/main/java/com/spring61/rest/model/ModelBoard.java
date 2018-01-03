package com.spring61.rest.model;

import java.sql.Date;

public class ModelBoard {
    
    private String boardcd   = "";
    private String boardnm   = "";
    private Boolean UseYN    = null;
    private String InsertUID = "";
    private Date InsertDT    = null;
    private String UpdateUID = "";
    private Date UpdateDT    = null;

    public String getBoardcd() {
        return boardcd;
    }

    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }

    public String getBoardnm() {
        return boardnm;
    }

    public void setBoardnm(String boardnm) {
        this.boardnm = boardnm;
    }

    public Boolean getUseYN() {
        return UseYN;
    }

    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
    }

    public String getInsertUID() {
        return InsertUID;
    }

    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }

    public Date getInsertDT() {
        return InsertDT;
    }

    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }

    public String getUpdateUID() {
        return UpdateUID;
    }

    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }

    public Date getUpdateDT() {
        return UpdateDT;
    }

    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }

    @Override
    public String toString() {
        return "ModelBoard [boardcd=" + boardcd + ", boardnm=" + boardnm + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }

    public ModelBoard(String boardcd, String boardnm, Boolean useYN, String insertUID, Date insertDT, String updateUID,
            Date updateDT) {
        super();
        this.boardcd = boardcd;
        this.boardnm = boardnm;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }

    public ModelBoard() {
        super();
    }
}