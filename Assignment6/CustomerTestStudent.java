/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test all methods in customer
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

public class CustomerTestStudent {

    @Test
    public void testConstructor() {
        Customer customer = new Customer("Ohno Bro", 30);
        assertEquals("Ohno Bro", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Heyguys itsaustin", 25);
        Customer copy = new Customer(original);
        assertEquals("Heyguys itsaustin", copy.getName());
        assertEquals(25, copy.getAge());
    }

    @Test
    public void testGettersSetters() {
        Customer customer = new Customer("Test", 20);
        customer.setName("New Name");
        customer.setAge(35);
        assertEquals("New Name", customer.getName());
        assertEquals(35, customer.getAge());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Alex Smith", 40);
        String expectedString = "Customer{name='Alex Smith', age=40}";
        assertEquals(expectedString, customer.toString());
    }
}