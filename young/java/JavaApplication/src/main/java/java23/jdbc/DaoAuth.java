package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {
    
    private java.sql.Connection conn = null;
   
    public DaoAuth(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        
        int result = -1;
        try {
            // SQL 쿼리문 작성
            String sql = " select count(*) total from auth ";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            // 문장 객체 실행: executeQuery() or executeUpdate() 
            ResultSet rs = stmt.executeQuery();
                    
            // 커서 이동
            rs.next(); // 커서를 다음 row로 이동
            rs.first(); // 커서를 첫번째 row로 이동

            // 컬럼명을 이용하여 값을 추출.
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
            // SQL 쿼리문 작성
            String sql = " select max(authid) authid from auth ";        
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            // 문장 객체 실행: executeQuery() or executeUpdate() 
            ResultSet rs = stmt.executeQuery();
            
            // 커서 이동
            rs.next();
            
           // 값을 추출
            result = rs.getInt("authid");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        // 문장 객체 실행: executeQuery() or executeUpdate() 
        ResultSet rs = null;
        try {
            // SQL 쿼리문 작성
            String sql = " select * from auth ";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
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
            // SQL 쿼리문 작성 : select * from auth where name like '%b%';
            // 찾고자 하는 값은 '%b%'  ---> ? 로 바꾼다.
            String sql = " select * from auth where name like ? "; 
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            // ? 자리에 값을 넣기
            stmt.setString(1, "%" + auth.getName() + "%" );

            // 문장 객체 실행: executeQuery() or executeUpdate() 
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
            // SQL 쿼리문 작성 : select * from auth where name = 'bob';
            String sql = " select * from auth where name = ? ";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, auth.getName() );

            // 문장 객체 실행: executeQuery() or executeUpdate() 
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }

    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        // SQL 쿼리문 작성
        
        // 문장 객체 생성
        
        // 문장 객체 실행: executeQuery() or executeUpdate() 
        return null;
    }

    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        
        int rs = -1;
        try {
            // SQL 쿼리문 작성
            String sql = "";
            sql += " insert into auth  ( authid, name, birth ) \n";
            sql += "             values( ?     , ?   , ?     ) \n";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            // ? 자리에 값 넣기
            stmt.setInt   (1, auth.getAuthid() );
            stmt.setString(2, auth.getName()   );
            stmt.setString(3, auth.getBirth()  );

            // 문장 객체 실행: executeQuery() or executeUpdate() 
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }

    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth) throws SQLException {
        
        int rs = -1;
        try {
            // SQL 쿼리문 작성
            String sql = "";
            sql += " update auth         \n";
            sql += "    set name   = ?   \n";
            sql += "      , birth  = ?   \n";
            sql += "  where 1 = 1        \n";
            sql += "    and authid = ?   \n";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            // ? 자리에 값 넣기
            stmt.setString(1, setauth.getName()     );
            stmt.setString(2, setauth.getBirth()    );
            stmt.setInt   (3, whereauth.getAuthid() );

            // 문장 객체 실행: executeQuery() or executeUpdate() 
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
            // SQL 쿼리문 작성
            String sql = "";
            sql += "  delete from auth  \n";
            sql += "   where 1 = 1      \n";
            sql += "     and name  = ?  \n";
            sql += "     and birth = ?  \n";
            
            // 문장 객체 생성
            PreparedStatement stmt = this.conn.prepareStatement(sql);
   
            // ? 자리에 값 넣기
            stmt.setString(1, auth.getName()  );
            stmt.setString(2, auth.getBirth() );

            // 문장 객체 실행: executeQuery() or executeUpdate() 
            rs = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
}
