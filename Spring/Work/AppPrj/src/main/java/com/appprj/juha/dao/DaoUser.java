package com.appprj.juha.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appprj.juha.inf.IDaoUser;
import com.appprj.juha.model.ModelUser;

@Repository
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public int getLogin(String user_id, String user_pw) {
        ModelUser user = new ModelUser();
        user.setUser_id(user_id);
        user.setUser_pw(user_pw);
        return session.selectOne("mapper.mysql.mapperUser.getLogin", user);
    }
    
    
}
