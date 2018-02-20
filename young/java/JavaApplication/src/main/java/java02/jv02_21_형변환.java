package java02;

public class jv02_21_형변환 {
    
    public static void main(String[] args) {

        int i = 43;
        
        // int --> double 변환 
        double d = (double) i; System.out.println(d);      

        // int --> char 변환
        char c = (char) i;  System.out.println(c);
        

        // int --> boolean 변환
        boolean b = (i != 0); System.out.println(b);
        
        
        // int --> 문자열로 변환
        String s =  Integer.toString( i ); System.out.println(s);                
    }
    
}
