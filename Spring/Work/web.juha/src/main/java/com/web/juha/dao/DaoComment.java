package com.web.juha.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.juha.inf.IDaoComment;
import com.web.juha.model.ModelComment;

@Repository
public class DaoComment implements IDaoComment {
    
    @Autowired
    SqlSession session;
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<ModelComment> getCommentList(Integer article_no) {
        List<ModelComment> result = null;
        result = session.selectList("mapper.mysql.mapperComment.getCommentList", article_no);
        return result;
    }

    @Override
    public int insertComment(String comment_content, Integer article_no, String user_id) {
        Map<String, String> map = new HashMap<>();
        map.put("comment_content", comment_content);
        map.put("article_no", String.valueOf(article_no));
        map.put("user_id", user_id);
        
        int result = -1;
        result = session.insert("mapper.mysql.mapperComment.insertComment", map);
        return result;
    }

    @Override
    public int getCommentLastNo() {
        int result = session.selectOne("mapper.mysql.mapperComment.getCommentLastNo");
        return result;
    }

    @Override
    public ModelComment getCommentOne(Integer comment_no) {
        ModelComment result = session.selectOne("mapper.mysql.mapperComment.getCommentOne", comment_no);
        return result;
    }
}
