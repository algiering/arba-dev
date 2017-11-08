package java23.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceBook implements IServiceBook {
    static Connection conn = DBconnect.makeConnection();

    @Override
    public int getCount(ModelBook book) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.getCount(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.commit();
        }
        return result;
    }

    @Override
    public int getMaxBookid() throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.getMaxBookid();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.commit();
        }
        return result;
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
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.insertBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.commit();
        }
        return result;
    }

    @Override
    public int updateBook(ModelBook book, ModelBook wherebook) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.updateBook(book, wherebook);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.commit();
        }
        return result;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            result = dao.deleteBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.commit();
        }
        return result;
    }

    @Override
    public ResultSet selectView() throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectView();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectAllView() throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectAllView();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int transCommit(ModelBook b1, ModelBook b2) {
        return 0;
    }

    @Override
    public int transRollback(ModelBook b1, ModelBook b2) {
        return 0;
    }

    @Override
    public ResultSet selectAuth() throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.selectAuth();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int rtBook(ModelBook book) throws SQLException {
        int rs = -1;

        try {
            conn.setAutoCommit(false);
            DaoBook dao = new DaoBook(conn);
            rs = dao.rtBook(book);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }
}
