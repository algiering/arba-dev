package java14.st5animal;

public class Animal {

    private boolean sleep;
    private boolean eat;

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public Animal(boolean sleep, boolean eat) {
        super();
        this.sleep = sleep;
        this.eat = eat;
    }

    public Animal() {
        super();
    }

    @Override
    public String toString() {
        return "Animal [sleep=" + sleep + ", eat=" + eat + "]";
    }
}
