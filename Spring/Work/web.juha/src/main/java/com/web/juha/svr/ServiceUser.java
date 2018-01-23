package com.web.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.juha.inf.IDaoUser;
import com.web.juha.inf.IServiceUser;
import com.web.juha.model.ModelUser;

@Service
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoUser dao;

    @Override
    public int Login(ModelUser user) {
        int result = -1;
        try {
            result = dao.Login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
