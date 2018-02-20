package com.spring63.mvc;

public class ModelLogin {
    private String id;
    private String pw;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    @Override
    public String toString() {
        return "ModelLogin [id=" + id + ", pw=" + pw + "]";
    }

    public ModelLogin() {
        super();
    }
    public ModelLogin(String id, String pw) {
        super();
        this.id = id;
        this.pw = pw;
    }
    
}
