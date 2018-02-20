package java07;

public class jv07_05_foreach {
    
    public static void main(String[] args) {
        
        // 배열의 선언 & 초기화
        int [] numbers = {10,20,30,40,50, 60};
          
        // for문을 사용하여 배열의 값 출력
        for (int j = 0; j <= numbers.length-1; j=j+1) {
            System.out.println( numbers[j]  );            
        }
        
        // foreach를 이용하여 배열에 값을 출력
        for (int value : numbers) {
            System.out.println( value );
        }
    }
}
