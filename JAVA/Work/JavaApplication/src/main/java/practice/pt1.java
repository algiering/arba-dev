package practice;

import java.lang.String;
import java.util.Arrays;

public class pt1 {
    
    public static void main(String[] args) {
        
        String prov = "abc defg ijklm nop qrs wx yz";
        
        System.out.println(prov.length());
        System.out.println(prov.substring(4, 8));
        System.out.println(prov.replace("ijk", "*#$%^"));
        
        
        
        String numstr = "74 874 9883 93 9 73646 774";
        
        String[] numstrs = numstr.split(" ");
        
        
        for(int i=0;i<numstrs.length;i=i+1){
            
            numstrs[i].length();
        }
        
        Arrays.sort(numstrs);
        System.out.println(numstrs[0]);
        
        int sum = 0;
        double avg = 0;
        
        for(int i=0; i<numstrs.length;i=i+1) {
            
            sum = sum + Integer.valueOf(numstrs[i]);
            
        }
        
        avg = sum / numstrs.length;
        
        System.out.println("합:"+sum);
        System.out.println("평균:"+avg);
        
    }

}
