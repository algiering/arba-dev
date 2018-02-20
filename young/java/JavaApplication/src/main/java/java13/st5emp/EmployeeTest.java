package java13.st5emp;

import java.util.Scanner;

public class EmployeeTest {
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = keyboard.next(); // 문자열 입력

        System.out.print("주소를 입력하세요 : ");
        String addr = keyboard.next(); // 문자열 입력

        System.out.print("월급을 입력하세요 : ");
        int    sal = keyboard.nextInt(); // 정수 입력

        System.out.print("주민번호를 입력하세요 : ");
        String rrn = keyboard.next();    // 문자열 입력

        // 필드에 값 넣기. setter를 이용하는 방법.
        Employee emp0 = new Employee();
        emp0.setName( name );
        emp0.setAddress( addr );
        emp0.setSalary( sal );
        emp0.setRrn( rrn );


        // 필드에 값 넣기. 생성자를 이용하는 방법.
        Employee emp1 = new Employee(name, addr, sal, rrn);

        // 필드 정보 출력. getter를 이용하는 방법
        System.out.println( emp0.getName()    );
        System.out.println( emp0.getAddress() );
        System.out.println( emp0.getSalary()  );
        System.out.println( emp0.getRrn()     );

        // 필드 정보 출력. toString을 이용하는 방법
        System.out.println( emp0.toString() );

    }    
}
