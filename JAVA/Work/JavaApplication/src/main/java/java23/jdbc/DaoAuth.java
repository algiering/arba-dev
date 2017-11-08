package java23.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {

    private Connection conn = null;

    public DaoAuth(Connection conn) {
        super();
        this.conn = conn;
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
        int rs = 0;

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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
