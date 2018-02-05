package com.web2.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoComment;
import com.web2.juha.inf.IServiceComment;
import com.web2.juha.model.ModelComment;

@Service
public class ServiceComment implements IServiceComment {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoComment dao;

    @Override
    public List<ModelComment> getCommentList(ModelComment comment) {
        List<ModelComment> result = null;
        try {
            result = dao.getCommentList(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getCommentCount(ModelComment comment) {
        int result = -1;
        try {
            result = dao.getCommentCount(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
