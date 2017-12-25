import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java22.junit.Oper;
import test.Rect;

public class TestOper2 {
    
    private static Rect rect = null;
    private static Oper op = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        rect = new Rect(5, 10);
        op = new Oper(5, 5);
    }
    
    @Before
    public void setUp() throws Exception {
        
    }

    @Test
    public void test_add() {
        int r = op.Add();
        assertEquals(10, r);
    }

    @Test
    public void test_minus() {
        int r = op.Minus();
        assertEquals(0, r);
    }

    @Test
    public void test_multi() {
        int r = op.Mul();
        assertEquals(25, r);
    }

    @Test
    public void test_div() {
        double r = op.Div();
        assertEquals(1, r, 0.0);
    }

    @Test
    public void test_area() {
        int r = rect.area();
        assertEquals(50, r);
        
        assertTrue(50==r);
        assertFalse(80==r);
    }

    @Test
    public void test_perimeter() {
        int r = rect.perimeter();
        assertEquals(30, r);
    }
    
    @Test
    public void test_type() {
        Object o = rect.type();
        
        assertNull(o);
    }

}
