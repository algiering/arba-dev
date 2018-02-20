package java20.st3studentmap;

import java.util.HashMap;
import java.util.Map;

public class TestStudent {    
    public static void main(String[] args) {
        // HashMap 인스턴스 생성
        Map< String, Student> map = new HashMap<>();
        
        // map에 추가
        // key      --> ( 이름 , 학번  )
        // 170101   --> new Student(170101, 구준표 );
        // 170102   --> new Student(170102, 금잔디 );
        // 170103   --> new Student(170103, 윤지후 );
        map.put( "170101",  new Student(170101, "구준표") );
        map.put( "170102",  new Student(170102, "금잔디") );
        map.put( "170103",  new Student(170103, "윤지후") );
        
        // entrySet와 foreach로 map 에 항목 출력.
        printMap(map);
        
        // 학번 170102 를 삭제.
        map.remove("170102");
        
        // "윤지후" 이름이  "윤후"로 개명.
        // 1. 새로운 인스턴, new Student(170103, "윤후")를 만들고 put. 새로운 메모리 저정.
        // 2. 기존값을 변경.
        Integer key = 0;
        for( Student s : map.values() ){
            if( s.getName().equals("윤지후") ) {
                key  =  s.getNumber() ;
                break;
            }
        }
        map.put( String.valueOf(key),  new Student(170103, "윤후") );

        // entrySet와 foreach로 map 에 항목 출력.
        printMap(map);         
    }

    public static void printMap(Map<String, Student> map) {
        System.out.print("학생 목록 출력 >> ");
        for ( Map.Entry<String, Student> e : map.entrySet() ) {
            int no = e.getValue().getNumber();
            String name = e.getValue().getName();
            System.out.format("(학번: %d, 이름:%s),", no , name );
        }
        System.out.println();
    }    
}
