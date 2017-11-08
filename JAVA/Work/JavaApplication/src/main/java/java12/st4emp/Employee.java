package java12.st4emp;

public class Employee {
    
    private String name = "a";
    private double salary = 0;
    private static int count = 0;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static int getCount() {
        return count;
    }
    public Employee() {
        super();
        ++count;
    }
    
    @Override
    public String toString() {
        return "EmployeeTest [name=" + name + ", salary=" + salary + ", count=" + count + "]";
    }
    
}
