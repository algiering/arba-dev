package com.exam8.juha;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.XmlWebApplicationContext;

@Service
public class ServicePhone implements IServicePhone {
    
    @Autowired
    IDaoPhone dao;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = null;
        try {
            result = dao.getPhoneOne(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList(int start, int end) {
        List<ModelPhone> result = null;
        try {
            result = dao.getPhoneList(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public int getPhoneTotalRecord() {
        int result = -1;
        try {
            result = dao.getPhoneTotalRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        int result = -1;
        try {
            result = dao.insertPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    
}
