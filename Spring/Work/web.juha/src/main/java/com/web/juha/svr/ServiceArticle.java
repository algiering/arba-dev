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
    public int increaseHit(Integer article_subno, Integer board_id) {
        int result = -1;
        try {
            result = dao.increaseHit(article_subno, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int increaseGood(Integer article_subno, Integer board_id) {
        int result = -1;
        try {
            result = dao.increaseGood(article_subno, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int increaseBad(Integer article_subno, Integer board_id) {
        int result = -1;
        try {
            result = dao.increaseBad(article_subno, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertArticle(String article_title, String article_content, String user_id, Integer board_id) {
        int result = -1;
        try {
            result = dao.insertArticle(article_title, article_content, user_id, board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getCountArticleList(Integer board_id, String searchWord) {
        int result = -1;
        try {
            result = dao.getCountArticleList(board_id, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelArticle> getArticlePaging(Integer board_id, String searchWord, Integer start, Integer end) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticlePaging(board_id, searchWord, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteArticle(Integer board_id, Integer article_subno) {
        int result = -1;
        try {
            result = dao.deleteArticle(board_id, article_subno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateArticle(Integer board_id, Integer article_subno, String article_title, String article_content) {
        int result = -1;
        try {
            result = dao.updateArticle(board_id, article_subno, article_title, article_content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
