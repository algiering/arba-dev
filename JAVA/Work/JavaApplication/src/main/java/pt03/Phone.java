package pt03;

public class Phone {

    String name = "";
    String addr = "";
    String pn = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public Phone() {
        super();
    }

    public Phone(String name, String addr, String pn) {
        super();
        this.name = name;
        this.addr = addr;
        this.pn = pn;
    }

    @Override
    public String toString() {
        return "Phone [name=" + name + ", addr=" + addr + ", pn=" + pn + "]";
    }

}
