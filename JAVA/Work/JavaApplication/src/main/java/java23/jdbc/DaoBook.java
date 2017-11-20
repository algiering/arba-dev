package java23.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    private Connection conn = null;
    
    public DaoBook(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public int getCount(ModelBook book) throws SQLException {
        Integer result = -1;
                
        try {
            String query = "select count(*) as total from book where 1=1";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getMaxBookid() throws SQLException {
        Integer result = -1;
        
        try {
            String query = "select max(bookid) as maxbid from book where 1=1";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getInt("maxbid");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "select * from book where 1=1";
            
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
            String query = "select * from book where bookname like ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+ book.getBookname() +"%");
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
            String query = "select * from book where bookname = ?";
            
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
            String query = "select * from book where 1=1 \n";
            if (book.getBookid()!=null)        query += "and bookid = ? \n";
            if (!book.getBookname().isEmpty()) query += "and bookname =? \n";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (book.getBookid()!=null)        stmt.setInt(c++, 1);
            if (!book.getBookname().isEmpty()) stmt.setString(c++, "operating system");
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = 0;
        
        try {
            String query = "insert into \n";
                   query += "book (bookname, publisher, genre, writer, price, dtm, use_yn, authid) \n";
                   query += "values(?,?,?,?,?,?,?,?)";
                   
                   PreparedStatement stmt = conn.prepareStatement(query);
                   stmt.setString(1, book.getBookname());
                   stmt.setString(2, book.getPublisher());
                   stmt.setString(3, book.getGenre());
                   stmt.setString(4, book.getWriter());
                   stmt.setInt(5, book.getPrice());
                   stmt.setDate(6, (Date) book.getDtm());
                   stmt.setBoolean(7, book.getUse_yn());
                   stmt.setInt(8, book.getAuthid());
                   
                   rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int updateBook(ModelBook book, ModelBook wherebook) throws SQLException {
        int rs = -1;
        
        try {
            String query = "update book\n";
                   query += "set bookname = ?, publisher = ?, genre = ?, writer = ?, price = ?, dtm = ?, use_yn = ?, authid = ? \n";
                   query += "where bookname = ? ";
                   
                   PreparedStatement stmt = conn.prepareStatement(query);
                   stmt.setString(1, book.getBookname());
                   stmt.setString(2, book.getPublisher());
                   stmt.setString(3, book.getGenre());
                   stmt.setString(4, book.getWriter());
                   stmt.setInt(5, book.getPrice());
                   stmt.setDate(6, (Date) book.getDtm());
                   stmt.setBoolean(7, book.getUse_yn());
                   stmt.setInt(8, book.getAuthid());
                   stmt.setString(9, wherebook.getBookname());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = 0;
        
        try {
            String query = "delete from book where bookname = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectView() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "select auth.name ,book.bookname, book.dtm"
                    + " from book inner join auth"
                    + " on book.authid = auth.authid";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectAllView() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "select * from auth inner join book"
                    + " on auth.authid = book.authid";

            
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectAuth() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = "select * from auth";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int rtBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            String query = "update book"
                    + " set dtm = null, authid = null"
                    + " where bookname = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectBorrow() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select bookname, publisher, writer from book where authid = 0 ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int updateBorrow(ModelBook book) throws SQLException {
        int result = -1;
        
        try {
            String query = " update book "
                    + " set authid = ?, dtm = curdate(), use_yn = 1 "
                    + " where bookname = ? and publisher = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, book.getAuthid());
            stmt.setString(2, book.getBookname());
            stmt.setString(3, book.getPublisher());
            
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public ResultSet genreTree() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select genre from book group by genre ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public int genreTreeCount() throws SQLException {
        int result = -1;
        
        try {
            String query = " select count(distinct genre) from book ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getInt(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public ResultSet genreTreeNode(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select bookname from book where genre = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, book.getGenre());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet publisherTree() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select publisher from book group by publisher ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet writerTree() throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select writer from book group by writer ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet publisherTreeNode(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select bookname from book where publisher = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, book.getPublisher());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet writerTreeNode(ModelBook book) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query = " select bookname from book where writer = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, book.getWriter());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
