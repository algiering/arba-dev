package java23.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService implements IAuth {

    @Override
    public ResultSet selectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return 0;
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
