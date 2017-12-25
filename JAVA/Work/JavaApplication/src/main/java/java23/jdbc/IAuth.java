package java23.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IAuth {
    
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(ModelAuth auth) throws SQLException;

    ResultSet selectEqual(ModelAuth auth) throws SQLException;

    ResultSet selectDynamic(ModelAuth auth) throws SQLException;

    int insertAuth(ModelAuth auth) throws SQLException;

    int updateAuth(ModelAuth auth, ModelAuth whereauth) throws SQLException;

    int deleteAuth(ModelAuth auth) throws SQLException;

    ResultSet selectAuthid(ModelAuth auth) throws SQLException;

}
