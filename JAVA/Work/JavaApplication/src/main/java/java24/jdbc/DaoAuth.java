package java24.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {

    private Connection conn = null;

    public DaoAuth(Connection conn) { this.conn = DBConnect.makeConnection(); }

    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int result = -1;

        try {
            String query = " select count(*) total from auth where 1 = 1 ";

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
    public int getMaxAuthid() throws SQLException {
        int result = -1;

        try {
            String query = " select max(authid) maxid from auth ";

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

        try {
            String query = " select * from auth order by authid ";

            PreparedStatement stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            String qeury = " select * from auth "
                         + " where name like ? ";

            PreparedStatement stmt = conn.prepareStatement(qeury);

            stmt.setString(1, "%" + auth.getName() + "%");

            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            String query = " select * from auth "
                         + "where name = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, auth.getName());

            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        ResultSet rs = null;
        
        try {
            String query =                          " select * from book "
                                                 +  " where 1 = 1 ";
            if(auth.getAuthid() != null)   query += " and authid = ? ";
            if(!auth.getName().isEmpty())  query += " and name = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            if (auth.getAuthid() != null)      stmt.setInt(1, auth.getAuthid());
            if (!auth.getName().isEmpty()) stmt.setString(2, auth.getName());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int result = -1;
        
        try {
            String query = " insert into auth "
                         + " (name, birth) "
                         + " values(?,?) ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            stmt.setDate(2, auth.getBirth());
            
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
        int result = -1;
        
        try {
            String query = " update auth "
                         + " set name = ?, birth = ? "
                         + " where name = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getName());
            stmt.setDate(2, setauth.getBirth());
            stmt.setString(3, whereauth.getName());
            
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(ModelAuth auth) throws SQLException {
        int result = -1;

        try {
            String query = " delete from auth "
                         + " where name = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, auth.getName());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
