package personal;

public class ps07 {
    
    public static void main(String[] args){
        
    
    int fahrenheit = 100;
    double celcius = ((double)5/9*(fahrenheit-32))
                     -(((double)5/9*(fahrenheit-32)));
    
    if(((double)celcius%0.01)>=0.05) celcius=(double)celcius-((double)celcius%0.01)+0.01;
    else if(((double)celcius%0.01<0.05)) celcius=(double)celcius-((double)celcius%0.01);
    
    System.out.println("Fahrenheit:"+fahrenheit);
    System.out.println("Celcius:"+(double)celcius);
    
    
    }
    
}
