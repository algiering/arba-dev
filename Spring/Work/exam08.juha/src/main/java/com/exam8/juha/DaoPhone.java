package com.exam8.juha;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ModelPhone result = session.selectOne("mapper.mysql.mapperPhone.getPhoneOne", name);
        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList(int start, int end) {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        
        List<ModelPhone> result = session.selectList("mapper.mysql.mapperPhone.getPhoneList", map);
        return result;
    }

    @Override
    public int getPhoneTotalRecord() {
        int result = session.selectOne("mapper.mysql.mapperPhone.getPhoneTotalRecord");
        return result;
    }
    
    @Override
    public int insertPhone(ModelPhone phone) {
        int result = session.insert("mapper.mysql.mapperPhone.insertPhone", phone);
        return result;
    }

}
