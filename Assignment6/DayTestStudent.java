/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test for all values in day enum
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.EnumSet;

public class DayTestStudent {

    @Test
    public void testEnumValues() {
        assertTrue(EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY).equals(EnumSet.allOf(Day.class)));
    }

    @Test
    public void testEnumCount() {
        assertEquals(7, Day.values().length);
    }
}
