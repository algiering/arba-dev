package com.web2.juha;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web2.juha.inf.IServiceUser;
import com.web2.juha.model.ModelUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUser {
    
    private static IServiceUser service;
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceUser.class);  
    }

    @Test
    public void test01() {
        
        ModelUser result = null;
        ModelUser user = new ModelUser();
        user.setUser_id("algiering");
        user.setUser_password("asdf1234");
        
        result = service.getUserOne(user);
        
        assertEquals("1", result.getUser_no());
        
    }
}
