package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoBook {
    private static Connection conn = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBconnect.makeConnection();
    }

    @Test
    public void testGetCount() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        int result = dao.getCount(book);
            assertEquals(5, result);
    }

    @Test
    public void testGetMaxBookid() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        
            int result = dao.getMaxBookid();
            assertEquals(4, result);
    }

    @Test
    public void testSelectAll() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        ResultSet rs = dao.selectAll();
        assertNotNull(rs);
        rs.last();
        assertEquals(rs.getRow(), dao.getCount(book));
    }

    @Test
    public void testSelectLike() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        book.setBookname("ja");
        
        ResultSet rs = dao.selectLike(book);
        rs.next();
        String name = rs.getString("bookname");
        assertTrue(name.contains("ja"));
        assertTrue(name.contains(book.getBookname()));
    }

    @Test
    public void testSelectEqual() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        book.setBookname("mysql");
        
        ResultSet rs = dao.selectLike(book);
        rs.next();
        String name = rs.getString("bookname");
        assertTrue(name.contains("mysql"));
        assertTrue(name.contains(book.getBookname()));
    }

    @Test
    public void testSelectDynamic() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        ResultSet rs = dao.selectLike(book);
        rs.next();
        assertEquals(1, rs.getInt(1));
        assertEquals("operating system", rs.getString(2));
    }

    @Test
    public void testInsertBook() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        
        book.setBookname("android game");
        book.setPublisher("oracle");
        book.setDtm(java.sql.Date.valueOf("2017-01-01"));
        book.setPrice(20000);
        book.setUse_yn(true);
        book.setAuthid( 1 );
        
        int rs = dao.insertBook(book);
        assertEquals(1,rs);
    }

    @Test
    public void testUpdateBook() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteBook() {
        fail("Not yet implemented");
    }

}
