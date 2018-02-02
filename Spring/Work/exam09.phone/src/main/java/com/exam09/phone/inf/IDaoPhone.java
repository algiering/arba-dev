package com.exam09.phone.inf;

import java.util.List;

import com.exam09.phone.model.ModelPhone;

public interface IDaoPhone {
    
    List<ModelPhone> getPhoneList();
    
    int insertPhone(ModelPhone phone);

}
