package java07;

public class jv07_02_ArrayExam {    
    public static void main(String[] args) {
        // 배열의 선언
        int size = 6;
        int [] numbers = new int[size]; 
              
        // 배열에 값을 대입
        for (int j = 0; j < numbers.length; j++) {
            numbers[j] = j ;            
        }
 
        // for문을 사용하여 배열의 값 출력
        for (int j = 0; j < numbers.length; j++) {
            System.out.println( numbers[j]  );            
        }
    }    
}

