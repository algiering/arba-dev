package java14.st6manager;

public class Manager extends Employee {
    
    private int bonus = 0;
    
    public void test() {
        
        String info = "name: " + super.getName()+"\n";
        info = info + "address: " + super.getAddress()+"\n";
        info = info +"salary(direct): " + super.salary+"\n";
        info = info + "salary(getter): " + super.getSalary()+"\n";
        info = info + "rrn: " + super.getRrn()+"\n";
        
        System.out.println(info);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
    }

    public Manager(int bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }
}
