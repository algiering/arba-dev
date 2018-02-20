package java11.st4oper;

public class Oper {
    private int firstNum;
    private int secondNum;


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


    @Override
    public String toString() {
        return "Oper{" +
                "firstNum=" + firstNum +
                ", secondNum=" + secondNum +
                '}';
    }


    public Oper() {
    }

    public Oper(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    
    
    // �޼���
    public double Div() {
        double result = (double)this.firstNum / this.secondNum;
        return result;
    }

    public int Mul() {
        return this.firstNum * this.secondNum;
    }

    public int Minus() {
        return this.firstNum - this.secondNum;
    }

    public int Add() {
        return this.firstNum + this.secondNum;
    }
}
