import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java22.junit.Student;

public class StudentTest {

    Student st = new Student();

    @Test
    public void gradeTest() {
        assertEquals("A", st.getgrade(100));
        
        st.setScore(90);
        assertEquals("A", st.getgrade(90));
        
        st.setScore(80);
        assertEquals("B", st.getgrade(80));
        
        st.setScore(70);
        assertEquals("C", st.getgrade(70));
        
        st.setScore(60);
        assertEquals("D", st.getgrade(60));

        st.setScore(50);
        assertEquals("F", st.getgrade(50));
    }

    @Test
    public void gradeAllTest() {
        for (int i = 0; i <= 100; i = i + 1) {
            if (i < 60) {
                assertEquals("F", st.getgrade(i));
            }
            else if (i < 70) {
                assertEquals("D", st.getgrade(i));
            }
            else if (i < 80) {
                assertEquals("C", st.getgrade(i));
            }
            else if (i < 90) {
                assertEquals("B", st.getgrade(i));
            }
            else {
                assertEquals("A", st.getgrade(i));
            }
        }
    }

}
