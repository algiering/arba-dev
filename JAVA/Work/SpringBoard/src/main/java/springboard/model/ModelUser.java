package springboard.model;

import java.sql.Date;

public class ModelUser {
    private Integer userno     = null;
    private String  userid     = null;
    private String  email      = null;
    private String  passwd     = null;
    private String  name       = null;
    private String  mobile     = null;
    private Boolean retireYN   = null;
    private String  InsertUID  = null;
    private Date    InsertDT   = null;
    private String  UpdateUID  = null;
    private Date    UpdateDT   = null;

    public Integer getUserno() {
        return userno;
    }

    public void setUserno(Integer userno) {
        this.userno = userno;
    }

    public Boolean getRetireYN() {
        return retireYN;
    }

    public void setRetireYN(Boolean retireYN) {
        this.retireYN = retireYN;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInsertUID() {
        return InsertUID;
    }

    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }

    public Date getInsertDT() {
        return InsertDT;
    }

    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }

    public String getUpdateUID() {
        return UpdateUID;
    }

    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }

    public Date getUpdateDT() {
        return UpdateDT;
    }

    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }

    @Override
    public String toString() {
        return "ModelUser [userno=" + userno + ", userid=" + userid + ", email=" + email + ", passwd=" + passwd
                + ", name=" + name + ", mobile=" + mobile + ", retireYN=" + retireYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }

    public ModelUser(Integer userno, String userid, String email, String passwd, String name, String mobile,
            Boolean retireYN, String insertUID, Date insertDT, String updateUID, Date updateDT) {
        super();
        this.userno = userno;
        this.userid = userid;
        this.email = email;
        this.passwd = passwd;
        this.name = name;
        this.mobile = mobile;
        this.retireYN = retireYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }

    public ModelUser() {
        super();
    }

}
