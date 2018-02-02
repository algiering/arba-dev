package com.testapp.juha.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.testapp.juha.inf.IDaoUser;
import com.testapp.juha.model.ModelUser;

@Repository
public class DaoUser implements IDaoUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mysql.mapperUser.insertUser", user);
    }

    @Override
    public int login(ModelUser user) {
        return session.selectOne("mapper.mysql.mapperUser.login", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mapper.mysql.mapperUser.selectUserList", user);
    }

    @Override
    public int updateUserUse(ModelUser user) {
        return session.update("mapper.mysql.mapperUser.updateUserUse", user);
    }

    @Override
    public int updateUserInfo(ModelUser user) {
        return session.update("mapper.mysql.mapperUser.updateUserInfo", user);
    }
}
