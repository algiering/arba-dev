package di02.context;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di02.context.ISearchEngine;
import di02.context.SearchEngine;


public class TestService {
    
    @Test
    public void testMakeInstanceWithNew() {
        // setter를 이용한 초기화
        di02.context.Type webType = new di02.context.Type();
        webType.setName("web");
        webType.setExtension(".url");
        webType.setDesc("web link");
        
        di02.context.Document doc1 = new di02.context.Document("aaa", webType, "/aaa.txt");        
        assertEquals("/aaa.txt", doc1.getLocation() );
        assertEquals("aaa", doc1.getName());
        assertEquals(webType, doc1.getType());
    }
    
    @Test
    public void testMakeInstanceWithSpring() {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("classpath:context.xml");
        
        di02.context.Type pdfType = (di02.context.Type) context.getBean("pdfType");
        assertEquals( "PDF"               , pdfType.getName() );
        assertEquals( "Portable Document" , pdfType.getDesc() );
        assertEquals( ".pdf"              , pdfType.getExtension() );
        
        di02.context.Type webType = context.getBean("webType", di02.context.Type.class);
        assertEquals( "WEB"      , webType.getName() );
        assertEquals( "WEB link" , webType.getDesc() );
        assertEquals( ".url"     , webType.getExtension() );
        
        di02.context.Document doc1 = context.getBean("doc1", di02.context.Document.class );
        assertEquals("/book/Book.pdf", doc1.getLocation() );
        assertEquals("Book"          , doc1.getName());
        assertEquals(pdfType         , doc1.getType() );   
        
        // di02.ISearchEngine engine = new SearchEngine();        
        di02.context.ISearchEngine engine = context.getBean("engine", ISearchEngine.class);
        assertEquals(2, engine.listAll().size() );
    }
}
