package 전주하;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        for (int i = 0; i < employees.length; i = i + 1) {

            System.out.println((i + 1) + "번째");
            Manager mg = new Manager();
            System.out.print("이름 : ");
            mg.setName(key.next());
            System.out.print("주소 : ");
            mg.setAddr(key.next());
            System.out.print("급여 : ");
            mg.setSalary(key.nextInt());
            System.out.print("주민번호 : ");
            mg.setRrn(key.next());
            System.out.println();

            employees[i] = mg;
        }
        
        System.out.println("출력");

        for (int i = 0; i < employees.length; i = i + 1) {

            System.out.println((i + 1) + "번째");
            System.out.println("이름 : " + employees[i].getName());
            System.out.println("주소 : " + employees[i].getAddr());
            System.out.println("급여 : " + employees[i].getSalary());
            System.out.println("주민번호 : " + employees[i].getRrn());
            System.out.println();

        }
        key.close();
    }
}
