package com.spring67.upload.model;

public class ModelUploadFile {

    private Integer uploadFileNo = null ;
    private String  fileNameOrig = ""   ;
    private String  fileNameTemp = ""   ;
    private Integer fileSize     = null ;
    private String  contentType  = ""   ;

    public Integer getUploadFileNo() {
        return uploadFileNo;
    }

    public void setUploadFileNo(Integer uploadFileNo) {
        this.uploadFileNo = uploadFileNo;
    }

    public String getFileNameOrig() {
        return fileNameOrig;
    }

    public void setFileNameOrig(String fileNameOrig) {
        this.fileNameOrig = fileNameOrig;
    }

    public String getFileNameTemp() {
        return fileNameTemp;
    }

    public void setFileNameTemp(String fileNameTemp) {
        this.fileNameTemp = fileNameTemp;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "ModelUploadFile [uploadFileNo=" + uploadFileNo + ", fileNameOrig=" + fileNameOrig + ", fileNameTemp="
                + fileNameTemp + ", fileSize=" + fileSize + ", contentType=" + contentType + "]";
    }

    public ModelUploadFile(Integer uploadFileNo, String fileNameOrig, String fileNameTemp, Integer fileSize,
            String contentType) {
        super();
        this.uploadFileNo = uploadFileNo;
        this.fileNameOrig = fileNameOrig;
        this.fileNameTemp = fileNameTemp;
        this.fileSize = fileSize;
        this.contentType = contentType;
    }

    public ModelUploadFile() {
        super();
    }
}
