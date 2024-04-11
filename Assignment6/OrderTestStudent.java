/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test all methods in order
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class OrderTestStudent {

    private Order order;
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John Doe", 25);
        order = new Order(10, Day.MONDAY, customer);
    }

    @Test
    public void testAddNewBeverage() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        Beverage beverage = order.getBeverage(0);
        assertTrue(beverage instanceof Coffee);
        assertEquals("Espresso", beverage.getName());
        assertEquals(Size.SMALL, beverage.getSize());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        double total = order.calcOrderTotal();
        // Assuming Espresso costs $2 and Latte costs $3.5 (for example)
        assertEquals(5.5, total, 0.001);
    }

    @Test
    public void testGetters() {
        Customer expectedCustomer = order.getCustomer();
        assertEquals(customer.getName(), expectedCustomer.getName());
        assertEquals(customer.getAge(), expectedCustomer.getAge());
    }


    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        order.addNewBeverage("Mango Smoothie", Size.LARGE, 2, true);
        int coffeeCount = order.findNumOfBeveType(Type.COFFEE);
        int smoothieCount = order.findNumOfBeveType(Type.SMOOTHIE);
        assertEquals(2, coffeeCount);
        assertEquals(1, smoothieCount);
    }

   
}
