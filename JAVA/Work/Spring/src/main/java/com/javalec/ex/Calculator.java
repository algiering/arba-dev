package com.javalec.ex;

public class Calculator {
    
    public void add(int x, int y) {
        System.out.println("add");
        int result = x + y;
        System.out.println(x + " + " + y + " = " + result);
    }
    
    public void minus(int x, int y) {
        System.out.println("minus");
        int result = x + y;
        System.out.println(x + " - " + y + " = " + result);
    }
    
    public void mul(int x, int y) {
        System.out.println("multi");
        int result = x + y;
        System.out.println(x + " * " + y + " = " + result);
    }
    
    public void div(int x, int y) {
        System.out.println("divide");
        int result = x + y;
        System.out.println(x + " / " + y + " = " + result);
    }

}
