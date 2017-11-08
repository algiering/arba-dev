package bookservice.copy;

public class Customer{

    private int cnum = 0;

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    private String cname = "";
    private String crrn = "";
    private String cpnum = "";
    private String cemail = "";

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCrrn() {
        return crrn;
    }

    public Customer(int cnum, String cname, String crrn, String cpnum, String cemail) {
        super();
        this.cnum = cnum;
        this.cname = cname;
        this.crrn = crrn;
        this.cpnum = cpnum;
        this.cemail = cemail;
    }

    public void setCrrn(String crrn) {
        this.crrn = crrn;
    }

    public String getCpnum() {
        return cpnum;
    }

    public void setCpnum(String cpnum) {
        this.cpnum = cpnum;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Costomer [cnum=" + cnum + ", cname=" + cname + ", crrn=" + crrn + ", cpnum=" + cpnum + ", cemail="
                + cemail + "]";
    }

}
