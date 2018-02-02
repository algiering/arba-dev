package com.testapp.juha.inf;

import java.util.List;

import com.testapp.juha.model.ModelUser;

public interface IDaoUser {
    
    int insertUser(ModelUser user);
    
    int login(ModelUser user);
    
    List<ModelUser> selectUserList(ModelUser user);
    
    int updateUserUse(ModelUser user);
    
    int updateUserInfo(ModelUser user);

}
