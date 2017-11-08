package java14.st5animal;

public class Dog extends Animal {
    
    private boolean bark;

    public boolean isBark() {
        return bark;
    }

    public void setBark(boolean bark) {
        this.bark = bark;
    }

    public Dog(boolean bark) {
        super();
        this.bark = bark;
    }

    public Dog(boolean sleep, boolean eat, boolean bark) {
        super(sleep, eat);
        this.bark = bark;
    }

    @Override
    public String toString() {
        return "Dog [bark=" + bark + ", toString()=" + super.toString() + "]";
    }
}
