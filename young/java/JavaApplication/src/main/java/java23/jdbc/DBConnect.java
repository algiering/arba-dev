package java23.jdbc;

public class DBConnect {

    public static java.sql.Connection makeConnection(){    
        return connectionMySQL(); // MySQL과 연결할 때
    } 
    
    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    
    public static java.sql.Connection connectionMySQL(){

        String url      = "jdbc:mysql://localhost:3306/book_db?useUnicode=true&characterEncoding=utf8" ;
        String user     = "root";
        String password = "1234";        
        java.sql.Connection conn = null; 
        try {
            Class.forName("com.mysql.jdbc.Driver"); // mysql driver 로딩
            conn = java.sql.DriverManager.getConnection(url, user, password); //DB연결
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }         
        return conn;
    }

    public static java.sql.Connection connectionOracle(){
        
        String url      = "jdbc:oracle:thin:@//localhost:1521/pdborcl";
        String user     = "tester1";
        String password = "1234";
        
        java.sql.Connection conn = null;
        
        try {
            // driver 적재
            Class.forName("oracle.jdbc.OracleDriver");
            
            // 데이터베이스 연결
            conn = java.sql.DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
         
        return conn;
    }
        
    public static java.sql.Connection connectionSQLite(){
        /*
         * connection url 에 대해서 아래 사이트 참조.
         * https://bitbucket.org/xerial/sqlite-jdbc/wiki/Usage
         */
        String url      = "jdbc:sqlite::resource:resources/data/test.db";
        //String user     = "";
        //String password = "";
        
        java.sql.Connection conn = null;
        
        try {
            // driver 적재
            Class.forName("org.sqlite.JDBC");
            
            // 데이터베이스 연결
            conn = java.sql.DriverManager.getConnection(url /*, user, password */ );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
         
        return conn;
    }
}