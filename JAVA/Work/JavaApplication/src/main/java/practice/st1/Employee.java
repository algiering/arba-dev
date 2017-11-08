package practice.st1;

public class Employee {
    
    private String name = "";
    private String addr = "";
    private String rrn = "";
    
    protected int salary = 0;

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

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, String addr, String rrn, int salary) {
        super();
        this.name = name;
        this.addr = addr;
        this.rrn = rrn;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee [name=" + name + ", addr=" + addr + ", rrn=" + rrn + ", salary=" + salary + "]";
    }
    
}
