package com.web.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.juha.inf.IDaoComment;
import com.web.juha.inf.IServiceComment;
import com.web.juha.model.ModelComment;

@Service
public class ServiceComment implements IServiceComment {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoComment dao;

    @Override
    public List<ModelComment> getCommentList(Integer article_no) {
        List<ModelComment> result = null;
        
        try {
            result = dao.getCommentList(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
