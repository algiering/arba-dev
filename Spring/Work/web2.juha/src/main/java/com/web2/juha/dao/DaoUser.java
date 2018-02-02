package com.web2.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoUser;
import com.web2.juha.model.ModelUser;

@Repository
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelUser getUserOne(ModelUser user) {
        return session.selectOne("mapper.mysql.mapperUser.getUserOne", user);
    }
}
