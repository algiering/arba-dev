package com.web.juha;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.juha.inf.IServiceArticle;
import com.web.juha.model.ModelArticle;

public class TestArticle {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IServiceArticle svr;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testGetArticleOne() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetArticleList() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseHit() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseGood() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseBad() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsertArticle() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetCountArticleList() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetArticlePaging() {
        List<ModelArticle> result = null;
        
        int board_id = 0;
        String searchWord = "";
        int start = 121;
        int end = 130;
        
        result = svr.getArticlePaging(board_id, searchWord, start, end);
        
        assertEquals(0, result.size());
        
    }

    @Test
    public void testDeleteArticle() {
        fail("Not yet implemented");
    }
}
