package com.spring61.rest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring61.rest.inf.IUser;
import com.spring61.rest.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IUser {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public int insertUser(ModelUser user) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperUser.insertUser", user);
        return result;
    }

    @Override
    public ModelUser login(String userid, String passwd) throws Exception {
        ModelUser result = null;
        ModelUser user = new ModelUser();
        user.setUserid(userid);
        user.setPasswd(passwd);
        result = session.selectOne("mapper.mapperUser.login", user);
        return result;
    }

    @Override
    public int logout(String userid) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperUser.logout");
        return result;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) throws Exception {
        int result = -1;
        Map<String, ModelUser> map = new HashMap<>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);        
        result = session.update("mapper.mapperUser.updateUserInfo", map);
        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) throws Exception {
        int result = -1;
        Map<String, String> map = new HashMap<>();
        map.put("userid", userid);
        map.put("currentPasswd", currentPasswd);
        map.put("newPasswd", newPasswd);
        
        result = session.update("mapper.mapperUser.updatePasswd", map);
        return result;
    }

    @Override
    public int deleteUser(ModelUser user) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperUser.deleteUser", user);
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) throws Exception {
        ModelUser result = null;
        result = session.selectOne("mapper.mapperUser.selectUserOne", user);
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        result = session.selectList("mapper.mapperUser.selectUserList", user);
        return result;
    }

    @Override
    public int checkuserid(String userid) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperUser.checkuserid", userid);
        return result;
    }
}
