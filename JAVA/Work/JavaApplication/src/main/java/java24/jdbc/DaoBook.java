package java24.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    private Connection conn = null;
    public DaoBook(Connection conn) { this.conn = conn; }

    @Override
    public int getCount(ModelBook book) throws SQLException {
        int result = -1;
        
        String query = " select count(*) as total from book where 1=1 ";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            result = rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getMaxBookid() throws SQLException {
        int result = -1;
        
        try {
            String query = " select max(bookid) maxid from book ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            result = rs.getInt("maxid");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        
        String query = " select * from book order by booid asc ";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select * from book where bookname like ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + book.getBookname() + "%");
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select * from book where bookname = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query =                             " select * from book "
                                                    +  " where 1 = 1 ";
            if(book.getBookid() != null)      query += " and bookid = ? ";
            if(!book.getBookname().isEmpty()) query += " and bookname = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            if (book.getBookid() != null)      stmt.setInt(1, book.getBookid());
            if (!book.getBookname().isEmpty()) stmt.setString(2, book.getBookname());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        String query = " insert into "
                + " book(bookname, publisher, year, price, dtm, use_yn, authid) "
                + "values(?,?,?,?,?,?,?) ";
        
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString (1, book.getBookname());
        stmt.setString (2, book.getPublisher());
        stmt.setString (3, book.getYear());
        stmt.setInt    (4, book.getPrice());
        stmt.setDate   (5, book.getDtm());
        stmt.setBoolean(6, book.getUse_yn());
        stmt.setInt    (7, book.getAuthid());
        
        return rs;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException {
        int rs = -1;
        
        try {
            String query  = " update book "
                    + " set year = ?, price = ? "
                    + " where bookname = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setbook.getYear());
            stmt.setInt(2,setbook.getPrice());
            stmt.setString(3, wherebook.getBookname());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            String query = " delete from book where bookname = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
