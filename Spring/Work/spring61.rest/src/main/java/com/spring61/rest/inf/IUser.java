package com.spring61.rest.inf;

import java.util.List;

import com.spring61.rest.model.ModelUser;

public interface IUser {
    
    int insertUser(ModelUser user) throws Exception;
    
    ModelUser login(String userid, String passwd) throws Exception;
    
    int logout(String userid) throws Exception;
    
    int updateUserInfo(ModelUser updateValue, ModelUser searchValue) throws Exception;
    
    int updatePasswd(String userid, String currentPasswd, String newPasswd) throws Exception;
    
    int deleteUser(ModelUser user) throws Exception;
    
    ModelUser selectUserOne(ModelUser user) throws Exception;
    
    List<ModelUser> selectUserList(ModelUser user) throws Exception;
    
    int checkuserid(String userid) throws Exception;
}
