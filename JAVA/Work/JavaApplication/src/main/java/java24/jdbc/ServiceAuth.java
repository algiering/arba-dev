package java24.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAuth implements IAuth {

    private Connection conn = null;

    public ServiceAuth() {
        this.conn = DBConnect.makeConnection();
    }

    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.getCount(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public int getMaxAuthid() throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.getMaxAuthid();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectAll();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectLike(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectEqual(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectDynamic(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.insertAuth(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.updateAuth(whereauth, setauth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public int delete(ModelAuth auth) throws SQLException {
        int result = -1;

        try {
            conn.setAutoCommit(false);
            DaoAuth dao = new DaoAuth(conn);
            result = dao.delete(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

}
