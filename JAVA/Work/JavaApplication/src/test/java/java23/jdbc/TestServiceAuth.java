package java23.jdbc;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java24.jdbc.ServiceAuth;

public class TestServiceAuth {
    
    private static ServiceAuth svr = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceAuth();
    }

    @Test
    public void testGetCount() throws Exception {
        java24.jdbc.ModelAuth auth = null;
        int rs = svr.getCount(auth);
        
        assertEquals(4, rs);
    }

    @Test
    public void testGetMaxAuthid() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectAll() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectLike() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectEqual() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectDynamic() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testInsertAuth() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateAuth() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testDelete() throws Exception {
        fail("Not yet implemented");
    }

}
