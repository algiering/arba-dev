package personal;

public class test2 {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};
        int sum = 0;
        
        for(int i=0; i<arr.length; i=i+1) {
            sum=sum+arr[i];
        }
        
        System.out.println("sum="+sum);
        
    }
}
