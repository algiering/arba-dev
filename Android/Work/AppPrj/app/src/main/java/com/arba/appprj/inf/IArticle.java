package com.arba.appprj.inf;

import com.arba.appprj.model.ModelArticle;

import java.util.List;

/**
 * Created by Administrator on 2018-02-12.
 */

public interface IArticle {

    List<ModelArticle> getArticleList();

    List<ModelArticle> getArticlePaging(String board_id, Integer start, Integer end);

    ModelArticle getArticleOne(String board_id, Integer article_no);

    int insertArticle(String article_title, String article_content, String board_id);

    int deleteArticle(Integer article_no);

    int updateArticle(Integer article_no, String article_title, String article_content);

    int updateIncreseHit(Integer article_no);

}
