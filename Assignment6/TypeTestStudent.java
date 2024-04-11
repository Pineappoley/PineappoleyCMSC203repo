/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test for all values in type enum
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

public class TypeTestStudent {

    @Test
    public void testEnumValues() {
        assertTrue(EnumSet.of(Type.COFFEE, Type.SMOOTHIE, Type.ALCOHOL).equals(EnumSet.allOf(Type.class)));
    }

    @Test
    public void testEnumCount() {
        assertEquals(3, Type.values().length);
    }
}
