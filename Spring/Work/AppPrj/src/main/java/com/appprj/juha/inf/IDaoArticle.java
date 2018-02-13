package com.appprj.juha.inf;

import java.util.List;

import com.appprj.juha.model.ModelArticle;

public interface IDaoArticle {
    
    List<ModelArticle> getArticleList(String board_id);
    
    List<ModelArticle> getArticlePaging(String board_id, Integer start, Integer end);

    ModelArticle getArticleOne(String board_id, Integer article_no);
    
    int insertArticle(String article_title, String article_content, String board_id);

    int deleteArticle(Integer article_no);
    
    int updateArticle(Integer article_no, String article_title, String article_content);
    
    int updateIncreseHit(Integer article_no);
}
