/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test for all methods smoothie class
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

public class SmoothieTestStudent {

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        double expectedPrice = 2.5 + 3 * 0.50 + 1.50; // Base price + fruits + protein
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Green Goodness", Size.LARGE, 2, false);
        String expectedString = "Smoothie{name='Green Goodness', size=LARGE, numOfFruits=2, addProtein=false, price=" + smoothie.calcPrice() + "}";
        assertEquals(expectedString, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Tropical Treat", Size.SMALL, 3, true);
        Smoothie smoothie2 = new Smoothie("Tropical Treat", Size.SMALL, 3, true);
        Smoothie smoothie3 = new Smoothie("Tropical Treat", Size.SMALL, 4, true);

        assertTrue(smoothie1.equals(smoothie2));
        assertFalse(smoothie1.equals(smoothie3));
    }

    @Test
    public void testGettersSetters() {
        Smoothie smoothie = new Smoothie("Berry Bonanza", Size.SMALL, 2, true);
        smoothie.setNumOfFruits(4);
        smoothie.setAddProtein(false);
        assertEquals(4, smoothie.getNumOfFruits());
        assertFalse(smoothie.isAddProtein());
    }
}