package com.web2.juha.inf;

import java.util.List;

import com.web2.juha.model.ModelArticle;

public interface IDaoArticle {
    
    List<ModelArticle> getArticleList(String board_id);
    
    int getArticleTotalRecord(String board_id, String searchWord, String searchMode);
    
    List<ModelArticle> getArticlePaging(String searchWord, String board_id, Integer start, Integer end);

    ModelArticle getArticleOne(ModelArticle article);
    
    int insertArticleOne(ModelArticle article);
}
