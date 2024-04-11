/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test for all methods coffee class
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

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice() {
        Coffee coffeeWithExtras = new Coffee("Espresso", Size.SMALL, true, true);
        Coffee regularCoffee = new Coffee("Americano", Size.SMALL, false, false);
       
        double expectedPriceWithExtras =  2.0 + 0.50 + 0.50; // Base price + extra shot + extra syrup
        double expectedRegularPrice = 2.0; // Base price only

        assertEquals(expectedPriceWithExtras, coffeeWithExtras.calcPrice(), 0.01);
        assertEquals(expectedRegularPrice, regularCoffee.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, false, true);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, false, true);
        Coffee coffee3 = new Coffee("Latte", Size.MEDIUM, true, true);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, true, false);
        String expectedString = "Coffee{name='Cappuccino', size=LARGE, extraShot=true, extraSyrup=false, price=" + coffee.calcPrice() + "}";
        assertEquals(expectedString, coffee.toString());
    }

    @Test
    public void testGettersSetters() {
        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, false, false);
        coffee.setExtraShot(true);
        coffee.setExtraSyrup(true);
        assertTrue(coffee.isExtraShot());
        assertTrue(coffee.isExtraSyrup());
    }
}