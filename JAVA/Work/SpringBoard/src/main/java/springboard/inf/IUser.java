package springboard.inf;

import java.util.List;

import springboard.model.ModelUser;

public interface IUser {
    
    int insertUser(ModelUser user) throws Exception;
    
    List<ModelUser> login(ModelUser user) throws Exception;
    
    int logout() throws Exception;
    
    int updateUserInfo(ModelUser updateValue, ModelUser searchValue) throws Exception;
    
    int updatePasswd(String userid, String currentPasswd, String newPasswd) throws Exception;
    
    int deleteUser(ModelUser user) throws Exception;
    
    List<ModelUser> selectUserOne(ModelUser user) throws Exception;
    
    List<ModelUser> selectUserList(ModelUser user) throws Exception;
    
    int checkuserid(String userid) throws Exception;
}
