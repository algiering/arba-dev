package com.exam8.juha;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPhone implements IDaoPhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = session.selectOne("mapperPhone.getPhoneOne", name);
        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = session.selectList("mapperPhone.getPhoneList");
        return result;
    }

    @Override
    public int insertPhone(ModelPhone phone) {
        int result = session.insert("mapperPhone.insertPhone", phone);
        return result;
    }
}
