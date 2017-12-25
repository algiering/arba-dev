package java23.jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import java22.junit.MyUnit;

public class TestMyUnit {
    

    MyUnit mu = new MyUnit();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testConcate() {
        assertEquals("ab", mu.concate("a", "b"));
    }

    @Test
    public void testGetBoolean() {
        assertFalse(mu.getBoolean());
    }

    @Test
    public void testGetSameObject() {
        assertNull(mu.getSameObject());
    }

    @Test
    public void testGetObject() {
        assertNull(mu.getObject());
    }

    @Test
    public void testGetStringArray() {
        String[] s = {"one", "two", "three"};
        assertArrayEquals(s, mu.getStringArray());
    }

    @Test(expected = ArithmeticException.class)
    public void testGetException() {
        mu.getException();
    }

    @Test
    public void testGetEmptyList() {
        assertEquals(0, mu.getEmptyList().size());
    }

}
