package com.spring65.phone;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

public class TestServicePhone {
    private static ApplicationContext context = null;
    private static IServicePhone service = null;
        
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean("servicephone", IServicePhone.class);
    }    
 
    @Test
    public void testinsertPhone() {
                
        ModelPhone phone= new ModelPhone();
       
        phone.setName("Sunny");
        phone.setManufacturer("motorola");
        phone.setPrice(19000);
        
        int result= service.insertPhone(phone);
        
        assertSame(result , 1);
    }
}
