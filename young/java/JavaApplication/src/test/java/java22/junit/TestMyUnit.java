package java22.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestMyUnit {
    private static MyUnit myUnit = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        myUnit = new MyUnit();
    }

    @Test
    public void testConcate() {
        String result = myUnit.concate("ab", "12");
        assertEquals("ab12", result);
    }

    @Test
    public void test_getBoolean() {
        boolean result = myUnit.getBoolean() ;
        assertFalse(result);
        assertEquals( result, false );
        assertSame( result, false );
    }

    @Test
    public void test_getSameObject() {
        Object result = myUnit.getSameObject();
        
        // null 검증
        assertNull(result);
        assertEquals(null, result);
        assertSame(null, result);
    }
    
    @Test
    public void test_getObject() {
        Object result = myUnit.getObject();
        // null 검증
        assertNull(result);
        assertEquals(null, result);
        assertSame(null, result);
    }

    @Test
    public void test_getStringArray() {
        String[] result = myUnit.getStringArray();
        String[] expecteds = {"one", "two", "three"};
        assertArrayEquals(expecteds, result);  // 배열의 값으로 동일 여부를 비교.
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void test_getException() {
        double resutl = myUnit.getException(); // ArithmeticException 발생.
    }

    @Ignore
    @Test(expected = IndexOutOfBoundsException.class )
    public void test_getEmptyList() {
        ArrayList<String> list = myUnit.getEmptyList();
        list.get(0);
    }
    
}
