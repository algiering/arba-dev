package springboard.model;

import java.util.Date;

public class ModelAttachFile {
    
    private Integer attachfileno = null;
    private String  filename     = "";
    private String  filetype     = "";
    private Integer filesize     = null;
    private Integer articleno    = null;
    private Boolean UseYN        = null;
    private String  InsertUID    = "";
    private Date    InsertDT     = null;
    private String  UpdateUID    = "";
    private Date    UpdateDT     = null;
    private Byte[]  imageData    = null;

    public Integer getAttachfileno() {
        return attachfileno;
    }

    public void setAttachfileno(Integer attachfileno) {
        this.attachfileno = attachfileno;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getArticleno() {
        return articleno;
    }

    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
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

    public Byte[] getImageData() {
        return imageData;
    }

    public void setImageData(Byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "ModelAttachFile [attachfileno=" + attachfileno + ", filename=" + filename + ", filetype=" + filetype
                + ", filesize=" + filesize + ", articleno=" + articleno + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT
                + ", imageData=" + imageData + "]";
    }

    public ModelAttachFile(Integer attachfileno, String filename, String filetype, Integer filesize, Integer articleno,
            Boolean useYN, String insertUID, Date insertDT, String updateUID, Date updateDT, Byte[] imageData) {
        super();
        this.attachfileno = attachfileno;
        this.filename = filename;
        this.filetype = filetype;
        this.filesize = filesize;
        this.articleno = articleno;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
        this.imageData = imageData;
    }

    public ModelAttachFile() {
        super();
    }
}
