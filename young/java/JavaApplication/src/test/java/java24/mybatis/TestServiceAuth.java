package java24.mybatis;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java24.mybatis.inf.IServiceAuth;
import java24.mybatis.model.ModelAuth;
import java24.mybatis.service.ServiceAuth;


import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceAuth {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceAuth service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:java24/mybatis/ApplicationContext.xml");
        
        service = context.getBean("serviceauth", ServiceAuth.class);
    }
    @Test
    public void test00_initAuth( ) throws Exception {
        service.initAuth();
    }
    
    @Test
    public void test01_GetCount() throws Exception {
        ModelAuth auth = new ModelAuth();
        int rs = service.getCount(auth);
        
        assertEquals(3, rs);
    }
    
    @Test
    public void test02_GetMaxAuthid() throws Exception {
        int rs = service.getMaxAuthid();
        assertEquals(7, rs);
    }
    
    @Test
    public void test03_SelectAll() throws Exception {
        List<ModelAuth> lis = null;
        lis = service.selectAll();
        assertNotNull(lis);
        assertEquals(3, lis.size());
        
    }
    
    @Test
    public void test04_SelectLike() throws Exception {
        List<ModelAuth> lis = null;
        ModelAuth auth = new ModelAuth();
        auth.setName("%bo%");
        lis = service.selectLike(auth);
        assertEquals("bob", lis.get(0).getName());
        auth = new ModelAuth();
        auth.setBirth("%2000%");
        lis = service.selectLike(auth);
        int bir = lis.get(0).getAuthid();
        assertEquals(7, bir);
        
    }
    
    @Test
    public void test05_SelectEqual() throws Exception {
        List<ModelAuth> lis = null;
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(1);
        lis = service.selectEqual(auth);
        assertEquals("bob", lis.get(0).getName());
        auth = new ModelAuth();
        auth.setBirth("1980.05.01");
        lis = service.selectEqual(auth);
        assertEquals("kim", lis.get(0).getName());
        int id = lis.get(0).getAuthid();
        assertEquals(2, id);
        
    }
    
    @Test
    public void test06_InsertAuth() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setName("lee");
        auth.setBirth("1987.02.23");
        int rs = service.insertAuth(auth);
        assertTrue(rs>=0);
        auth = new ModelAuth();
        auth.setBirth("1974.01.30");
        rs = service.insertAuth(auth);
        assertTrue(rs>=0);
        auth = new ModelAuth();
        auth.setName("row");
        rs = service.insertAuth(auth);
        assertTrue(rs>=0);
    }
    
    @Test
    public void test07_UpdateAuth() throws Exception {
        ModelAuth whereauth = new ModelAuth();
        whereauth.setAuthid(9);
        ModelAuth setauth = new ModelAuth();
        setauth.setName("cow");
        int rs = service.updateAuth(whereauth, setauth);
        assertNotEquals(-1, rs);
        whereauth = new ModelAuth();
        whereauth.setName("lee");
        setauth = new ModelAuth();
        setauth.setName("choi");
        setauth.setBirth("1974.01.30");
        rs = service.updateAuth(whereauth, setauth);
        assertNotEquals(-1, rs);
        whereauth = new ModelAuth();
        whereauth.setBirth("1974.01.30");
        setauth = new ModelAuth();
        setauth.setName("plum");
        setauth.setBirth("1974.01.30");
        rs = service.updateAuth(whereauth, setauth);
        assertNotEquals(-1, rs);
        
        
        
    }
    
    @Test
    public void test08_DeleteAuth() throws Exception {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(10);
        int rs = service.deleteAuth(auth);
        assertNotEquals(-1, rs);
        auth = new ModelAuth();
        auth.setName("cow");
        rs = service.deleteAuth(auth);
        assertNotEquals(-1, rs);
        auth = new ModelAuth();
        auth.setBirth("1974.01.30");
        rs = service.deleteAuth(auth);
        assertNotEquals(-1, rs);
        
    }
}