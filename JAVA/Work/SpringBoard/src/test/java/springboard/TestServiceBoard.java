package springboard;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springboard.model.ModelArticle;
import springboard.model.ModelAttachFile;
import springboard.model.ModelBoard;
import springboard.model.ModelComments;
import springboard.svr.ServiceBoard;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    static ServiceBoard service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceboard", ServiceBoard.class);
        
        javax.sql.DataSource dataSource = (DataSource) context.getBean("dataSource");
        org.apache.ibatis.jdbc.ScriptRunner runner = new org.apache.ibatis.jdbc.ScriptRunner(dataSource.getConnection());
        
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
        java.io.Reader br = new java.io.BufferedReader(new java.io.FileReader(sf));
        
        runner.runScript(br);
        runner.closeConnection();
    }

    @Test
    public void a01_testGetBoardName() {
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
    public void a02_testGetBoardOne() {
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
    public void a03_testGetBoardList() {
        List<ModelBoard> result = null;
        
        try {
            result = service.getBoardList();
            assertEquals("qna", result.get(0).getBoardcd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void a04_testInsertBoard() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("zzz");
        board.setBoardnm("zzz");
        
        try {
            result = service.insertBoard(board);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a05_testUpdateBoard() {
        int result = -1;
        ModelBoard setValue = new ModelBoard();
        ModelBoard whereValue = new ModelBoard();
        
        setValue.setBoardnm("xxx");
        setValue.setUseYN(true);
        setValue.setUpdateUID(null);
        setValue.setUpdateDT(null);
        
        whereValue.setBoardcd("qna");
        
        try {
            result = service.updateBoard(setValue, whereValue);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a06_testDeleteBoard() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("data");
        
        try {
            result = service.deleteBoard(board);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a07_testGetBoardSearch() {
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
    public void a08_testGetBoardTotalRecord() {
        int result = -1;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("");
        board.setBoardnm("");
        
        try {
            result = service.getBoardTotalRecord(board);
            assertEquals(3, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a09_testGetBoardPaging() {
        List<ModelBoard> result = null;
        String boardcd = "";
        String searchWord = "";
        String start = "1";
        String end = "10";
        
        try {
            result = service.getBoardPaging(boardcd, searchWord, start, end);
            assertEquals(3, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b01_testInsertBoardList() {
        int result = -1;
        List<ModelBoard> board = new ArrayList<>();
        ModelBoard mboard = new ModelBoard();
        mboard.setBoardcd("ccc");
        mboard.setBoardnm("ccc");
        mboard.setUseYN(true);
        board.add(mboard);
        
        ModelBoard mboard2 = new ModelBoard();
        mboard2.setBoardcd("ddd");
        mboard2.setBoardnm("ddd");
        mboard2.setUseYN(true);
        board.add(mboard2);
        try {
            result = service.insertBoardList(board);
            assertEquals(2, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b02_testGetArticleTotalRecord() {
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
    public void b03_testGetArticleList() {
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
    public void b04_testInsertArticle() {
        int result = -1;
        ModelArticle article = new ModelArticle();
        article.setBoardcd("free");
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
    public void b05_testUpdateArticle() {
        int result = -1;
        ModelArticle setValue = new ModelArticle();
        ModelArticle whereValue = new ModelArticle();
        
        setValue.setTitle("bbb");
        setValue.setContent("bbb");
        setValue.setUseYN(true);
        setValue.setUpdateUID("aaaaa");
        setValue.setUpdateDT(null);
        
        whereValue.setArticleno(201);
        
        try {
            result = service.updateArticle(setValue, whereValue);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b06_testDeleteArticle() {
        int result = -1;
        ModelArticle article = new ModelArticle();
        article.setArticleno(201);
        
        try {
            result = service.deleteArticle(article);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b07_testIncreaseHit() {
        int result = -1;
        int articleno = 193;
        
        try {
            result = service.increaseHit(articleno);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void b08_testGetNextArticle() {
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
    public void b09_testGetPrevArticle() {
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
    public void c01_testGetAttachFile() {
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
    public void c02_testGetAttachFileList() {
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
    public void c03_testInsertAttachFile() {
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
    public void c04_testDeleteAttachFile() {
        int result = -1;
        ModelAttachFile file = new ModelAttachFile();
        file.setAttachfileno(7);
        
        try {
            result = service.deleteAttachFile(file);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void c05_testGetComment() {
        List<ModelComments> result = null;
        int commentNo = 2; 
        try {
            result = service.getComment(commentNo);
            assertSame(2, result.get(0).getCommentno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void c06_testGetCommentList() {
        List<ModelComments> result = null;
        int articleno = 3;
        
        try {
            result = service.getCommentList(articleno);
            assertSame(3, result.get(0).getCommentno());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void c07_testInsertComment() {
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
    public void c08_testUpdateComment() {
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
    public void c09_testDeleteComment() {
        int result = -1;
        ModelComments comments = new ModelComments();
        comments.setCommentno(1);
        
        try {
            result = service.deleteComment(comments);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
