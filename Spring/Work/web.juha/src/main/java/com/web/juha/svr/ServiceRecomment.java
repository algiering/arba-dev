package com.web.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.juha.inf.IDaoRecomment;
import com.web.juha.inf.IServiceRecomment;
import com.web.juha.model.ModelRecomment;

@Service
public class ServiceRecomment implements IServiceRecomment {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IDaoRecomment dao;
    
    @Override
    public List<ModelRecomment> getRecommentList(Integer comment_no) {
        List<ModelRecomment> result = null;
        
        try {
            result = dao.getRecommentList(comment_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
