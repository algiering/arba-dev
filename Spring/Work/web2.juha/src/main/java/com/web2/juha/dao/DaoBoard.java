package com.web2.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoBoard;
import com.web2.juha.model.ModelBoard;

@Repository
public class DaoBoard implements IDaoBoard {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelBoard getBoardOne(ModelBoard board) {
        return session.selectOne("mapper.mysql.mapperBoard.getBoardOne", board);
    }
    
    
}
