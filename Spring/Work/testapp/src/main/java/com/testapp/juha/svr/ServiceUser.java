package com.testapp.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testapp.juha.inf.IDaoUser;
import com.testapp.juha.inf.IServiceUser;
import com.testapp.juha.model.ModelUser;

@Service
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoUser dao;

    @Override
    public int insertUser(ModelUser user) {
        int result = -1;
        try {
            result = dao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int login(ModelUser user) {
        int result = -1;
        try {
            result = dao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        List<ModelUser> result = null;
        try {
            result = dao.selectUserList(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUserUse(ModelUser user) {
        int result = -1;
        try {
            result = dao.updateUserUse(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUserInfo(ModelUser user) {
        int result = -1;
        try {
            result = dao.updateUserInfo(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
