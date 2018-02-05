package com.web2.juha.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoComment;
import com.web2.juha.model.ModelComment;

@Repository
public class DaoComment implements IDaoComment {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SqlSession session;
    
    @Override
    public List<ModelComment> getCommentList(ModelComment comment) {
        return session.selectList("mapper.mysql.mapperComment.getCommentList", comment);
    }

    @Override
    public int getCommentCount(ModelComment comment) {
        return session.selectOne("mapper.mysql.mapperComment.getCommentCount", comment);
    }
    
}
