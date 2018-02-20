package java08;

import java.util.Arrays;

public class ex08_03_String합계_평균_최대_최소 {

    public static void main(String[] args) {
		   
		String temp3 = "74 874 9883 73 9 73646 774";
		
        // a. 문자열 자르기 --> String 배열을 얻게 됨.
		String[] sArray = temp3.split( " " );
		
        // b. 문자열 배열을 정수 배열로 만든다. 
        //    이 때 for 문과 Integer.valueOf() 사용
		int [] iArray = new int[ sArray.length ];
		for( int i=0; i<=sArray.length -1; i=i+1){
		    // 문자열 배열에서 값을 꺼내서
		    String s = sArray[i];
		    
		    // 문자열을 정수로 형변환
		    int t = Integer.valueOf( s );
		    
		    // 형변환된 값을 정수 배열에 넣는다.
		    iArray[ i ] = t;		    
		}

        // c. 정수배열(intArray)를 오름차순 정렬하시오
		Arrays.sort( iArray );

        // d. 출력
		int sum = getsum( iArray) ; 
		double avg = getavg( sum, iArray.length );
		
        System.out.println( "합계 : " + sum ); 
        System.out.println( "평균 : " + avg  ); 
        System.out.println( "최소값 : " + iArray[0]  ); 
		System.out.println( "최대값 : " + iArray[iArray.length -1]  );		
    }
    
    public static int getsum( int[] array) {
        int sum = 0;
        for(int i=0; i<=array.length-1; i=i+1) {
            sum = sum + array[i];
        }
        return sum ;
    }
    
    public static double getavg( int sum, int count ) {
        
        return (double)sum / count ;
    }

}
