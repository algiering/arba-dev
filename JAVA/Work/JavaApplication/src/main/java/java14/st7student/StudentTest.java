package java14.st7student;

import java.util.Scanner;

public class StudentTest {
    
    public static void main(String[] args) {
        
        int counter = 0;
        
        Scanner key = new Scanner(System.in);
        GraduateStudent gs1 = new GraduateStudent();
        
        System.out.print("이름 입력 :");
        gs1.name = key.next();
        System.out.print("학번 입력 :");
        gs1.setNumber(key.nextInt());
        System.out.print("핸드폰 번호 입력 :");
        gs1.phone = key.next();
        System.out.print("연구소 입력 :");
        gs1.lab = key.next();

        System.out.println(gs1.toString());
        System.out.println();
        System.out.println(
                "이름 : " + gs1.name + "\n" +
                "학번 : " + gs1.getNumber() + "\n" +
                "핸드폰 번호 : "+ gs1.phone + "\n" +
                "연구소 :" + gs1.lab
                );
        
        System.out.println();

        GraduateStudent gs2 = new GraduateStudent();
        
        System.out.print("이름 입력 :");
        gs2.setName(key.next());
        System.out.print("학번 입력 :");
        gs2.setNumber(key.nextInt());
        System.out.print("핸드폰 번호 입력 :");
        gs2.setPhone(key.next());
        System.out.print("연구소 입력 :");
        gs2.setLab(key.next());

        System.out.println(gs2.toString());
        System.out.println();
        System.out.println(
                "이름 : " + gs2.getName() + "\n" +
                "학번 : " + gs2.getNumber() + "\n" +
                "핸드폰 번호 : "+ gs2.getPhone() + "\n" +
                "연구소 :" + gs2.getLab()
                );
        
GraduateStudent gs3 = new GraduateStudent(333, "333", "333", "333");
        
        System.out.println(gs3.toString());
        System.out.println();
        System.out.println(
                "이름 : " + gs3.getName() + "\n" +
                "학번 : " + gs3.getNumber() + "\n" +
                "핸드폰 번호 : "+ gs3.getPhone() + "\n" +
                "연구소 :" + gs3.getLab()
                );
        
        System.out.println();
        
        key.close();
    }

}
