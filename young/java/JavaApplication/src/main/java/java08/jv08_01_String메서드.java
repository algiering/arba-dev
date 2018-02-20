package java08;

public class jv08_01_String메서드 {
    
    public static void main(String[] args) {
        
        // 0번째부터 12번째 자리까지 있음.
        // prov 길이는 13이다.
        String prov = "A barking Dog";
                
        // 문자열 길이: length() . 13이 출력
        int length = prov.length();
        System.out.println( length );
        
        // 문자열 추출 : substring()
        // (2번째부터 4번째 자리까지 추출:  bar)
        String bar = prov.substring(2, 5);
        System.out.println(  "문자열 추출 : " + bar );

        // 문제. Dog 를 추출하여 출력하시오
        String dog = prov.substring(10, 13);
        System.out.println(  "문자열 추출 : " + dog );
        

        // 문자열 추출 : substring()
        // "A barking dog"에서 마지막 g 빼고 "A barking do" 를 출력하시오.
        String s01 = prov.substring(0, prov.length()-1 );
        System.out.println( "문자열 추출 : " + s01 ); // A barking do 출력
            
        // 한개 문자 추출 
        // substring() --> 문자열 반환: 
        // charAt()    --> 문자 한개 반환:
        // 첫번째 b 를 추출하시오. substring 이용
        String s02 = prov.substring(2, 3);  // b 반환
        System.out.println( "한개 문자 추출 substring() 사용 : " + s02 );

        // charAt 이용하여 첫번째 b 문자를 추출하시오.
        char   ch1 = prov.charAt(2);  // b 반환
        System.out.println( "한개 문자 추출 charAt()    사용 : " + ch1 );



        // 문자열 결합 : +
        // "A barking Dog never Bites!"를 출력하시오.
        String s03 = " never Bites";
        String s04 = prov + s03;
        System.out.println( "문자열 결합: " + s04 ); // A barking Dog never Bites! 출력
        
        
        // 빈 문자열 확인 : isEmpty()
        String s06 = "";
        boolean empty = s06.isEmpty();
        System.out.println( "빈 문자열 확인: " + empty );
        
        s06= "a";
        empty = s06.isEmpty();
        System.out.println( empty );
        
        
        // 문자열 포함 여부 확인: contains()
        boolean contains  = prov.contains("Dog");
        if( contains ) {
            System.out.println("Dog 가 들어 있음");
        }
        else {
            System.out.println("Dog 없음");
        }
        
                
        // 문자열 치환 : replace()
        // Dog --> Cat 으로 바꾸시오
        String s07 = prov.replace("Dog", "Cat");
        System.out.println( s07 );

        
        // prov 문자열에 Dog가 들어 있으면 Cat으로 바꾸어 출력하고
        //                     아니면 prov 출력하시오.
        if( prov.contains("Dog") ) {
            s07 = prov.replace("Dog", "Cat");
            System.out.println( s07 );            
        }
        else {
            System.out.println( prov ); 
        }
        

        // 문자열 치환 : replaceAll(). 정규표현식을 사용한 패턴 치환
        // 정규 표현식: ^ --> 시작
        //              $ --> 끝
        //              []
        String s08 = "abc ab bcd";
        String s09 = s08.replaceAll("^a", "b");
        System.out.println( "문자열 치환 : replaceAll() : " + s09 );

        String s10 = s08.replaceAll("d$", "10");
        System.out.println( "문자열 치환 : replaceAll() : " + s10 );

        s10 = s08.replaceAll("[ab]", "");
        System.out.println( "문자열 치환 : replaceAll() : " + s10 );

        s10 = s08.replace("ab", "");
        System.out.println( "문자열 치환 : replace() : " + s10 );
        
        s08 = s08.replaceAll("\\p{Space}", "-");
        System.out.println( "문자열 치환 replaceAll() : " + s08 ); // AB-CD
        
        s08 = s08.replace("-", "+");
        System.out.println( "문자열 치환 replace() : " + s08 ); // AB-CD

        // 문자열 자르기: split()은 배열로 돌려준다.
        // 지정한 문자로 문자열을 나눈다.(배열로 반환)
        // 문자열 prov 를 공백을 기준으로 자르고 결과를 출력하시오.
        String[] arr = prov.split(" ");
        for( int i=0; i<= arr.length -1; i=i+1){
            System.out.print(arr[i] + ", ");
        }
        

        // 문자열 비교 : equal()
        s09 = "abcde";
        s10 = "abcde";
        if( s09.equals( s10 ) ) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
        
        if( s09 == s10 ) {
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
               
        // String.format() 사용법
        // %s : 문자열
        // %d : 정수
        // %f : 부동소수점
        // %c : 문자한개
        // %tc: 날짜와 시간 전부 표시
        // %tr: 시간만 표시할때
        // %A %B %C 요일,월,일 표시        
                
        // 날짜 출력 포맷 지정 하기: SimpleDateFormat 클래스 사용
        
    }
    
}
