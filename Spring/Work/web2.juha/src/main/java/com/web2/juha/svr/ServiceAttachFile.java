package com.web2.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoAttachFile;
import com.web2.juha.inf.IServiceAttachFile;
import com.web2.juha.model.ModelAttachFile;

@Service
public class ServiceAttachFile implements IServiceAttachFile {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IDaoAttachFile dao;
    
    @Override
    public int insertFileOne(ModelAttachFile attachFile) {
        int result = -1;
        try {
            result = dao.insertFileOne(attachFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ModelAttachFile getAttachFileOne(ModelAttachFile attachFile) {
        ModelAttachFile result = null;
        try {
            result = dao.getAttachFileOne(attachFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAttachFileOne(ModelAttachFile attachFile) {
        int result = -1;
        try {
            result = dao.deleteAttachFileOne(attachFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
