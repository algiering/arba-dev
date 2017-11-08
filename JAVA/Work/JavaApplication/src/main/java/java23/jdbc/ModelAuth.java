package java23.jdbc;

public class ModelAuth {
    private Integer authid = null;
    private String  name   = "";
    private String  rrn    = "";
    private String  pnum   = "";
    private String  mail   = "";

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

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "ModelAuth [authid=" + authid + ", name=" + name + ", rrn=" + rrn + ", pnum=" + pnum + ", mail=" + mail
                + "]";
    }

    public ModelAuth(Integer authid, String name, String rrn, String pnum, String mail) {
        super();
        this.authid = authid;
        this.name = name;
        this.rrn = rrn;
        this.pnum = pnum;
        this.mail = mail;
    }

    public ModelAuth() {
        super();
    }

}
