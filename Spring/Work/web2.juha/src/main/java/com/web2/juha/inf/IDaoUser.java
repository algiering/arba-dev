package com.web2.juha.inf;

import com.web2.juha.model.ModelUser;

public interface IDaoUser {
    
    ModelUser getUserOne(ModelUser user);
    
    int getCheckUserExist(String user_id);
    
    int insertUserOne(ModelUser user);
    
    int updateUserOne(ModelUser user);

}
