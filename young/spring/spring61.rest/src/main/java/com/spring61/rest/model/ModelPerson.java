package com.spring61.rest.model;

public class ModelPerson {
    
    private String id      = ""; 
    private String pw      = "";
    private String name    = ""; 
    private String email   = "";
    
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "ModelPerson [id=" + id + ", pw=" + pw + ", name=" + name
                + ", email=" + email + "]";
    }
    
    public ModelPerson() {
        super();
    }
    public ModelPerson(String id, String pw) {
        super();
        this.id = id;
        this.pw = pw;
    }
    public ModelPerson(String id, String pw, String name, String email) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        ModelPerson other = (ModelPerson) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pw == null) {
            if (other.pw != null)
                return false;
        } else if (!pw.equals(other.pw))
            return false;
        
        return true;
    }
    
}
