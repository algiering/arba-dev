package com.spring61.rest;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring61.rest.inf.IServiceUser;
import com.spring61.rest.model.ModelUser;
import com.spring61.rest.svr.ServiceUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    private static IServiceUser service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service = context.getBean("serviceuser", ServiceUser.class);
        
        javax.sql.DataSource dataSource = (DataSource) context.getBean("dataSource");
        org.apache.ibatis.jdbc.ScriptRunner runner = new org.apache.ibatis.jdbc.ScriptRunner(dataSource.getConnection());
        
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
        java.io.Reader br = new java.io.BufferedReader(new java.io.FileReader(sf));
        
        runner.runScript(br);
        runner.closeConnection();
    }

    @Test
    public void test01InsertUser() {
        int result = -1;
        ModelUser user = new ModelUser();
        user.setUserid("aaa");
        user.setEmail("aaa@aaa.com");
        user.setPasswd("aaa");
            try {
                result = service.insertUser(user);
                assertEquals(1, result);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Test
    public void test02Login() {
        List<ModelUser> result = null;
        ModelUser user = new ModelUser();
        user.setUserid("aaa");
        user.setPasswd("aaa");
        try {
            result = service.login(user);
            assertEquals(1, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLogout() {
    }

    @Test
    public void testUpdateUserInfo() {
        int result = -1;
        ModelUser updateValue = new ModelUser();
        ModelUser searchValue = new ModelUser();
        updateValue.setUserid("bbbb");
        updateValue.setEmail("bbb@bbb.com");
        updateValue.setPasswd("bbb");
        searchValue.setUserno(1);
        searchValue.setUserid("aaa");
        try {
            result = service.updateUserInfo(updateValue, searchValue);
            assertEquals(1, result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdatePasswd() {
        int result = -1;
        String userid = "aaa";
        String currentPasswd = "aaa";
        String newPasswd = "ccc";
        try {
            result = service.updatePasswd(userid, currentPasswd, newPasswd);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser() {
        int result = -1;
        ModelUser user = new ModelUser();
        user.setUserid("aaa");
        try {
            result = service.deleteUser(user);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUserOne() {
        List<ModelUser> result = null;
        ModelUser user = new ModelUser();
        user.setUserid("aaa");
        try {
            result = service.selectUserOne(user);
            assertEquals("aaa", result.get(0).getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUserList() {
        List<ModelUser> result = null;
        ModelUser user = new ModelUser();
        user.setUserid("");
        try {
            result = service.selectUserList(user);
            assertEquals(1, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckuserid() {
        int result = -1;
        String userid = "aaa";
        try {
            result = service.checkuserid(userid);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
