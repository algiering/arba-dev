package com.web2.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoAttachFile;
import com.web2.juha.model.ModelAttachFile;

@Repository
public class DaoAttachFile implements IDaoAttachFile {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SqlSession session;
    
    @Override
    public int insertFileOne(ModelAttachFile attachFile) {
        return session.insert("mapper.mysql.mapperAttachFile.insertFileOne", attachFile);
    }

    @Override
    public ModelAttachFile getAttachFileOne(ModelAttachFile attachFile) {
        return session.selectOne("mapper.mysql.mapperAttachFile.getAttachFileOne", attachFile);
    }

    @Override
    public int deleteAttachFileOne(ModelAttachFile attachFile) {
        return session.delete("mapper.mysql.mapperAttachFile.deleteAttachFileOne", attachFile);
    }
}
