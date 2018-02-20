package com.spring65.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.phone.inf.*;
import com.spring65.phone.model.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    private static ApplicationContext context = null;
    private static IServicePhone service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("svrphone", IServicePhone.class);
    }  
    
    @Test
    public void test01_InsertPhone() {
        ModelPhone phone = new ModelPhone("name1", "manu 1", 1000);
        int result = service.insertPhone(phone);
        assertSame(1, result);
    }
    
    @Test
    public void test02_GetPhoneList() {
        List<ModelPhone> result = service.getPhoneList();
        
        assertNotNull( result);
        assertTrue(  result.size() >  0 );
    } 
    
    @Test
    public void test03_GetPhoneOne() {
        ModelPhone result = service.getPhoneOne( "name1" );
        assertNotNull( result);
        assertEquals("name1", result);
    }
    
    @Test
    public void test04_InsertPhoneList() {
        List<ModelPhone> phones = new ArrayList<>();
        phones.add( new ModelPhone("name2", "manu 2", 2000) );
        phones.add( new ModelPhone("name3", "manu 3", 3000) );
        phones.add( new ModelPhone("name4", "manu 4", 4000) );
        phones.add( new ModelPhone("name5", "manu 5", 5000) );
        
        int result = service.insertPhoneList( phones );
        
        assertSame( 4, result );
    }
}









