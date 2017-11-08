import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java22.junit.Oper;

public class TestOper {
    
    private static Oper op = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        op = new Oper(5,10);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_Add() {
        int result = op.Add();
        assertEquals(15, result);
    }
    @Test
    public void test_Minus() {
        int result = op.Minus();
        assertEquals(-5, result);
    }
    @Test
    public void test_Multi() {
        int result = op.Mul();
        assertEquals(50, result);
    }
    @Test
    public void test_Div() {
        double result = op.Div();
        assertEquals(0.5, result, 0.01);
    }
}
