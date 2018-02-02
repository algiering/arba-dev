package com.web2.juha.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web2.juha.inf.IDaoArticle;
import com.web2.juha.model.ModelArticle;

@Repository
public class DaoArticle implements IDaoArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public List<ModelArticle> getArticleList(String board_id) {
        return session.selectList("mapper.mysql.mapperArticle.getArticleList", board_id);
    }

    @Override
    public int getArticleTotalRecord(String board_id, String searchWord, String searchMode) {
        Map<String, String> map = new HashMap<>();
        map.put("board_id", board_id);
        map.put("searchWord", searchWord);
        map.put("searchMode", searchMode);
        return session.selectOne("mapper.mysql.mapperArticle.getArticleTotalRecord", map );
    }

    @Override
    public List<ModelArticle> getArticlePaging(String searchWord, String board_id, Integer start, Integer end) {
        Map<String, String> map = new HashMap<>();
        map.put("searchWord", searchWord);
        map.put("board_id", board_id);
        map.put("start", String.valueOf(start));
        map.put("end", String.valueOf(end));
        return session.selectList("mapper.mysql.mapperArticle.getArticlePaging", map);
    }

    @Override
    public ModelArticle getArticleOne(String board_id, Integer article_subno) {
        ModelArticle article = new ModelArticle();
        article.setBoard_id(board_id);
        article.setArticle_subno(article_subno);
        return session.selectOne("mapper.mysql.mapperArticle.getArticleOne", article);
    }
}
