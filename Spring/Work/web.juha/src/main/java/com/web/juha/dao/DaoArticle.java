package com.web.juha.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.juha.inf.IDaoArticle;
import com.web.juha.model.ModelArticle;

@Repository
public class DaoArticle implements IDaoArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public ModelArticle getArticleOne(Integer article_subno, Integer board_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("article_subno",article_subno);
        map.put("board_id", board_id);
        
        ModelArticle result = session.selectOne("mapper.mysql.mapperArticle.getArticleOne", map);
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(Integer board_id) {
        
        List<ModelArticle> result = session.selectList("mapper.mysql.mapperArticle.getArticleList", board_id);
        return result;
    }

    @Override
    public int increaseHit(Integer article_no) {
        
        int result = session.update("mapper.mysql.mapperArticle.increaseHit", article_no);
        return result;
    }

    @Override
    public int increaseGood(Integer article_no) {
        
        int result = session.update("mapper.mysql.mapperArticle.increaseGood", article_no);
        return result;
    }

    @Override
    public int increaseBad(Integer article_no) {
        
        int result = session.update("mapper.mysql.mapperArticle.increaseBad", article_no);
        return result;
    }
    
}
