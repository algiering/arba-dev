package java13.st5emp;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Employee[] emp = new Employee[3];

        for (int i = 0; i < emp.length; i=i+1) {
            
            emp[i] = new Employee();
            
            System.out.println((i+1)+"번째 직원 정보입력\n");
            
            System.out.print("이름 입력 : ");
            emp[i].setName(keyboard.next());
            System.out.print("주소 입력 : ");
            emp[i].setAdress(keyboard.next());
            System.out.print("월급 입력 : ");
            emp[i].setSalary(keyboard.nextInt());
            System.out.print("주민번호 입력 : ");
            emp[i].setRrn(keyboard.next());
            System.out.print("\n--------------------------\n\n");
            
        }

        System.out.print("조회할 직원번호 : ");
        int p = keyboard.nextInt()-1;

        System.out.println("직원번호 : " + (p+1));
        System.out.print("이름 : ");
        System.out.println(emp[p].getName());
        System.out.print("주소 : ");
        System.out.println(emp[p].getAdress());
        System.out.print("월급 : ");
        System.out.println(emp[p].getSalary());
        System.out.print("주민번호 : ");
        System.out.println(emp[p].getRrn());

        keyboard.close();
    }
}
