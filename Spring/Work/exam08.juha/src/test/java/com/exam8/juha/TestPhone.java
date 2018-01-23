package com.exam8.juha;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPhone {
    private static ClassPathXmlApplicationContext context;
    private static IServicePhone service;
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicePhone", IServicePhone.class);
    }

    @Test
    public void test01_GetPhoneList() {
        List<ModelPhone> result = service.getPhoneList();
        
        assertNotNull(result);
        
        assertEquals("Galaxy", result.get(0).getName());
    }
    
    @Test
    public void test02_GetPhoneOne() {
        ModelPhone result = service.getPhoneOne("Galaxy");
        
        assertNotNull(result);
        
        assertEquals("Samsung", result.getManufacturer());
    }

    @Test
    public void test03_InsertPhone() {
        ModelPhone phone = new ModelPhone();
        phone.setName("VEGA IM-100");
        phone.setManufacturer("SKY");
        phone.setPrice(2500);
        
        int result = service.insertPhone(phone);
        
        assertEquals(1, result);
    }
}
