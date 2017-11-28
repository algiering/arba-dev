package springboard.svr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboard.inf.IServiceUser;
import springboard.inf.IUser;
import springboard.model.ModelUser;

@Service("serviceuser")
public class ServiceUser implements IServiceUser {
    
    @Autowired
    @Qualifier("daouser")
    private IUser dao;

    @Override
    public int insertUser(ModelUser user) throws Exception {
        int result = -1;
        try {
            result = dao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUser> login(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int logout() throws Exception {
        int result = -1;
        try {
            result = dao.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateUserInfo(ModelUser updateValue, ModelUser searchValue) throws Exception {
        int result = -1;
        try {
            result = dao.updateUserInfo(updateValue, searchValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) throws Exception {
        int result = -1;
        try {
            result = dao.updatePasswd(userid, currentPasswd, newPasswd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteUser(ModelUser user) throws Exception {
        int result = -1;
        try {
            result = dao.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserOne(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.selectUserList(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) throws Exception {
        List<ModelUser> result = null;
        try {
            result = dao.selectUserList(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int checkuserid(String userid) throws Exception {
        int result = -1;
        try {
            result = dao.checkuserid(userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
