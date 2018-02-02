package com.web.juha.inf;

import java.util.Date;
import java.util.List;

import com.web.juha.model.ModelComment;

public interface IDaoComment {
    
    List<ModelComment> getCommentList(Integer article_no);
    
    int getCommentLastNo();
    
    ModelComment getCommentOne(Integer comment_no);
    
    int insertComment(String comment_content, Integer article_no, String user_id);

}
