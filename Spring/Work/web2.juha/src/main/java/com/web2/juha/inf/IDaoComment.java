package com.web2.juha.inf;

import java.util.List;

import com.web2.juha.model.ModelComment;

public interface IDaoComment {
    
    List<ModelComment> getCommentList(ModelComment comment);
    
    int getCommentCount(ModelComment comment);
    
    int insertCommentOne(ModelComment comment);
    
    int updateCommentOne(ModelComment comment);
    
    int updateDeleteComment(ModelComment comment);
    
}
