package com.web.juha.inf;

import java.util.List;

import com.web.juha.model.ModelRecomment;

public interface IDaoRecomment {
    
    List<ModelRecomment> getRecommentList(Integer comment_no);

}
