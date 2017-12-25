package java24.mybatis;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.inf.IServiceBook;
import java24.mybatis.svr.ServiceBook;

public class TestServiceBook {
    private static IServiceBook service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("servicebook", ServiceBook.class);
    }

    @Test
    public void testGetCount() {
        int result = -1;
        ModelBook book = new ModelBook();
        try {
            result = service.getCount(book);
            assertEquals(5, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMaxBookid() {
        int result = -1;
        try {
            result = service.getMaxBookid();
            assertEquals(5, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        List<ModelBook> result = null;
        try {
            result = service.selectAll();
            assertEquals(5, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectLike() {
        List<ModelBook> result = null;
        ModelBook book = new ModelBook();
        book.setBookname("%java%");
        try {
            result = service.selectLike(book);
            assertEquals(1, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectEqual() {
        List<ModelBook> result = null;
        ModelBook book = new ModelBook();
        book.setBookname("mysql2");
        try {
            result = service.selectEqual(book);
            assertEquals(1, result.size());
            assertEquals("mysql2", result.get(0).getBookname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectDynamic() {
        List<ModelBook> result = null;
        ModelBook book = new ModelBook();
        book.setBookid(2);
        book.setBookname("mysql");
        try {
            result = service.selectDynamic(book);
            assertEquals(1, result.size());
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertBook() {
        int result = -1;
        ModelBook book = new ModelBook();
        book.setBookname("ora~");
        book.setPublisher("cle!");
        book.setYear("2017");
        book.setPrice(37200);
        book.setDtm(null);
        book.setUse_yn(false);
        book.setAuthid(0);

        try {
            result = service.insertBook(book);
            assertEquals(9, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertMap() {
        int result = -1;
        ModelBook book = new ModelBook();
        book.setBookname("clecle");
        book.setDtm(Date.valueOf(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())));
        book.setAuthid(0);

        String bookname = book.getBookname();
        Date dtm = (Date) book.getDtm();
        int authid = book.getAuthid();

        try {
            result = service.insertMap(bookname, dtm, authid);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateBook() {
        int result = -1;
        ModelBook setbook = new ModelBook();
        ModelBook wherebook = new ModelBook();
        setbook.setBookname("mysql2");
        setbook.setPublisher("oreilly");
        setbook.setYear("2013");
        setbook.setPrice(54000);
        setbook.setDtm(Date.valueOf("2017-01-01"));
        setbook.setUse_yn(false);
        setbook.setAuthid(2);

        wherebook.setBookid(2);
        wherebook.setBookname("mysql");

        try {
            result = service.updateBook(wherebook, setbook);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBook() {
        int result = -1;
        ModelBook book = new ModelBook();
        book.setBookname("ora~");
        book.setPublisher("cle!");

        try {
            result = service.deleteBook(book);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAutoIncrementRefresh() {
        int result = -1;
        try {
            result = service.autoIncrementRefresh();
            assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAndAutoIncRefresh() {
        int result = -1;
        int rs = -1;
        ModelBook book = new ModelBook();
        book.setBookname("ora~");
        book.setPublisher("cle!");
        try {
            result = service.deleteBook(book);
            rs = service.autoIncrementRefresh();
            assertEquals(1, result);
            assertEquals(0, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
