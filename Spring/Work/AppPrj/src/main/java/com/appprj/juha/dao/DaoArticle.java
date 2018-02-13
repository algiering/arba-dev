package com.appprj.juha.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.appprj.juha.inf.IDaoArticle;
import com.appprj.juha.model.ModelArticle;

@Repository
public class DaoArticle implements IDaoArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;

    @Override
    public List<ModelArticle> getArticleList(String board_id) {
        ModelArticle article = new ModelArticle();
        article.setBoard_id(board_id);
        return session.selectList("mapper.mysql.mapperArticle.getArticleList", article);
    }

    @Override
    public List<ModelArticle> getArticlePaging(String board_id, Integer start, Integer end) {
        Map<String, String> map = new HashMap<>();
        map.put("board_id", board_id);
        map.put("start", String.valueOf(start));
        map.put("end", String.valueOf(end));
        return session.selectList("mapper.mysql.mapperArticle.getArticlePaging", map);
    }

    @Override
    public ModelArticle getArticleOne(String board_id, Integer article_no) {
        ModelArticle article = new ModelArticle();
        article.setBoard_id(board_id);
        article.setArticle_no(article_no);
        return session.selectOne("mapper.mysql.mapperArticle.getArticleOne", article);
    }

    @Override
    public int insertArticle(String article_title, String article_content, String board_id) {
        ModelArticle article = new ModelArticle();
        article.setArticle_title(article_title);
        article.setArticle_content(article_content);
        article.setBoard_id(board_id);
        return session.insert("mapper.mysql.mapperArticle.insertArticle", article);
    }

    @Override
    public int deleteArticle(Integer article_no) {
        ModelArticle article = new ModelArticle();
        article.setArticle_no(article_no);
        return session.delete("mapper.mysql.mapperArticle.deleteArticle", article);
    }

    @Override
    public int updateArticle(Integer article_no, String article_title, String article_content) {
        ModelArticle article = new ModelArticle();
        article.setArticle_no(article_no);
        article.setArticle_title(article_title);
        article.setArticle_content(article_content);
        return session.update("mapper.mysql.mapperArticle.updateArticle", article);
    }

    @Override
    public int updateIncreseHit(Integer article_no) {
        ModelArticle article = new ModelArticle();
        article.setArticle_no(article_no);
        return session.update("mapper.mysql.mapperArticle.updateIncreseHit", article);
    }
}
