package 전주하;

public class Employee {

    private String name = "";
    private String addr = "";
    protected int salary = 0;
    private String rrn = "";

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public Employee() {
        super();
    }

    public Employee(String name, String addr, int salary, String rrn) {
        super();
        this.name = name;
        this.addr = addr;
        this.salary = salary;
        this.rrn = rrn;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", addr=" + addr + ", salary=" + salary + ", rrn=" + rrn + "]";
    }

}
