package com.testapp.juha;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testapp.juha.inf.IServiceUser;
import com.testapp.juha.model.ModelUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUser {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static IServiceUser service;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("serviceUser", IServiceUser.class); 
    }

    @Test
    public void test01() {
        
        ModelUser user = new ModelUser();
        user.setUser_email("aaaa");
        
        List<ModelUser> result = service.selectUserList(user);
        
        assertEquals("aaaa", result.get(0).getUser_name());
        
    }
    
    @Test
    public void test02() {
        
        ModelUser user = new ModelUser();
        user.setUser_email("aaaa");
        user.setUser_password("aaaa");
        user.setUser_use(0);
        
        int result = service.updateUserUse(user);
        
        assertEquals(1, result);
    }
    
    @Test
    public void test03() {
        
        ModelUser user = new ModelUser();

        user.setUser_email("bbbb");
        
        int result = service.updateUserInfo(user);
        
        assertEquals(1, result);
    }
}
