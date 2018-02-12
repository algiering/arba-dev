package com.appprj.juha.inf;

import java.util.List;

import com.appprj.juha.model.ModelArticle;

public interface IDaoArticle {
    
    List<ModelArticle> getArticleList(String board_id);

}
