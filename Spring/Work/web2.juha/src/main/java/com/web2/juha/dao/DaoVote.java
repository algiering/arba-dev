package com.web2.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoVote;
import com.web2.juha.model.ModelVote;

@Repository
public class DaoVote implements IDaoVote {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public int getVoteCount(ModelVote vote) {
        return session.selectOne("mapper.mysql.mapperVote.getVoteCount", vote);
    }

    @Override
    public int insertVote(ModelVote vote) {
        return session.insert("mapper.mysql.mapperVote.insertVote", vote);
    }

    @Override
    public int deleteVote(ModelVote vote) {
        return session.delete("mapper.mysql.mapperVote.deleteVote", vote);
    }
    
}
