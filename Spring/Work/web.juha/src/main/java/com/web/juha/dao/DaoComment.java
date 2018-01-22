package com.web.juha.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.juha.inf.IDaoComment;
import com.web.juha.model.ModelComment;

@Repository
public class DaoComment implements IDaoComment {
    
    @Autowired
    SqlSession session;
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<ModelComment> getCommentList(Integer article_no) {
        List<ModelComment> result = null;
        result = session.selectList("mapper.mysql.mapperComment.getCommentList", article_no);
        return result;
    }
}
