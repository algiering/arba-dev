package bookservice.copy;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {
    
    public static Connection connectionMySQL() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/book_db/";
        String user = "root";
        String password = "1234";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public static Connection makeConnection(){
        return connectionMySQL();
        }


}
