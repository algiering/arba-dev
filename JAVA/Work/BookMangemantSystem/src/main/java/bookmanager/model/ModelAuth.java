package bookmanager.model;

public class ModelAuth {
    
    private Integer authindex = null;
    private String  authid    = null;
    private String  authpswd  = null;
    private String  rrn       = null;
    private String  address   = null;
    private String  email     = null;
    private String  phonenum  = null;

    public Integer getAuthindex() {
        return authindex;
    }

    public void setAuthindex(Integer authindex) {
        this.authindex = authindex;
    }

    public String getAuthid() {
        return authid;
    }

    public void setAuthid(String authid) {
        this.authid = authid;
    }

    public String getAuthpswd() {
        return authpswd;
    }

    public void setAuthpswd(String authpswd) {
        this.authpswd = authpswd;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "ModelAuth [authindex=" + authindex + ", authid=" + authid + ", authpswd=" + authpswd + ", rrn=" + rrn
                + ", address=" + address + ", email=" + email + ", phonenum=" + phonenum + "]";
    }

    public ModelAuth(Integer authindex, String authid, String authpswd, String rrn, String address, String email,
            String phonenum) {
        super();
        this.authindex = authindex;
        this.authid = authid;
        this.authpswd = authpswd;
        this.rrn = rrn;
        this.address = address;
        this.email = email;
        this.phonenum = phonenum;
    }

    public ModelAuth() {
        super();
    }
}
