package springboard.model;

import java.util.Date;

public class ModelArticle {
    
    private Integer articleno = null;
    private String boardcd    = "";
    private String title      = "";
    private String content    = "";
    private String email      = "";
    private Integer hit       = null;
    private Date regdate      = null;
    private Integer countgood = null;
    private Integer countbad  = null;
    private Boolean UseYN     = null;
    private String InsertUID  = "";
    private Date InsertDT     = null;
    private String UpdateUID  = "";
    private Date UpdateDT     = null;

    public Integer getArticleno() {
        return articleno;
    }

    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }

    public String getBoardcd() {
        return boardcd;
    }

    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getCountgood() {
        return countgood;
    }

    public void setCountgood(Integer countgood) {
        this.countgood = countgood;
    }

    public Integer getCountbad() {
        return countbad;
    }

    public void setCountbad(Integer countbad) {
        this.countbad = countbad;
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
        return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd + ", title=" + title + ", content="
                + content + ", email=" + email + ", hit=" + hit + ", regdate=" + regdate + ", countgood=" + countgood
                + ", countbad=" + countbad + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }

    public ModelArticle(Integer articleno, String boardcd, String title, String content, String email, Integer hit,
            Date regdate, Integer countgood, Integer countbad, Boolean useYN, String insertUID, Date insertDT,
            String updateUID, Date updateDT) {
        super();
        this.articleno = articleno;
        this.boardcd = boardcd;
        this.title = title;
        this.content = content;
        this.email = email;
        this.hit = hit;
        this.regdate = regdate;
        this.countgood = countgood;
        this.countbad = countbad;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }

    public ModelArticle() {
        super();
    }
}
