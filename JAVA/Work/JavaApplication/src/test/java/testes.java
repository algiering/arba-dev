import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bookservice.copy.ModelBook;
import bookservice.copy.ServiceBook;

public class testes {
    static ServiceBook svr = null;

    @BeforeClass
    public static void setClass() throws Exception {
        svr = new ServiceBook();
    }

    @Test
    public void selectAll() throws Exception {
        ModelBook book = new ModelBook();
        ResultSet rs = svr.selectAll();
        assertNotNull(rs);
        rs.last();
        assertEquals(rs.getRow(), svr.getCount(book));
    }
}
