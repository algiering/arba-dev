package java14.st5animal;

public class Cat extends Animal {
    
    private boolean play;

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public Cat(boolean play) {
        super();
        this.play = play;
    }

    public Cat(boolean sleep, boolean eat, boolean play) {
        super(sleep, eat);
        this.play = play;
    }

    @Override
    public String toString() {
        return "Cat [play=" + play + ", toString()=" + super.toString() + "]";
    }
}
