package 전주하;

public class Manager extends Employee {

    private int bonus = 0;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }

    public Manager(int bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, String addr, int salary, String rrn, int bonus) {
        super(name, addr, salary, rrn);
        this.bonus = bonus;
    }

    public Manager(String name, String addr, int salary, String rrn) {
        super(name, addr, salary, rrn);
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
    }
}
