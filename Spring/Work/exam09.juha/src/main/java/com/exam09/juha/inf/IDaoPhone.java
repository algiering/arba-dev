package com.exam09.juha.inf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exam09.juha.model.ModelPhone;

public interface IDaoPhone {
    
    List<ModelPhone> getPhoneList();
    
    int insertPhone(ModelPhone phone);

}
