package java24.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IServiceBook extends IBook {

    int transCommit(ModelAuth auth, ModelBook book) throws SQLException;

    ResultSet transRollback(ModelBook b1, ModelBook b2) throws SQLException;

}
