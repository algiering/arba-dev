package com.exam8.juha;

import java.util.List;

public interface IDaoPhone {
    
    ModelPhone getPhoneOne(String name);
    
    List<ModelPhone> getPhoneList(int start, int end);
    
    int getPhoneTotalRecord();
    
    int insertPhone(ModelPhone phone);
    
}
