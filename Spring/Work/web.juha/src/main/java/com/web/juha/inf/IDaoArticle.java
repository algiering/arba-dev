package com.web.juha.inf;

import java.util.List;

import com.web.juha.model.ModelArticle;

public interface IDaoArticle {
    
    ModelArticle getArticleOne(Integer article_subno, Integer board_id);
    
    List<ModelArticle> getArticleList(Integer board_id);
    
    int increaseHit(Integer article_subno, Integer board_id);
    
    int increaseGood(Integer article_subno, Integer board_id);
    
    int increaseBad(Integer article_subno, Integer board_id);
    
    int insertArticle(String article_title, String article_content, String user_id, Integer board_id);
    
    int getCountArticleList(Integer board_id, String searchWord);
    
    List<ModelArticle> getArticlePaging(Integer board_id, String searchWord, Integer start, Integer end);
    
    int deleteArticle(Integer board_id, Integer article_subno);
    
    int updateArticle(Integer board_id, Integer article_subno, String article_title, String article_content);
}
