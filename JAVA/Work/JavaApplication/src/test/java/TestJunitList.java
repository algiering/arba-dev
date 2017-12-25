import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunitList {

    private static List<String> list = null;

    @BeforeClass
    public static void setUpClass() {
        list = new ArrayList<String>();
        list.add("0");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("4");
    }

    @Test
    public void ListNotNullTest() {
        assertNotNull(list);
    }
    
    @Test
    public void ListFiveTest() {
        assertEquals(5, list.size());
        assertTrue(list.size()==5);
    }
    
    @Test
    public void ListExistTest() {
        assertFalse(list.contains(10));
        assertEquals(-1, list.indexOf("10"));
        System.out.println(list.indexOf("2"));
    }
    
    @Test
    public void ListEqualsTest() {
        String name[] = {"y2kpooh", "hwang"};
        String name2[] = {"y2kpooh", "hwang"};
        
        assertArrayEquals(name, name2);
    }
}
