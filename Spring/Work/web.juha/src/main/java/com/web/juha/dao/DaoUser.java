package com.web.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.juha.inf.IDaoUser;
import com.web.juha.model.ModelUser;

@Repository
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public int Login(ModelUser user) {
        int result = -1;
        result = session.selectOne("mapper.mysql.mapperUser.Login", user);
        return result;
    }
}
