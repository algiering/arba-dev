package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestEmployee {
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Test
    public void test_make_instance_with_new() {
    
        // Emplyoee 인스턴스 emp 만들고
        // 세터를 이용해 필드에  값을 설정하시오.        
        di01.reflection.Employee emp1 = new di01.reflection.Employee();
        emp1.setAddress("emp1 address");
        emp1.setName("emp1 name");
        emp1.setRrn("emp1rrn");
        emp1.setSalary( 10000 );
        assertEquals("emp1 address", emp1.getAddress()  );
   
        // 생성자를 이용해 Emplyoee 인스턴스 emp2 만들시오.
        // 필드에 값을 설정하시오.
        di01.reflection.Employee emp2 = new di01.reflection.Employee("emp2 name", "emp2 address", 1000, "emp2 rrn");
        assertEquals("emp2 address", emp2.getAddress()  );
    }
    

    @Test
    public void test_make_instance_with_reflection() throws ClassNotFoundException, 
                                                            NoSuchMethodException,  SecurityException, 
                                                            InstantiationException, IllegalAccessException, 
                                                            IllegalArgumentException, InvocationTargetException {
    
        /*
         *  reflection을 이용해서 인스턴스 만들기.
         *  reflection으로 new di01.reflection.Employee("emp2 name", "emp2 address", 1000, "emp2 rrn")
         */ 
        Class klass = Class.forName("di01.reflection.Employee"); // class 로딩
        
        // 생성자 메서드의 매개변수 타입 선언.
        Class [] paramTypes = { String.class, String.class  , int.class, String.class };
        
        // 매개변수 값 설정.
        Object[] objs      = { "emp2 name"  , "emp2 address", 1000         , "emp2 rrn"   };
        
        // 생성자 메서드 가져오기.
        java.lang.reflect.Constructor cons = klass.getConstructor( paramTypes );
        
        // 인스턴스 만들기.
        Object instance = cons.newInstance( objs );
        
        // 실행해서 결과 출력
        System.out.println( instance.toString() );
        assertEquals("emp2 address", ((di01.reflection.Employee)instance).getAddress()  );
        
        /*
         * setter를 이용하여 필드값 바꾸기
         */
        java.lang.reflect.Method m = klass.getMethod("setName", String.class);
        
        // 매개변수 값 설정
        Object [] params = {"hello"};
        
        // 메서드 호출
        m.invoke(instance, params);  // Employee.setName("hello");  가 실행됨.
        
        // 검증
        assertEquals("hello", ((di01.reflection.Employee)instance).getName()  );
        
        // 실행해서 결과 출력
        System.out.println( instance.toString() );
        

        /*
         * getter를 이용하여 필드값 가져오기.
         */
        m = klass.getMethod("getName" ); // 매개변수가 없어서...
        Object result = m.invoke(instance);

        // 검증
        assertEquals("hello", result  );
    }
    
}
