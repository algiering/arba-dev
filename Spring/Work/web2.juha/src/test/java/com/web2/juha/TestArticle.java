package com.web2.juha;

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

import com.web2.juha.inf.IServiceArticle;
import com.web2.juha.model.ModelArticle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestArticle {
    
    private static IServiceArticle service;
    
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean(IServiceArticle.class);  
    }

    @Test
    public void test01() {
        String board_id = "mhw";
        List<ModelArticle> result = service.getArticleList(board_id);
        
        assertEquals(118, result.size());
        
    }
    
    @Test
    public void test02() {
        String board_id = "mhw";
        Integer article_subno = 10;
        
        ModelArticle result = service.getArticleOne(board_id, article_subno);
        
        assertNotNull(result);
        
    }
    
}
