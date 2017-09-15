package personal;

public class ps02 {
    
    public static void main(String[] args){
        
        int numOfApple = 123;
        int sizeOfBucket = 10;
        int numOfBucket = (numOfApple/sizeOfBucket);
        
        if ((numOfApple%sizeOfBucket) > 0) numOfBucket++;
        
        System.out.println("필요한 바구니의 수:"+numOfBucket);
        
    }
    
}
