package java19st3studentmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StudentTest {

    public static void main(String[] args) {
        
        Map<Integer, Student> sMap = new HashMap<>();
        
        sMap.put(170101, new Student(170101,"구준표"));
        sMap.put(170102, new Student(170102,"금잔디"));
        sMap.put(170103, new Student(170103,"윤지후"));
        
        
        entryPrint(sMap);
        
        sMap.remove(170102);
        
        
        int key = 0;
        for (Student s : sMap.values() ) {
            if( s.getName().equals("윤지후")){
                key = s.getNumber();
                break;
            }
        }
        sMap.put(key, new Student(170103, "윤후"));

//        sMap.put(170103, new Student(170103,"윤후"));
//       sMap.replace(170103, new Student(170103,"윤후"));
        
        entryPrint(sMap);
    }
    
    public static void entryPrint(Map<Integer, Student> m) {
        
        for (Entry<Integer, Student> elem : m.entrySet()) {

            System.out.println(String.format("학번 : %s, 이름 : %s",
                    elem.getValue().getNumber(), elem.getValue().getName()));

        }
        
    }

}
