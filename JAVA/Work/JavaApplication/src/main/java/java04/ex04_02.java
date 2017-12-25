package java04;

public class ex04_02 {
    
    public static void main(String[] args){
        
        for (int i=1;i<10;i=i+1){
            
            int sum = 0;
            
            for (int j=1;j<=i;j=j+1){

                sum=sum+j;
            }

            System.out.println("1부터 "+i+" 까지의 합: "+sum);

        }
    }
}
