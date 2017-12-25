import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java23.jdbc.DBconnect;

public class TestConnection {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_connectionMySQL() throws Exception {
        Connection conn = DBconnect.connectionMySQL();

        if (conn != null) {
            assertTrue("db connect success", true);
        } 
        else {
            assertTrue("db connect fail", false);
        }
    }

    @Test
    public void Test_makeConnection() throws Exception {
        Connection conn = DBconnect.makeConnection();

        if (conn != null) {
            assertTrue("db connect success", true);
        } 
        else {
            assertTrue("db connect fail", false);
        }
    }

}
