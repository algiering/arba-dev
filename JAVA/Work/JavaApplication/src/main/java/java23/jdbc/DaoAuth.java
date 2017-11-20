package java23.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {

    private Connection conn = null;

    public DaoAuth(Connection conn) { this.conn = DBconnect.makeConnection(); }

    @Override
    public ResultSet selectAuthid(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            String query = "select authid, name from auth where authid = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, auth.getAuthid());
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;

        try {
            String query = "select * from auth where 1=1";

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

        String query = "select * from auth where name like ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, "%" + auth.getName() + "%");
        rs = stmt.executeQuery();

        return null;
    }

    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        ResultSet rs = null;

        try {
            String query = "select * from auth where name = ?";

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
            String query = "select * from auth where 1=1 \n";
            if (auth.getAuthid() != null)
                query += "and authid = ? \n";
            if (!auth.getName().isEmpty())
                query += "and name =? \n";

            PreparedStatement stmt = conn.prepareStatement(query);
            int c = 1;
            if (auth.getAuthid() != null)
                stmt.setInt(c++, 1);
            if (!auth.getName().isEmpty())
                stmt.setString(c++, auth.getName());

            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = -1;

        try {
            String query = "insert into \n";
            query += "auth (name, rrn, pnum, mail)";
            query += "values (?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            stmt.setString(2, auth.getRrn());
            stmt.setString(3, auth.getPnum());
            stmt.setString(4, auth.getMail());

            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int updateAuth(ModelAuth auth, ModelAuth whereauth) throws SQLException {
        int rs = -1;
        
        try {
            String query = " update auth "
                    + " set authid = ?, name = ?, rrn = ?, pnum = ?, mail = ? "
                    + " where authid = ? and name = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, auth.getAuthid());
            stmt.setString(2, auth.getName());
            stmt.setString(3, auth.getRrn());
            stmt.setString(4, auth.getPnum());
            stmt.setString(5, auth.getMail());
            stmt.setInt(6, whereauth.getAuthid());
            stmt.setString(7, whereauth.getName());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            String query = " delete from auth "
                    + "where authid = ? and name = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, auth.getAuthid());
            stmt.setString(2, auth.getName().toString());
            
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
