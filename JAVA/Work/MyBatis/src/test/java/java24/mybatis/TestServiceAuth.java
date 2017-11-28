package java24.mybatis;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.inf.IServiceAuth;
import java24.mybatis.svr.ServiceAuth;

public class TestServiceAuth {
    private static IServiceAuth service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceauth", ServiceAuth.class);
    }

    @Test
    public void testGetCount() {
        int result = -1;
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        try {
            result = service.getCount(auth);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMaxAuthid() {
        int result = -1;
        try {
            result = service.getMaxAuthid();
            assertEquals(7, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        List<ModelAuth> result = null;
        try {
            result = service.selectAll();
            assertEquals(3, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectLike() {
        List<ModelAuth> result = null;
        ModelAuth auth = new ModelAuth();
        auth.setName("%bo%");
        try {
            result = service.selectLike(auth);
            assertEquals(1, result.size());
            assertEquals("bob", result.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectEqual() throws Exception {
        List<ModelAuth> result = null;
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(1);
        auth.setName("bob");
        result = service.selectEqual(auth);
        assertTrue(1== result.get(0).getAuthid());
        

        auth.setAuthid(null);
        auth.setName("bob");
        result = service.selectEqual(auth);
        assertTrue(1==result.get(0).getAuthid());
    }

    @Test
    public void testInsertAuth() {
        int result = -1;
        ModelAuth auth = new ModelAuth();
        auth.setName("james");
        auth.setBirth("2000-06-06");
        try {
            result = service.insertAuth(auth);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateAuth() {
        int result = -1;
        ModelAuth setauth = new ModelAuth();
        ModelAuth whereauth = new ModelAuth();
        
        setauth.setName("gay");
        setauth.setBirth("2001-05-01");
        whereauth.setName("james");
        whereauth.setAuthid(8);
        
        try {
            result = service.updateAuth(whereauth, setauth);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteAuth() {
        int result = -1;
        ModelAuth auth = new ModelAuth();
        
        auth.setAuthid(8);
        auth.setName("gay");
        
        try {
            result = service.deleteAuth(auth);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
