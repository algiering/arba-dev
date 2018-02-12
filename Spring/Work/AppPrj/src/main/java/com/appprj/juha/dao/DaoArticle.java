package com.appprj.juha.dao;

import java.util.List;

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
}
