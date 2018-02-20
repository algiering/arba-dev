package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceBook {
    private static ServiceBook svr = null; 
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceBook();
    }
    
    @Test
    public void test01_GetCount() throws SQLException {
        ModelBook model = new ModelBook();
        int result = svr.getCount(model);
        assertEquals(4, result);
    }
    
    @Test
    public void test02_GetMaxBookid() throws SQLException {
        int result = svr.getMaxBookid();
        assertEquals(4, result);
    }
    
    @Test
    public void test03_SelectAll() throws SQLException {
        java.sql.ResultSet rs = svr.selectAll();
        
        rs.next(); // ResultSet에서 다음 row로 커서 이동.
        
        int bookid  = rs.getInt("bookid");        
        assertEquals(1, bookid);
        
        String bookname = rs.getString("bookname");
        assertEquals("operating system", bookname);
    }
    
    @Test
    public void test04_SelectLike() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("ja");
        
        java.sql.ResultSet rs = svr.selectLike(book);

        // 1. 인스턴스 검증.
        assertNotNull(rs);

        // 2. 값으로 검증.
        rs.next(); // 커서가 첫번째로 row로 이동.
        String name = rs.getString("bookname"); // java 
        assertTrue( name.contains(  "ja"  ) );
        assertTrue( name.contains(  book.getBookname()  ) );

        // 3. 갯수로 검증.
    }
    
    @Test
    public void test05_SelectEqual() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");        

        java.sql.ResultSet rs = svr.selectEqual(book);

        // 1. 인스턴스 검증.
        assertNotNull(rs);

        // 2. 값으로 검증.
        rs.next(); // 커서가 첫번째 로우로 이동. 
        String name = rs.getString("bookname");
        assertEquals("mysql"           , name);
        assertEquals(book.getBookname(), name);
        
        // 3. 갯수로 검증.
    }
    @Test
    public void test06_SelectDynamic() {
        // 첫번째 검증. select    *     from book where 1 = 1
        //              select count(*) from book where 1 = 1  
     
        // 두번째 검증. select * from book where 1 = 1 and bookid =1;
        
        // 세번째 검증. select * from book where 1 = 1 and bookname ='java';
        
        // 네번째 검증. select * from book where 1 = 1 and bookid=2 and bookname ='mysql';
        
    }
    
    @Test
    public void test07_InsertBook() throws SQLException {
        java.sql.Date  date2 = java.sql.Date.valueOf("2017-11-08"); // new java.util.Date(117, 10, 8);
        
        ModelBook book = new ModelBook();
        book.setBookname ("test");
        book.setPublisher("abc" );
        book.setYear     ("2017");
        book.setPrice    (20000 );
        book.setDtm      (date2 );
        book.setUse_yn   (true  );
        book.setAuthid   (3     );
        
        int result = svr.insertBook(book);
        
        // insert 검증 : 
        //  1 리턴되는 경우 : insert 성공
        //  0 리턴되는 경우 : insert 실패
        assertEquals(1, result);
    }
    
    @Test
    public void test08_UpdateBook() throws SQLException {
        ModelBook wherebook = new ModelBook();
        wherebook.setBookname("test");
        
        ModelBook setbook  = new ModelBook();
        setbook.setPrice(15000);
        setbook.setYear("2016");
        
        int result = svr.updateBook(wherebook, setbook);
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우: 성공
        // 0 값이 리턴되는 경우: 성공
        assertTrue( result >= 0 );
    }
    
    @Test
    public void test10_DeleteBook() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("test");
        
        int result = svr.deleteBook(book);// result == 1
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우: 성공
        // 0 값이 리턴되는 경우: 성공.
        assertTrue( result >= 0 );    
        

        book.setBookname("test2");        
        result = svr.deleteBook(book); // result == 0
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우: 성공
        // 0 값이 리턴되는 경우: 성공.
        assertTrue( result >= 0 );  
    }
    
    @Test
    public void testTransCommit() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransRollback() {
        fail("Not yet implemented");
    }
    
}
