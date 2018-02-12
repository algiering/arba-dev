package com.appprj.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appprj.juha.inf.IDaoArticle;
import com.appprj.juha.inf.IServiceArticle;
import com.appprj.juha.model.ModelArticle;

@Service
public class ServiceArticle implements IServiceArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoArticle dao;

    @Override
    public List<ModelArticle> getArticleList(String board_id) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
