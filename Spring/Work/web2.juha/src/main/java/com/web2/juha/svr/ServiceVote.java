package com.web2.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoVote;
import com.web2.juha.inf.IServiceVote;
import com.web2.juha.model.ModelVote;

@Service
public class ServiceVote implements IServiceVote {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoVote dao;

    @Override
    public int getVoteCount(ModelVote vote) {
        int result = -1;
        try {
            result = dao.getVoteCount(vote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertVote(ModelVote vote) {
        int result = -1;
        try {
            result = dao.insertVote(vote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteVote(ModelVote vote) {
        int result = -1;
        result = dao.deleteVote(vote);
        return result;
    }
}
