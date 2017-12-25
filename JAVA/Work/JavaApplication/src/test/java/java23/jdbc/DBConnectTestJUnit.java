package java23.jdbc;
import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import bookservice.DBConnect;

public class DBConnectTestJUnit {

    @Test
    public void connectionMySQL() throws Exception {
        Connection conn = DBConnect.connectionMySQL();

        if (conn != null) {
            assertTrue("db connect success", true);
        } else {
            assertTrue("db connect fail", false);
        }
    }

    @Test
    public void makeConnection() throws Exception {
        Connection conn = DBConnect.connectionMySQL();
        if (conn != null) {
            assertTrue("db connect success", true);
        } else {
            assertTrue("db connect fail", false);
        }
    }

}
