package bookservice.copy;

public class Status {

    private String bdate = "";
    private Boolean byn = false;

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public Boolean getByn() {
        return byn;
    }

    public void setByn(Boolean byn) {
        this.byn = byn;
    }

    public Status(String bdate, Boolean byn) {
        super();
        this.bdate = bdate;
        this.byn = byn;
    }

    public Status() {
        super();
    }

    @Override
    public String toString() {
        return "Status [bdate=" + bdate + ", byn=" + byn + "]";
    }

}
