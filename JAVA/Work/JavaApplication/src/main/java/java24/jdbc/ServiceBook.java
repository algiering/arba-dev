package java24.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBook implements IServiceBook {

    private Connection conn = null;

    public ServiceBook() {
        this.conn = DBConnect.makeConnection();
    }

    @Override
    public int getCount(ModelBook book) throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.getCount(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int getMaxBookid() throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.getMaxBookid();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectAll();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelBook book) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectLike(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectEqual(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectDynamic(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.insertBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.updateBook(wherebook, setbook);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.deleteBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int transCommit(ModelAuth auth, ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            conn.setAutoCommit(false);
            DaoAuth daoAuth = new DaoAuth(conn);
            rs = daoAuth.insertAuth(auth);
            
            book.setAuthid(rs);
            
            DaoBook daoBook = new DaoBook(conn);
            rs = daoBook.insertBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet transRollback(ModelBook b1, ModelBook b2) throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            dao.deleteBook(b1);
            dao.insertBook(b2);
            rs = dao.selectAll();
            throw new SQLException();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
    
    

}
