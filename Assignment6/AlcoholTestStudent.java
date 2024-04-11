/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test for all methods alcohol class
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

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice() {
        Alcohol weekdayAlcohol = new Alcohol("Whiskey", Size.SMALL, false);
        Alcohol weekendAlcohol = new Alcohol("Whiskey", Size.SMALL, true);
       
        double expectedWeekdayPrice = 2.0; // Base price
        double expectedWeekendPrice = 2.0 + 0.60; // Base price + weekend surcharge

        assertEquals(expectedWeekdayPrice, weekdayAlcohol.calcPrice(), 0.01);
        assertEquals(expectedWeekendPrice, weekendAlcohol.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Alcohol alcohol1 = new Alcohol("Vodka", Size.LARGE, true);
        Alcohol alcohol2 = new Alcohol("Vodka", Size.LARGE, true);
        Alcohol alcohol3 = new Alcohol("Vodka", Size.LARGE, false);

        assertTrue(alcohol1.equals(alcohol2));
        assertFalse(alcohol1.equals(alcohol3));
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Gin", Size.MEDIUM, false);
        String expectedString = "Alcohol{name='Gin', size=MEDIUM, isWeekend=false, price=" + alcohol.calcPrice() + "}";
        assertEquals(expectedString, alcohol.toString());
    }

    @Test
    public void testIsWeekend() {
        Alcohol alcohol = new Alcohol("Rum", Size.LARGE, true);
        assertTrue(alcohol.isWeekend());
    }
}