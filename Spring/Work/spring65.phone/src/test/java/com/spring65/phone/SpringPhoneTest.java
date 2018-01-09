package com.spring65.phone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

public class SpringPhoneTest {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static ClassPathXmlApplicationContext context;
    private static IServicePhone service;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("servicephone", IServicePhone.class);
    }

    @Test
    public void testGetPhoneOne() {
        String name = "sdf";
        ModelPhone result = service.getPhoneOne(name);
        
        assertEquals(result.getName(), "sdf");
    }

    @Test
    public void testGetPhoneList() {
        List<ModelPhone> result = service.getPhoneList();
        
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testInsertPhone() {
        int result = -1;
        ModelPhone phone = new ModelPhone();
        phone.setName("T-1000");
        phone.setManufacturer("Terminater");
        phone.setPrice(1000);
        
        result = service.insertPhone(phone);
        
        assertEquals(result, 1);
    }

    @Test
    public void testInsertPhoneList() {
        int result = -1;
        List<ModelPhone> phones = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            ModelPhone p = new ModelPhone();
            p.setName("name"+i);
            p.setManufacturer("manu"+i);
            p.setPrice(3000+i);
            phones.add(p);
        }
        
        result = service.insertPhoneList(phones);
        
        assertEquals(result, 3);
    }
}
