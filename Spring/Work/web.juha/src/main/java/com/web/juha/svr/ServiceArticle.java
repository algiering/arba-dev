package com.web.juha.svr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.juha.inf.IDaoArticle;
import com.web.juha.inf.IServiceArticle;
import com.web.juha.model.ModelArticle;

@Service
public class ServiceArticle implements IServiceArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoArticle dao;

    @Override
    public ModelArticle getArticleOne(Integer article_subno, Integer board_id) {
        ModelArticle result = null;
        try {
            result = dao.getArticleOne(article_subno, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
