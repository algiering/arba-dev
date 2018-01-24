package com.web.juha.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.juha.inf.IDaoRecomment;
import com.web.juha.model.ModelRecomment;

@Repository
public class DaoRecomment implements IDaoRecomment {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public List<ModelRecomment> getRecommentList(Integer comment_no) {
        
        List<ModelRecomment> result = session.selectList("mapper.mysql.mapperRecomment.getRecommentList", comment_no);
        
        return result;
    }
    
    
}
