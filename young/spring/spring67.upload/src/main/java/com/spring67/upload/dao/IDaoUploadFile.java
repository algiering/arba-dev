package com.spring67.upload.dao;

import java.util.List;

import com.spring67.upload.model.*;

public interface IDaoUploadFile {
    List<ModelUploadFile> getUploadFile(ModelUploadFile file);
    int insertUploadFile( ModelUploadFile file );
    int insertUploadFileList( java.util.List<ModelUploadFile> files );
    int deleteUploadFile( ModelUploadFile file );  

    int insertPhoto(ModelUploadImage attachfile);    
    ModelUploadImage getImageByte(int attachfileno); 
}
