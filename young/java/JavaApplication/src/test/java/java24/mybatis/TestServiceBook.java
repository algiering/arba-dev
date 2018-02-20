package java24.mybatis;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.inf.IServiceBook;
import java24.mybatis.model.ModelBook;
import java24.mybatis.service.ServiceBook;



import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBook {
    private static IServiceBook service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        // classpath 를 이용한 설정 파일 로딩
        ApplicationContext context = new 
                ClassPathXmlApplicationContext("classpath:java24/mybatis/ApplicationContext.xml");

        // DI를 이용한 servicebook 인스턴스 생성
        service = context.getBean("servicebook", ServiceBook.class);
    }
    
    @Test
    public void test00_initBook( ) throws Exception {
        service.initBook();
    }

    @Test
    public void test01_GetCount() throws Exception {
        ModelBook book = new ModelBook();
        int rs = service.getCount(book );
        assertEquals(4, rs);
    }
    
    @Test
    public void test02_GetMaxBookid() throws Exception {
        int rs = service.getMaxBookid();
        assertEquals(4, rs);
    }
    
    @Test
    public void test03_SelectAll() throws Exception {
        ModelBook book = new ModelBook();
        
        List<ModelBook> rs = service.selectAll(book );

        // 1. 인스턴스 검증.
        assertNotNull(rs);
        
        // 2. 값으로 검증.
        ModelBook m = rs.get(0);
        assertSame  (1                 , m.getBookid()  );
        assertEquals("operating system", m.getBookname() );
        
        // 3. 갯수로 검증.
        int count = service.getCount(null);
        assertEquals(count, rs.size());
    }
    
    @Test
    public void test04_SelectLike() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("%a%");
        List<ModelBook> rs = service.selectLike(book);
        // 1. 인스턴스 검증.

        // 2. 값으로 검증.       
        assertEquals(new Integer(1), rs.get(0).getBookid());
        assertEquals("operating system", rs.get(0).getBookname());
        assertEquals("wiley", rs.get(0).getPublisher());
        assertEquals("2003", rs.get(0).getYear());
        assertEquals(new Integer(3), rs.get(1).getBookid());
        assertEquals("java", rs.get(1).getBookname());
        assertEquals("hall", rs.get(1).getPublisher());
        assertEquals("2013", rs.get(1).getYear());
        
        // 3. 갯수로 검증.
    }
    
    @Test
    public void test05_SelectEqual() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        List<ModelBook> rs = service.selectEqual(book);
        
        // 1. 인스턴스 검증.

        // 2. 값으로 검증.
        assertEquals(new Integer(2), rs.get(0).getBookid());
        assertEquals("mysql", rs.get(0).getBookname());
        assertEquals("oreilly", rs.get(0).getPublisher());
        assertEquals("2009", rs.get(0).getYear());
        
        // 3. 갯수로 검증.
    }
    
    @Test
    public void test06_InsertBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("photoshop");
        book.setPublisher("abc");
        int rs = service.insertBook(book);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test07_InsertMap() throws Exception {
        String bookname = "photoshop";
        java.util.Date dtm = java.sql.Date.valueOf("2007-02-01");
        Integer authid =10;
        int rs = service.insertMap(bookname, dtm, authid);
        assertTrue(rs >= 1);
    }
    
    @Test
    public void test08_UpdateBook() throws Exception {
        ModelBook wherebook = new ModelBook();
        wherebook.setBookname("photoshop");

        ModelBook setbook = new ModelBook();
        setbook.setBookname("javascript");
        setbook.setYear("2000");
        setbook.setPrice(25000);
        
        int rs = service.updateBook(wherebook, setbook);
        assertTrue(rs >= 0);
    }
    
    @Test
    public void test09_DeleteBook() throws Exception {
        ModelBook book = new ModelBook();
        book.setBookname("javascript");
        int rs = service.deleteBook(book);
        assertTrue(rs >= 0);
    }
    
}
