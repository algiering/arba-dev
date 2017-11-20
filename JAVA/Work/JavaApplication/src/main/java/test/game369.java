package test;

public class game369 {

    public static void main(String[] args) {
        

        for (int i = 1; i < 1000; i = i + 1) {
            
            String x = String.valueOf(i);
            
            if(x.contains("3")||x.contains("6")||x.contains("9")){
                
            System.out.println(i+"박수 한번");
                
            }
        }
    }
}
