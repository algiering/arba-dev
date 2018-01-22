package com.web.juha.inf;

import com.web.juha.model.ModelArticle;

public interface IDaoArticle {
    
    ModelArticle getArticleOne(Integer article_subno, Integer board_id);
    
}
