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
    public int increaseHit(Integer article_subno, Integer board_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("article_subno", article_subno);
        map.put("board_id", board_id);
        
        int result = session.update("mapper.mysql.mapperArticle.increaseHit", map);
        return result;
    }

    @Override
    public int increaseGood(Integer article_subno, Integer board_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("article_subno", article_subno);
        map.put("board_id", board_id);
        
        int result = session.update("mapper.mysql.mapperArticle.increaseGood", map);
        return result;
    }

    @Override
    public int increaseBad(Integer article_subno, Integer board_id) {
        Map<String, Integer> map = new HashMap<>();
        map.put("article_subno", article_subno);
        map.put("board_id", board_id);
        
        int result = session.update("mapper.mysql.mapperArticle.increaseBad", map);
        return result;
    }

    @Override
    public int insertArticle(String article_title, String article_content, String user_id, Integer board_id) {
        Map<String, String> map = new HashMap<>();
        map.put("article_title", article_title);
        map.put("article_content", article_content);
        map.put("user_id", user_id);
        map.put("board_id", String.valueOf(board_id));
        
        int result = session.insert("mapper.mysql.mapperArticle.insertArticle", map);
        return result;
    }

    @Override
    public int getCountArticleList(Integer board_id, String searchWord) {
        Map<String, String> map = new HashMap<>();
        map.put("board_id", String.valueOf(board_id));
        map.put("searchWord", searchWord);
        
        int result = session.selectOne("mapper.mysql.mapperArticle.getCountArticleList", map);
        return result;
    }

    @Override
    public List<ModelArticle> getArticlePaging(Integer board_id, String searchWord, Integer start, Integer end) {
        List<ModelArticle> result = null;
        
        Map<String, String> map = new HashMap<>();
        map.put("board_id", String.valueOf(board_id));
        map.put("searchWord", searchWord);
        map.put("start", String.valueOf(start));
        map.put("end", String.valueOf(end));
        
        result = session.selectList("mapper.mysql.mapperArticle.getArticlePaging" , map);
        
        return result;
    }

    @Override
    public int deleteArticle(Integer board_id, Integer article_subno) {
        int result = -1;
        
        Map<String, Integer> map = new HashMap<>();
        map.put("board_id", board_id);
        map.put("article_subno", article_subno);
        
        result = session.update("mapper.mysql.mapperArticle.deleteArticle", map);
        
        return result;
    }
    
}
