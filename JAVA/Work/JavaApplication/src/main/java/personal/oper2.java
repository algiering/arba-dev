package personal;

public class oper2 {

    private static int firstNum = 0;
    private static int secondNum = 0;

    static int Add() {
        return (firstNum + secondNum);
    }

    static int Minus() {
        return (firstNum - secondNum);
    }

    static int Mul() {
        return (firstNum * secondNum);
    }

    static double Div() {
        double a = (double) firstNum;
        double b = (double) secondNum;
        return (a / b);
    }

    public static int getFirstNum() {
        return firstNum;
    }

    public static void setFirstNum(int firstNum) {
        oper2.firstNum = firstNum;
    }

    public static int getSecondNum() {
        return secondNum;
    }

    public static void setSecondNum(int secondNum) {
        oper2.secondNum = secondNum;
    }

}
