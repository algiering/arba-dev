package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAuth implements IAuth {
    
    private Connection conn = null;
    
    public ServiceAuth() { this.conn = DBconnect.makeConnection(); }

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        // TODO Auto-generated method stub
        return null;
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
    public int updateAuth(ModelAuth auth, ModelAuth whereauth) throws SQLException {
        int result = -1;
        
        try {
            conn.setAutoCommit(false);
            
            DaoAuth dao = new DaoAuth(conn);
            result = dao.updateAuth(auth, whereauth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int result = -1;
        
        try {
            conn.setAutoCommit(false);
            
            DaoAuth dao = new DaoAuth(conn);
            result = dao.deleteAuth(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return result;
    }

    @Override
    public ResultSet selectAuthid(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            conn.setAutoCommit(false);
            
            DaoAuth dao = new DaoAuth(conn);
            rs = dao.selectAuthid(auth);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
        return rs;
    }

}
