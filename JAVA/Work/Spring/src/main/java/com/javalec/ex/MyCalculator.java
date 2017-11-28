package com.javalec.ex;

public class MyCalculator {

    Calculator calculator = null;
    private int x = 0;
    private int y = 0;

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyCalculator [calculator=" + calculator + ", x=" + x + ", y=" + y + "]";
    }

    public MyCalculator() {
        super();
    }

    public void add() {
        calculator.add(x, y);
    }
    
    public void minus() {
        calculator.minus(x, y);
    }
    
    public void mul() {
        calculator.mul(x, y);
    }
    
    public void div() {
        calculator.div(x, y);
    }
}
