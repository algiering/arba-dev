package com.web2.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoBoard;
import com.web2.juha.inf.IServiceBoard;
import com.web2.juha.model.ModelBoard;

@Service
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoBoard dao;

    @Override
    public ModelBoard getBoardOne(ModelBoard board) {
        ModelBoard result = null;
        try {
            result = dao.getBoardOne(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
