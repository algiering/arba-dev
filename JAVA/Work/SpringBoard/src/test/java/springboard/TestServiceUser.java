package springboard;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springboard.inf.IServiceUser;
import springboard.model.ModelUser;
import springboard.svr.ServiceUser;

public class TestServiceUser {
    private static IServiceUser service = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service = context.getBean("serviceuser", ServiceUser.class);
        
    }

    @Test
    public void testInsertUser() {
        int result = -1;
        ModelUser user = new ModelUser();
        user.setUserid("aaaaaaa");
        user.setEmail("aaa@aaa.com");
        user.setPasswd("aaaaaaa");
            try {
                result = service.insertUser(user);
                assertEquals(1, result);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Test
    public void testLogin() {
        List<ModelUser> result = null;
        ModelUser user = new ModelUser();
        user.setUserid("aaaaaaa");
        user.setPasswd("ccc");
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
        searchValue.setUserid("aaaaaaa");
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
        String userid = "aaaaaaa";
        String currentPasswd = "bbb";
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
        user.setUserid("aaaaaaa");
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
        user.setUserid("aaaaaaa");
        try {
            result = service.selectUserOne(user);
            assertEquals("aaaaaaa", result.get(0).getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUserList() {
        List<ModelUser> result = null;
        ModelUser user = new ModelUser();
        user.setUserid("a");
        try {
            result = service.selectUserList(user);
            assertEquals(4, result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCheckuserid() {
        int result = -1;
        String userid = "aaaa";
        try {
            result = service.checkuserid(userid);
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
