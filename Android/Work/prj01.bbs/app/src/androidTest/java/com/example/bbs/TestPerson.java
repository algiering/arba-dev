package com.example.bbs;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.bbs.http.HttpPerson;
import com.example.bbs.model.ModelPerson;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPerson {

    private static HttpPerson http = null;

    @BeforeClass
    public static void setup() {
        http = new HttpPerson();
    }

    @Test
    public void test01_curtime() throws Exception {

        long result = http.curtime();
        assertTrue(result>0);
    }

    @Test
    public void test02_loginperson() throws Exception {

        long result = http.loginperson("id1", "pw1");
        assertTrue(result>0);
    }

    @Test
    public void test03_selectparam() throws Exception {

        List<ModelPerson> result = http.selectparam("name1");

        assertNotNull(result);
        assertTrue(result.size()>=0);
    }
}
