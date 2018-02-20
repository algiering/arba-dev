package java16.st4anonyomous;

public class AnonymousTest {
    
    public static void main(String[] args) {

        // 클래스를 이용한 인스턴스 생성
        TV tv1 = new TV();
        
        // 인터페이스에 인스턴스 저장
        RemoteControl tv2 = new TV();
        
        // 무명 클래스 를 이용한 인스턴스 생성
        RemoteControl tv3 = new RemoteControl() {            
            @Override
            public void turnOn() {                
            }            
            @Override
            public void turnOff() {                
            }            
            @Override
            public void moveRight() {                
            }            
            @Override
            public void moveLeft() {                
            }
        };
        
    }
    
}
