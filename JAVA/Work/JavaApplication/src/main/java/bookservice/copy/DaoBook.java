package bookservice.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoBook implements IBook {
    private Connection conn = null;

    public DaoBook(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int getCount(ModelBook book) {
        int result = -1;

        String query = "SELECT count(*) as total from book where 1 = 1";

        try {
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
    public int getMaxBookid() {
        int result = -1;

        String query = "select max(bookid) maxid from book";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            result = rs.getInt("maxid");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ResultSet selectAll() {
        ResultSet rs = null;

        String query = "select * from book order by bookid ASC";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public ResultSet selectLike(ModelBook book) {
        ResultSet rs = null;

        try {
            String query = "select * from book where bookname like ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + book.getBookname() + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelBook book) {
        ResultSet rs = null;

        String query = "select * from book where book = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());

            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelBook book) {
        ResultSet result = null;

        try {
            String query = " select * from book \n";
            query += " where 1 = 1 \n";
            if (book.getBookid() != null) {
                query += " and bookid = ? \n";
            }
            if (!book.getBookname().isEmpty()) {
                query += " and bookname = ? \n";
            }
            PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if (book.getBookid() != null) {
                stmt.setInt(c++, book.getBookid());
            }
            if (!book.getBookname().isEmpty()) {
                stmt.setString(c++, book.getBookname());
            }
            
            result = stmt.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertBook(ModelBook book) {
        int rs = 0;

        PreparedStatement stmt;
        try {
            String query = "insert into ";
            query += " BOOK( BOOKNAME, PUBLISHER, YEAR, PRICE, DTM, USE_YN, AUTHID) ";
            query += " VALUES(?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            stmt.setString(2, book.getPublisher());
            stmt.setString(3, book.getYear());
            stmt.setInt(4, book.getPrice());
            stmt.setDate(5, (java.sql.Date) book.getDtm());
            stmt.setBoolean(6, book.getUse_yn());
            stmt.setInt(7, book.getAuthid());

            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) {
        int rs = 0;

        PreparedStatement stmt;
        try {
            String query = "update book \n";
            query += "set year = ?, price = ? \n";
            query += "where bookname = ? \n";
            stmt = conn.prepareStatement(query);

            stmt.setString(1, setbook.getYear());
            stmt.setInt(2, setbook.getPrice());
            stmt.setString(3, wherebook.getBookname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) {
        int rs = 0;
        try {
            String query = "delete from book where bookname = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());

            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
