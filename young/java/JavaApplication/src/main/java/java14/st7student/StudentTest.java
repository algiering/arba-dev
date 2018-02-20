package java14.st7student;

public class StudentTest {

    public static void main(String[] args) {
        
        // GraduateStudent 인스턴스 s1 생성하고
        // 필드에 값을 설정한 후 필드 값을 출력하시오.
        
        GraduateStudent s1 = new GraduateStudent();
        s1.setNumber(1);
        s1.setName("한");
        s1.setPhone("1111");
        s1.setLab("buck");
        
        // GraduateStudent 인스턴스 s2 생성하고
        // 필드 3개가 해당됨. setter를 이용하지 않고 필드에 값 설정이 가능하다.
        GraduateStudent s2 = new GraduateStudent();
        s2.name = "창";
        s2.phone = "0000";
        s2.lab = "실험맨";
        s2.setNumber(2);
        
        // GraduateStudent 인스턴스 s3를 생성자를 이용하여 필드에 값을 설정/출력
        GraduateStudent s3 = new GraduateStudent(3, "용","3333", "x-lab");
        
        
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
    
}
