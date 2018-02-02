package com.web2.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoUser;
import com.web2.juha.inf.IServiceUser;
import com.web2.juha.model.ModelUser;

@Service
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoUser dao;

    @Override
    public ModelUser getUserOne(ModelUser user) {
        ModelUser result = null;
        try {
            result = dao.getUserOne(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
