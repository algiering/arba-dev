package springboard;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springboard.model.ModelArticle;
import springboard.model.ModelAttachFile;
import springboard.model.ModelBoard;
import springboard.model.ModelComments;
import springboard.svr.ServiceBoard;

public class TestServiceBoard {
    static ServiceBoard service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceboard", ServiceBoard.class);
    }

    @Test
    public void testGetBoardName() {
        String result = "";
        ModelBoard board = new ModelBoard();
        board.setBoardcd("free");
        
        try {
            result = service.getBoardName(board);
            assertEquals("자유게시판", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBoardOne() {
        List<ModelBoard> result = null;
        String boardcd = "free";
        
        try {
            result = service.getBoardOne(boardcd);
            assertEquals("자유게시판", result.get(0).getBoardnm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBoardList() {
        List<ModelBoard> result = null;
        
        try {
            result = service.getBoardList();
            assertEquals("qna", result.get(0).getBoardcd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testInsertBoard() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("aaa");
        board.setBoardnm("aaa");
        
        try {
            result = service.insertBoard(board);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateBoard() {
        int result = -1;
        ModelBoard setValue = new ModelBoard();
        ModelBoard whereValue = new ModelBoard();
        
        setValue.setBoardnm("bbb");
        setValue.setUseYN(null);
        setValue.setUpdateUID(null);
        setValue.setUpdateDT(null);
        
        whereValue.setBoardcd("aaa");
        
        try {
            result = service.updateBoard(setValue, whereValue);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBoard() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("aaa");
        
        try {
            result = service.deleteBoard(board);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBoardSearch() {
        List<ModelBoard> result = null;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("qn");
        
        try {
            result = service.getBoardSearch(board);
            assertEquals("qna", result.get(0).getBoardcd());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBoardTotalRecord() {
        int result = -1;
        String boardcd = "qna";
        String searchWord = "QnA게시판";
        
        try {
            result = service.getBoardTotalRecord(boardcd, searchWord);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBoardPaging() {
        
    }

    @Test
    public void testInsertBoardList() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("aaa");
        board.setBoardnm("aaa");
        board.setUseYN(true);
        
        try {
            result = service.insertBoardList(board);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetArticleTotalRecord() {
        int result = -1;
        String boardcd = "free";
        String searchWord = "111";
        try {
            result = service.getArticleTotalRecord(boardcd, searchWord);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetArticleList() {
       List<ModelArticle> result = null;
       String boardcd = "free";
       String searchWord = null;
       String start = "1";
       String end = "15";
       
       try {
        result = service.getArticleList(boardcd, searchWord, start, end);
        assertEquals(15, result.size());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Test
    public void testInsertArticle() {
        int result = -1;
        ModelArticle article = new ModelArticle();
        article.setBoardcd("aaa");
        article.setTitle("aaa");
        article.setContent("aaa");
        article.setEmail("aaa@aaa.com");
        article.setRegdate(null);
        article.setInsertUID("aaaa");
        article.setInsertDT(null);
        article.setUpdateUID(null);
        article.setUpdateDT(null);
        
        try {
            result = service.insertArticle(article);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateArticle() {
        int result = -1;
        ModelArticle setValue = new ModelArticle();
        ModelArticle whereValue = new ModelArticle();
        
        setValue.setTitle("bbb");
        setValue.setContent("bbb");
        setValue.setUseYN(true);
        setValue.setUpdateUID("aaaaa");
        setValue.setUpdateDT(null);
        
        whereValue.setArticleno(202);
        whereValue.setTitle("aaa");
        
        try {
            result = service.updateArticle(setValue, whereValue);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteArticle() {
        int result = -1;
        ModelArticle article = new ModelArticle();
        article.setArticleno(202);
        article.setBoardcd("aaa");
        
        try {
            result = service.deleteArticle(article);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIncreaseHit() {
        int result = -1;
        int articleno = 201;
        
        try {
            result = service.increaseHit(articleno);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNextArticle() {
        List<ModelArticle> result = null;
        String boardcd = "free";
        String articleno = "24";
        String searchWord = null;
        
        try {
            result = service.getNextArticle(boardcd, articleno, searchWord);
            assertEquals(1, result.size());
            assertEquals(Integer.valueOf("25"), result.get(0).getArticleno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPrevArticle() {
        List<ModelArticle> result = null;
        String boardcd = "free";
        String articleno = "24";
        String searchWord = null;
        
        try {
            result = service.getPrevArticle(boardcd, articleno, searchWord);
            assertEquals(1, result.size());
            assertEquals(Integer.valueOf("23"), result.get(0).getArticleno());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testGetAttachFile() {
        List<ModelAttachFile> result = null;
        int attachFileNo = 1;
        
        try {
            result = service.getAttachFile(attachFileNo);
            assertEquals(Integer.valueOf("10"), result.get(0).getFilesize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttachFileList() {
        List<ModelAttachFile> result = null;
        int articleno = 1;
        
        try {
            result = service.getAttachFileList(articleno);
            assertEquals(7, result.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertAttachFile() {
        int result = -1;
        ModelAttachFile file = new ModelAttachFile();
        file.setFilename("aaa");
        file.setFiletype(null);
        file.setFilesize(null);
        file.setInsertUID("aaaa");
        file.setInsertDT(null);
        file.setUpdateUID(null);
        file.setUpdateDT(null);
        
        try {
            result = service.insertAttachFile(file);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAttachFile() {
        int result = -1;
        ModelAttachFile file = new ModelAttachFile();
        file.setAttachfileno(8);
        
        try {
            result = service.deleteAttachFile(file);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetComment() {
        List<ModelComments> result = null;
        int commentNo = 1; 
        try {
            result = service.getComment(commentNo);
            assertEquals(Integer.valueOf("1"), result.get(0).getArticleno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCommentList() {
        List<ModelComments> result = null;
        int articleno = 1;
        
        try {
            result = service.getCommentList(articleno);
            assertEquals(Integer.valueOf("1"), result.get(0).getArticleno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertComment() {
        int result = -1;
        ModelComments comments = new ModelComments();
        comments.setArticleno(2);
        comments.setEmail("aaa@aaa.com");
        comments.setMemo("aaa");
        comments.setRegdate(null);
        comments.setInsertUID("aaaa");
        comments.setUpdateUID(null);
        comments.setUpdateDT(null);
        
        try {
            result = service.insertComment(comments);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateComment() {
        int result = -1;
        ModelComments setValue = new ModelComments();
        ModelComments whereValue = new ModelComments();
        
        setValue.setMemo("changed memo");
        setValue.setRegdate(null);
        setValue.setUseYN(true);
        
        whereValue.setCommentno(3);
        
        try {
            result = service.updateComment(setValue, whereValue);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteComment() {
        int result = -1;
        ModelComments comments = new ModelComments();
        comments.setCommentno(4);
        
        try {
            result = service.deleteComment(comments);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
