package com.spring61.rest.inf;

import java.util.List;

import com.spring61.rest.model.ModelArticle;
import com.spring61.rest.model.ModelAttachFile;
import com.spring61.rest.model.ModelBoard;
import com.spring61.rest.model.ModelComments;

public interface IBoard {
    
    String getBoardName(ModelBoard board) throws Exception;
    
    List<ModelBoard> getBoardOne(String boardcd) throws Exception;
    
    List<ModelBoard> getBoardList() throws Exception;
    
    int insertBoard(ModelBoard board) throws Exception;
    
    int updateBoard(ModelBoard setValue, ModelBoard whereValue) throws Exception;
    
    int deleteBoard(ModelBoard board) throws Exception;
    
    List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception;
    
    Integer getBoardTotalRecord(ModelBoard board) throws Exception;
    
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, String start, String end) throws Exception;
    
    int insertBoardList(List<ModelBoard> board) throws Exception;
    
    Integer getArticleTotalRecord(String boardcd, String searchWord) throws Exception;
    
    List<ModelArticle> getArticleList(String boardcd, String searchWord, String start, String end) throws Exception;
    
    int insertArticle(ModelArticle article) throws Exception;
    
    int updateArticle(ModelArticle setValue, ModelArticle whereValue) throws Exception;
    
    int deleteArticle(ModelArticle article) throws Exception;
    
    Integer increaseHit(Integer articleno) throws Exception;
    
    List<ModelArticle> getNextArticle(String boardcd, String articleno, String searchWord) throws Exception;
    
    List<ModelArticle> getPrevArticle(String boardcd, String articleno, String searchWord) throws Exception;
    
    List<ModelAttachFile> getAttachFile(Integer attachFileNo) throws Exception;
    
    List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception;
    
    int insertAttachFile(ModelAttachFile file) throws Exception;
    
    int deleteAttachFile(ModelAttachFile file) throws Exception;
    
    List<ModelComments> getComment(Integer commentNo) throws Exception;
    
    List<ModelComments> getCommentList(Integer articleno) throws Exception;
    
    int insertComment(ModelComments comments) throws Exception;
    
    int updateComment(ModelComments setValue, ModelComments whereValue) throws Exception;
    
    int deleteComment(ModelComments comments) throws Exception;
    
}
