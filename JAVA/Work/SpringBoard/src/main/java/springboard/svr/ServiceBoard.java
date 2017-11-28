package springboard.svr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboard.inf.IBoard;
import springboard.inf.IServiceBoard;
import springboard.model.ModelArticle;
import springboard.model.ModelAttachFile;
import springboard.model.ModelBoard;
import springboard.model.ModelComments;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    
    @Autowired
    @Qualifier("daoboard")
    private IBoard dao;

    @Override
    public String getBoardName(ModelBoard board) throws Exception {
        String result = "";
        try {
            result = dao.getBoardName(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBoard> getBoardOne(String boardcd) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBoard> getBoardList() throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) throws Exception {
        int result = -1;
        try {
            result = dao.insertBoard(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateBoard(setValue, whereValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteBoard(ModelBoard board) throws Exception {
        int result = -1;
        try {
            result = dao.deleteBoard(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardSearch(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer getBoardTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        try {
            result = dao.getBoardTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, Integer start, Integer end) throws Exception {
        List<ModelBoard> result = null;
        try {
            result = dao.getBoardPaging(boardcd, searchWord, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertBoardList(ModelBoard board) throws Exception {
        int result = -1;
        try {
            result = dao.insertBoardList(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer getArticleTotalRecord(String boardcd, String searchWord) throws Exception {
        int result = -1;
        try {
            result = dao.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, String start, String end) throws Exception {
        List<ModelArticle> result = null;
        try {
            result = dao.getArticleList(boardcd, searchWord, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) throws Exception {
        int result = -1;
        try {
            result = dao.insertArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateArticle(setValue, whereValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article) throws Exception {
        int result = -1;
        try {
            result = dao.deleteArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer increaseHit(Integer articleno) throws Exception {
        int result = -1;
        try {
            result = dao.increaseHit(articleno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelArticle> getNextArticle(String boardcd, String articleno, String searchWord) throws Exception {
        List<ModelArticle> result =  null;
        try {
            result = dao.getNextArticle(boardcd, articleno, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelArticle> getPrevArticle(String boardcd, String articleno, String searchWord) throws Exception {
        List<ModelArticle> result = null;
        try {
            result = dao.getPrevArticle(boardcd, articleno, searchWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelAttachFile> getAttachFile(Integer attachFileNo) throws Exception {
        List<ModelAttachFile> result = null;
        try {
            result = dao.getAttachFile(attachFileNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(Integer articleno) throws Exception {
        List<ModelAttachFile> result = null;
        try {
            result = dao.getAttachFileList(articleno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachFile file) throws Exception {
        int result = -1;
        try {
            result = dao.insertAttachFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAttachFile(ModelAttachFile file) throws Exception {
        int result = -1;
        try {
            result = dao.deleteAttachFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelComments> getComment(Integer commentNo) throws Exception {
        List<ModelComments> result = null;
        try {
            result = dao.getComment(commentNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(Integer articleno) throws Exception {
        List<ModelComments> result = null;
        try {
            result = dao.getCommentList(articleno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertComment(ModelComments comments) throws Exception {
        int result = -1;
        try {
            result = dao.insertComment(comments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateComment(ModelComments setValue, ModelComments whereValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateComment(setValue, whereValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteComment(ModelComments comments) throws Exception {
        int result = -1;
        try {
            result = dao.deleteComment(comments);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
