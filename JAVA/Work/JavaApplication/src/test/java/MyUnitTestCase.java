

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java22.junit.MyUnit;

public class MyUnitTestCase {
    
    public static MyUnit mu = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        mu = new MyUnit();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testConcate() {
        String result = mu.concate("a", "b");
        assertEquals("ab", result);
    }
    
    @Test
    public void testBoolean() {
        boolean result = mu.getBoolean();
        assertFalse(result);
        assertEquals(result, false);
        assertSame(result, false);
    }
    
    @Test
    public void testSameObject() {
        Object result = mu.getSameObject();
        assertNull(result);
        assertEquals(null, result);
        assertSame(null, result);
    }
    
    @Test
    public void testObject() {
        Object result = mu.getObject();
        assertNull(result);
        assertEquals(null, result);
        assertSame(null, result);
    }
    
    @Test
    public void testStringArray() {
        String[] string = mu.getStringArray();
        String[] expected = { "one", "two", "three" };
        assertArrayEquals( expected, string);
        assertArrayEquals( new String[] { "one", "two", "three" }, string);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testException() {
        double result = mu.getException();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyListE() {
        ArrayList<String> arrayList = mu.getEmptyList();
        arrayList.get(0);        
    }
    
    @Ignore
    @Test
    public void testEmptyListEI() {
        ArrayList<String> arrayList = mu.getEmptyList();
        arrayList.get(0);        
    }
    
    @Test
    public void testEmptyList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        assertEquals(arrayList, mu.getEmptyList());
    }
    
//    mu.getException()
//    mu.getEmptyList()


}
