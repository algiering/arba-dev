package java24.jdbc;

import java.sql.Date;

public class ModelAuth {
    
    private Integer authid = null;
    private String name = "";
    private Date birth = null;

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ModelAuth [authid=" + authid + ", name=" + name + ", birth=" + birth + "]";
    }

    public ModelAuth(Integer authid, String name, Date birth) {
        super();
        this.authid = authid;
        this.name = name;
        this.birth = birth;
    }

    public ModelAuth() {
        super();
    }
}
