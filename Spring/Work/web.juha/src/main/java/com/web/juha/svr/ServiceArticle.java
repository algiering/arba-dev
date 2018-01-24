package com.web.juha.svr;

import java.util.List;

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

    @Override
    public List<ModelArticle> getArticleList(Integer board_id) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int increaseHit(Integer article_no) {
        int result = -1;
        try {
            result = dao.increaseHit(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int increaseGood(Integer article_no) {
        int result = -1;
        try {
            result = dao.increaseGood(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int increaseBad(Integer article_no) {
        int result = -1;
        try {
            result = dao.increaseBad(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
