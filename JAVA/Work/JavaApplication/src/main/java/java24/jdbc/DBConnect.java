package java24.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
    public static Connection connectionMySQL() {
        
        String url = "jdbc:mysql://localhost:3306/book_db?useUnicode=yes&characterEncoding=UTF8&autoReconnect=true";
        String user = "root";
        String password = "1234";
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static Connection makeConnection() {
        return connectionMySQL();
    }

}
