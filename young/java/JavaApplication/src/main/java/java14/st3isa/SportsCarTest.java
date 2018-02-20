package java14.st3isa;

public class SportsCarTest {
    
    public static void main(String[] args) {
        
        // setter를 이용한 필드 설정
        SportsCar c1  = new SportsCar();
        c1.setColor("white");
        c1.setGear(6);
        c1.setSpeed(250);
        c1.setTurbo(true);
             
        // 생성자를 이용한 필드 설정: turbo 설정   
        SportsCar c2  = new SportsCar( 300, 5, "green", true); 

        // 생성자를 이용한 초기화: turbo 설정
        SportsCar c3  = new SportsCar(true); 

        // 매개변수 color, turbo를 사용하는 생성자를 만드시오
        SportsCar c4  = new SportsCar("black", true);

        System.out.println( c1.toString() );
        System.out.println( c2.toString() );
        System.out.println( c3.toString() );
        System.out.println( c4.toString() );
    }
}
