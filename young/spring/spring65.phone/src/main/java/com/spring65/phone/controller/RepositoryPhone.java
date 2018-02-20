package com.spring65.phone.controller;

import java.util.List;

import com.spring65.phone.model.ModelPhone;

public class RepositoryPhone {

    // 주의사항. 반드시 클라이언트의 배열명을 필드명으로 만들어야 한다.
    private List<ModelPhone> phoneItems;

    // getter & setter

    public List<ModelPhone> getPhoneItems() {
        return phoneItems;
    }

    public void setPhoneItems(List<ModelPhone> phoneItems) {
        this.phoneItems = phoneItems;
    }
    
    @Override
    public String toString() {
        return "RepositoryPhone [phones=" + phoneItems + "]";
    }

    public RepositoryPhone() {
        super();
    }

}
