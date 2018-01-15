package com.spring81.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring81.bbs.inf.IUser;
import com.spring81.bbs.model.ModelUser;

@Repository("daouser")
public class DaoUser implements IUser {

    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;    
    
    @Override
    public int insertUser(ModelUser user) {
        return session.insert("mapper.mapperUser.insertUser", user);   
    }

    @Override
    public ModelUser login(String userid, String passwd) {
        Map<String, Object> map = new HashMap<>(); 
        map.put("userid"  ,    userid);
        map.put("passwd",      passwd);
        return session.selectOne("mapper.mapperUser.login", map);
    }

    @Override
    public int logout(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        
        Map<String, ModelUser> map = new HashMap<String, ModelUser>(); 
        map.put("setValue"  ,      setValue);
        map.put("whereValue",      whereValue);

        return session.update("mapper.mapperUser.updateUserInfo", map);
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("userid"       , userid       );
        map.put("currentPasswd", currentPasswd); 
        map.put("newPasswd"    , newPasswd    );
        return session.update("mapper.mapperUser.updatePasswd", map);
    }

    @Override
    public int updateRetire(ModelUser user) {
        return session.delete("mapper.mapperUser.updateRetire", user);
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        return session.selectOne("mapper.mapperUser.selectUserOne", user);
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        return session.selectList("mapper.mapperUser.selectUserList", user);
    }

    @Override
    public int checkuserid(String userid) {
        return session.selectOne("mapper.mapperUser.checkuserid", userid);
    }
    
}
