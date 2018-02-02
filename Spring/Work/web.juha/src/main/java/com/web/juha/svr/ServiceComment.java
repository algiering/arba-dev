package com.web.juha.svr;

import java.util.Date;
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

    @Override
    public int insertComment(String comment_content, Integer article_no, String user_id) {
        int result = -1;
        try {
            result = dao.insertComment(comment_content, article_no, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getCommentLastNo() {
        int result = -1;
        try {
            result =dao.getCommentLastNo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ModelComment getCommentOne(Integer comment_no) {
        ModelComment result = null;
        try {
            result = dao.getCommentOne(comment_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
