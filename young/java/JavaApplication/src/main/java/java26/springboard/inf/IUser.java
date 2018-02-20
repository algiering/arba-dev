package java26.springboard.inf;

import java.util.List;

import java26.springboard.model.ModelUser;

public interface IUser {
    
    int logout(String userid);
    
    ModelUser login(String userid, String passwd);
    
    // id �ߺ� Ȯ�ν� ���Ǵ� �޼���
    int checkuserid(String userid);
    
    int updatePasswd(String userid, String currentPasswd, String newPasswd);

    List<ModelUser> selectUserList(ModelUser user);
    
    ModelUser selectUserOne(ModelUser user);
    
    int insertUser(ModelUser user);
    
    int updateUserInfo(ModelUser setValue, ModelUser whereValue);
    
    int updateRetire(ModelUser user);
    
    // password Ȯ��. �ֳ��ϸ� �н������ ��ȣȭ �Ǳ� ������...
    int checkpassword( String id, String curpw);
}
