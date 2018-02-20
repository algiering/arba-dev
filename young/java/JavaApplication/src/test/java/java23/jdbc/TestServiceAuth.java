package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceAuth {
    
    private static ServiceAuth svr = null;    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceAuth();
    }
    
    @Test
    public void test01_GetCount() throws SQLException {
        ModelAuth auth = null;
        int rs = svr.getCount(auth );
        
        // 검증.
        // 인스턴스 검증
        // 값 검증        
        assertEquals(3, rs);        
    }
    
    @Test
    public void test02_GetMaxAuthid() {
        fail("Not yet implemented");
    }
    
    @Test
    public void test03_SelectAll() throws SQLException {
        ResultSet rs = svr.selectAll();
        
        // 인스턴스 검증
        assertNotNull(rs);
        
        // 값으로 검증
        // 1. 갯수로 검증.
        ModelAuth auth = null;
        int count = svr.getCount( auth );  // rscount == 3
        
        // ResutlSet의 갯수 가져오기.
        rs.last();  // 마지막 row로 커서를 이동하시오.
        int countset = rs.getRow();  // 현재 커서의 index 값을 가져오기.
        
        assertEquals(count, countset);
        
        // 2. row 값으로 검증.
        rs.first(); // 커서를 첫번째 row 로 이동
        int authid = rs.getInt("authid");  // == 1
        assertEquals(1,  authid);
    }
    
    @Test
    public void test04_SelectLike() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("b");
        
        java.sql.ResultSet rs = svr.selectLike(auth);
        
        // 인스턴스 검증
        assertNotNull(rs);

        // 값을 이용한 검증
        rs.next(); // 커서가 첫번째로 row로 이동.
        String name = rs.getString("name"); 
        assertTrue( name.contains(  auth.getName()  ) );
    }
    
    @Test
    public void test05_SelectEqual() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");        

        java.sql.ResultSet rs = svr.selectEqual(auth);
        
        // 인스턴스 검증
        assertNotNull(rs);

        // 값을 이용한 검증
        rs.next(); // 커서가 첫번째 로우로 이동. 
        String name = rs.getString("name");
        assertEquals(auth.getName(), name);
    }
    
    @Test
    public void test06_InsertAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName  ("test");
        auth.setAuthid(300   );
        
        int result = svr.insertAuth(auth);
        
        // insert 검증 : 
        //  1 리턴되는 경우 : insert 성공
        //  0 리턴되는 경우 : insert 실패
        assertEquals(1, result);
    }
    
    @Test
    public void test07_UpdateAuth() throws SQLException {
        ModelAuth whereauth = new ModelAuth();
        whereauth.setAuthid(300);
        
        ModelAuth setauth  = new ModelAuth();
        setauth.setName("test");
        setauth.setBirth("2016");
        
        int result = svr.updateAuth(whereauth, setauth);
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우: 성공
        // 0 값이 리턴되는 경우: 성공
        assertTrue( result >= 0 );
    }
    
    @Test
    public void test08_DeleteAuth() throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(300);
        
        int result = svr.deleteAuth(auth);// result == 1
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우: 성공
        // 0 값이 리턴되는 경우: 성공.
        assertTrue( result >= 0 );    
    }
    
    @Test
    public void test09_SelectDynamic() {
        fail("Not yet implemented");
    }
    
}
