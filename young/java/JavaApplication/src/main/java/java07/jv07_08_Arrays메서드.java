package java07;

import java.util.Arrays;

public class jv07_08_Arrays메서드 {
    
    public static void main(String[] args) {
        
        // Arrays 클래스는 배열의 정렬, 비교, 검색 등의 기능을 제공한다.
        // Arrays 클래스의 모든 메소드는 static이다. 
        // Arrays 클래스는 Math 클래스와 같이 인스턴스가 될 수 없다.
        
        // Arrays 는 배열을 위한 유용한 메소드
        // 검색: binarySearch
        // 정렬: sort
        // 초기화: fill
        // 비교: equals
        
        // 배열 만들기
        int size = 6;
        int [] array = new int[size];  
        
        // for문을 이용한 배열 초기화
        for(int i=0; i<= array.length-1; i=i+1){
            array[i] = array.length - i;
        }
        printArray(array );
        
        // Arrays 정렬 & printArray() 호출
        //java.util.Arrays.sort( array );
        Arrays.sort( array );
        printArray(array );
        
        // Arrays 검색 & printArray() 호출
        int val = java.util.Arrays.binarySearch(array, 4);
        System.out.println("4값의 위치 " + val );
        
        // Arrays 초기화 & printArray() 호출
        Arrays.fill(array, -1);
        printArray(array );        
    }
    
    // 배열의 값을 출력하는 메서드 만들기
    // 메서드명 : printArray
    // 메서드 타입: void
    // 매개변수 : 정수 배열
    public static void printArray( int[] x ) {

        for( int i = 0; i <= x.length-1 ; i=i+1 ) {
            System.out.print( x[i] + ", " );
        }

        System.out.println( );
        
        return ;
    }
    
}
