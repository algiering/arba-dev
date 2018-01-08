package com.spring65.phone.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring65.phone.inf.IDaoPhone;
import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

@Service("servicephone")
public class ServicePhone implements IServicePhone {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("daophone")
    private IDaoPhone daophone;

    public ServicePhone() {
        super();
    }

    @Override
    public ModelPhone getPhoneOne(String name) {
        ModelPhone result = null;

        try {
            result = daophone.getPhoneOne(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelPhone> getPhoneList() {
        List<ModelPhone> result = null;

        try {
            result = daophone.getPhoneList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int insertPhone(ModelPhone phone) {

        int result = -1;

        try {

            result = daophone.insertPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int insertPhoneList(List<ModelPhone> phones) {
        
        int result = -1;
        
        try {
            result = daophone.insertPhoneList(phones);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 0;
    }

}
