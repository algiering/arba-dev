package practice.st1;

public class Manager extends Employee {

    private int bonus = 0;

    public void test() {

        System.out.println("super name :" + getName());
        System.out.println("super addr :" + getAddr());
        System.out.println("super rrn :" + getRrn());
        System.out.println("super salary :" + getSalary());
        System.out.println("bonus : " + bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, String addr, String rrn, int salary, int bonus) {
        super(name, addr, rrn, salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
    }
}
