package com.appprj.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appprj.juha.inf.IDaoUser;
import com.appprj.juha.inf.IServiceUser;

@Service
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoUser dao;

    @Override
    public int getLogin(String user_id, String user_pw) {
        int result = -1;
        try {
            result = dao.getLogin(user_id, user_pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
