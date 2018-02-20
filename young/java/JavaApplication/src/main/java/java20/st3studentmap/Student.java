package java20.st3studentmap;

public class Student {
    private int number;
    private String name;
    
    // getter & setter
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // toString    
    @Override
    public String toString() {
        return "Student [number=" + number + ", name=" + name + "]";
    }
    
    // constructor
    public Student() {
        super();
    }
    public Student(int number, String name) {
        super();
        this.number = number;
        this.name = name;
    }  
    
    
}
