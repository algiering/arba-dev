package com.spring81.bbs.inf;

import java.util.List;

import com.spring81.bbs.model.ModelUser;

public interface IUser {
    
    int logout(String userid);
    
    ModelUser login(String userid, String passwd);
    
    // id 중복 확인시 사용되는 메서드
    int checkuserid(String userid);
    
    int updatePasswd(String userid, String currentPasswd, String newPasswd);

    List<ModelUser> selectUserList(ModelUser user);
    
    ModelUser selectUserOne(ModelUser user);
    
    int insertUser(ModelUser user);
    
    int updateUserInfo(ModelUser setValue, ModelUser whereValue);
    
    int updateRetire(ModelUser user);
}
