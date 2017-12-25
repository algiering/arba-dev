package personal;

public class Calc {
    
    private int firstNum = 0;
    private int secondNum = 0;
    
    int Add() {
        return firstNum+secondNum;
    }
    
    int Minus() {
        return firstNum-secondNum;
    }
    
    int Mul() {
        return firstNum*secondNum;
    }
    
    double Div() {
        return (double)firstNum/(double)secondNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public Calc() {
        super();
    }

    @Override
    public String toString() {
        return "Calc [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
    }
}
