package com.spring61.rest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring61.rest.inf.IBoard;
import com.spring61.rest.model.ModelArticle;
import com.spring61.rest.model.ModelAttachFile;
import com.spring61.rest.model.ModelBoard;
import com.spring61.rest.model.ModelComments;

@Repository("daoboard")
public class DaoBoard implements IBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    

    @Override
    public String getBoardName(ModelBoard board) throws Exception {
        String result = "";
        result = session.selectOne("mapper.mapperBoard.getBoardName", board);
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) throws Exception {
        ModelBoard result = null;
        result = session.selectOne("mapper.mapperBoard.getBoardOne", boardcd);
        return result;
    }

    @Override
    public List<ModelBoard> getBoardList() throws Exception {
        List<ModelBoard> result = null;
        result = session.selectList("mapper.mapperBoard.getBoardList");
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertBoard", board);
        return result;
    }

    @Override
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue) throws Exception {
        int result = -1;
        Map<String, ModelBoard> map = new HashMap<>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        result = session.update("mapper.mapperBoard.updateBoard", map);
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteBoard", board);
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception {
        List<ModelBoard> result = null;
        result = session.selectList("mapper.mapperBoard.getBoardSearch", board);
        return result;
    }

    @Override
    public Integer getBoardTotalRecord(ModelBoard board) throws Exception {
        int result = -1;
        result = session.selectOne("mapper.mapperBoard.getBoardTotalRecord", board);
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end) throws Exception {
        List<ModelBoard> result = null;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", String.valueOf(start));
        map.put("end", String.valueOf(end));
        
        result = session.selectList("mapper.mapperBoard.getBoardPaging", map);
        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> board) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertBoardList", board);
        return result;
    }

    @Override
    public Integer getArticleTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        
        result = session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, String start, String end) throws Exception {
        List<ModelArticle> result = null;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        
        result = session.selectList("mapper.mapperBoard.getArticleList", map);
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertArticle", article);
        return result;
    }

    @Override
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue) throws Exception {
        int result = -1;
        Map<String, ModelArticle> map = new HashMap<>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        result = session.update("mapper.mapperBoard.updateArticle", map);
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteArticle", article);
        return result;
    }

    @Override
    public Integer increaseHit(Integer articleno) throws Exception {
        int result = -1;
        result = session.update("mapper.mapperBoard.increaseHit", articleno);
        return result;
    }

    @Override
    public List<ModelArticle> getNextArticle(String boardcd, String articleno, String searchWord) throws Exception {
        List<ModelArticle> result = null;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("articleno", String.valueOf(articleno));
        map.put("searchWord", searchWord);
        
        result = session.selectList("mapper.mapperBoard.getNextArticle", map);
        return result;
    }

    @Override
    public List<ModelArticle> getPrevArticle(String boardcd, String articleno, String searchWord) throws Exception {
        List<ModelArticle> result = null;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("articleno", String.valueOf(articleno));
        map.put("searchWord", searchWord);
        
        result = session.selectList("mapper.mapperBoard.getPrevArticle", map);
        return result;
    }

    @Override
    public List<ModelAttachFile> getAttachFile(Integer attachFileNo) throws Exception {
        List<ModelAttachFile> result = null;
        result = session.selectList("mapper.mapperBoard.getAttachFile", attachFileNo);
        return result;
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception {
        List<ModelAttachFile> result = null;
        result = session.selectList("mapper.mapperBoard.getAttachFileList", articleno);
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachFile file) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertAttachFile", file);
        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachFile file) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteAttachFile", file);
        return result;
    }

    @Override
    public List<ModelComments> getComment(Integer commentNo) throws Exception {
        List<ModelComments> result = null;
        result = session.selectList("mapper.mapperBoard.getComment", commentNo);
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(Integer articleno) throws Exception {
        List<ModelComments> result = null;
        result = session.selectList("mapper.mapperBoard.getCommentList", articleno);
        return result;
    }

    @Override
    public int insertComment(ModelComments comments) throws Exception {
        int result = -1;
        result = session.insert("mapper.mapperBoard.insertComment", comments);
        return result;
    }

    @Override
    public int updateComment(ModelComments setValue, ModelComments whereValue) throws Exception {
        int result = -1;
        Map<String, ModelComments> map = new HashMap<>();
        map.put("setValue", setValue);
        map.put("whereValue", whereValue);
        
        result = session.update("mapper.mapperBoard.updateComment", map);
        return result;
    }

    @Override
    public int deleteComment(ModelComments comments) throws Exception {
        int result = -1;
        result = session.delete("mapper.mapperBoard.deleteComment", comments);
        return result;
    }
}
