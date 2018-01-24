package com.web.juha.inf;

import java.util.List;

import com.web.juha.model.ModelArticle;

public interface IDaoArticle {
    
    ModelArticle getArticleOne(Integer article_subno, Integer board_id);
    
    List<ModelArticle> getArticleList(Integer board_id);
    
    int increaseHit(Integer article_no);
    
    int increaseGood(Integer article_no);
    
    int increaseBad(Integer article_no);
    
}
