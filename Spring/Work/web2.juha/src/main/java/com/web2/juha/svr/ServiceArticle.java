package com.web2.juha.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2.juha.inf.IDaoArticle;
import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.model.ModelArticle;

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
    public int getArticleTotalRecord(String board_id, String searchWord, String searchMode) {
        int result = -1;
        try {
            result = dao.getArticleTotalRecord(board_id, searchWord, searchMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelArticle> getArticlePaging(String searchWord, String board_id, Integer start, Integer end) {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticlePaging(searchWord, board_id, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ModelArticle getArticleOne(ModelArticle article) {
        ModelArticle result = null;
        try {
            result = dao.getArticleOne(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertArticleOne(ModelArticle article) {
        int result = -1;
        try {
            result = dao.insertArticleOne(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
