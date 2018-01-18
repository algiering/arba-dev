package spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.bbs.common.PagingHelper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPageHelper {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void test01_paging() {
        // 총 레코드수 : 1000
        // 현재 페이지 : 1
        // 페이지 당 레코드 수 (rowsPerBlock) : 10
        // 블럭당 출력할 페이지 수 (pagesPerBlock) : 10
        
        int totalRecord = 1000;
        int curPage     = 1;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        
        assertEquals(paging.getListNo(), 1000);
        assertEquals(paging.getTotalPage(), 100);
        assertEquals(paging.getFirstPage(), 1);
        assertEquals(paging.getPrevLink(), 0);
        assertEquals(paging.getTotalFirstPage(), 1);
        assertEquals(paging.getLastPage(), 10);
        assertEquals(paging.getNextLink(), 11);
        assertEquals(paging.getTotalLastPage(), 100);
        assertEquals(paging.getEndRecord(), 10);
        assertEquals(paging.getStartRecord(), 1);
        assertArrayEquals(paging.getPageLinks(), new int[] {1,2,3,4,5,6,7,8,9,10});
    }
}
