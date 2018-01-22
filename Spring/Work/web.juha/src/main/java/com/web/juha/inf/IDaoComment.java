package com.web.juha.inf;

import java.util.List;

import com.web.juha.model.ModelComment;

public interface IDaoComment {
    
    List<ModelComment> getCommentList(Integer article_no);

}
