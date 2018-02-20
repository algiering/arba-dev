package java14.st6manager;

public class Manager extends Employee {
    private int bounus = 0;
    
    // getter & setter
    public int getBounus() {
        return bounus;
    }

    public void setBounus(int bounus) {
        this.bounus = bounus;
    }
    
    // toString
    @Override
    public String toString() {
        return "Manager [bounus=" + bounus + ", salary=" + salary
                + ", toString()=" + super.toString() + "]";
    }
    
    // constructor
    public Manager() {
        super();
    }
    public Manager(int bounus) {
        super();
        this.bounus = bounus;
    }
    
    // method
    public void test(){        
       String info =  "name: " + super.getName() ;
       info = info + ", address:" + super.getAddress();
       info = info + ", salary:" + super.salary;
       info = info + ", rrn:" + super.getRrn();
       
       System.out.println( info );        
    }
    
}
