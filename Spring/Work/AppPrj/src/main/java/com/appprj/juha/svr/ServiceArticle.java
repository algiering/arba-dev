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

    @Override
    public List<ModelArticle> getArticlePaging(String board_id, Integer start, Integer end) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticlePaging(board_id, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ModelArticle getArticleOne(String board_id, Integer article_no) {
        ModelArticle result = null;
        try {
            result = dao.getArticleOne(board_id, article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertArticle(String article_title, String article_content, String board_id) {
        int result = -1;
        try {
            result = dao.insertArticle(article_title, article_content, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteArticle(Integer article_no) {
        int result = -1;
        try {
            result = dao.deleteArticle(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateArticle(Integer article_no, String article_title, String article_content) {
        int result = -1;
        try {
            result = dao.updateArticle(article_no, article_title, article_content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateIncreseHit(Integer article_no) {
        int result = -1;
        try {
            result = dao.updateIncreseHit(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
