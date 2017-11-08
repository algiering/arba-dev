package java14.st11elec;

import java14.st11elec.Computer;
import java14.st11elec.Desktop;
import java14.st11elec.Electronics;
import java14.st11elec.Notebook;
import java14.st11elec.Tablet;
import java14.st11elec.Television;

public class ElectronicsTest {
    
    public static void main(String[] args) {
        
        System.out.println("[ Desktop ]");
        Desktop desktop1 = new Desktop();
        
        System.out.println();
        
        System.out.println("[ Tablet]");
        Tablet tablet1 = new Tablet();
        
        System.out.println();
        
        System.out.println("[ Notebook ]");
        Notebook notebook1 = new Notebook();

        System.out.println();
        
        System.out.println("[ Computer ]");
        Computer computer1 = new Computer();
        
        System.out.println();
        
        System.out.println("[ Television ]");
        Television television1 = new Television();
        
        System.out.println();
        
        System.out.println("[ Electronics ]");
        Electronics electronics = new Electronics();
    }

}
