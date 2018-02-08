package com.web2.juha.inf;

import com.web2.juha.model.ModelAttachFile;

public interface IDaoAttachFile {

    int insertFileOne(ModelAttachFile attachFile);
    
    ModelAttachFile getAttachFileOne(ModelAttachFile attachFile);
    
    int deleteAttachFileOne(ModelAttachFile attachFile);
    
}
