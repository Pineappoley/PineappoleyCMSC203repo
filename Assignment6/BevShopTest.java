/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: test all bevshop methods
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

public class BevShopTest {

    private BevShop bevShop;

    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        assertNotNull("BevShop should have an active order after starting a new one", bevShop.getCurrentOrder());
        assertEquals("Number of orders should be 1 after starting first order", 1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(11, Day.TUESDAY, "Bob", 10);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals("Current order should have 1 beverage after adding coffee", 1, currentOrder.getTotalItems());
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(11, Day.WEDNESDAY, "Snob", 20);
        bevShop.processAlcoholOrder("MOHITO", Size.LARGE);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals("Current order should have 1 beverage after adding Alcohol", 1, currentOrder.getTotalItems());
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(11, Day.THURSDAY, "Rob", 30);
        bevShop.processSmoothieOrder("Espresso", Size.MEDIUM, 3, false);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals("Current order should have 1 beverage after adding Smoothie", 1, currentOrder.getTotalItems());
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.WEDNESDAY, "Charlie", 22);
        bevShop.processCoffeeOrder("Latte", Size.LARGE, false, true);
        double totalSale = bevShop.totalMonthlySale();
        assertTrue("Total monthly sale should be greater than 0 after processing orders", totalSale > 0);
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        int index = bevShop.findOrder(orderNo);
        assertEquals("The index of the found order should be 0", 0, index);
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        double expectedPrice = bevShop.totalOrderPrice(orderNo);
        assertEquals("The total order price should match the expected price", expectedPrice, bevShop.totalOrderPrice(orderNo), 0.001);
    }

    @Test
    public void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.startNewOrder(11, Day.TUESDAY, "Bob", 30);
        Order order1 = bevShop.getOrderAtIndex(0);
        Order order2 = bevShop.getOrderAtIndex(1);
        assertNotNull("The order at index 0 should not be null", order1);
        assertNotNull("The order at index 1 should not be null", order2);
        assertEquals("The customer name of the first order should be Alice", "Alice", order1.getCustomer().getName());
        assertEquals("The customer name of the second order should be Bob", "Bob", order2.getCustomer().getName());
    }

    @Test
    public void testSortOrders() {
    	bevShop.startNewOrder(12, Day.TUESDAY, "Bob", 30);
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.sortOrders();
        Order order1 = bevShop.getOrderAtIndex(0);
        Order order2 = bevShop.getOrderAtIndex(1);
        assertEquals("The order time of the first order should be 12", 12, order1.getOrderTime());
        assertEquals("The order time of the second order should be 10", 10, order2.getOrderTime());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        int minAge = bevShop.getMinAgeForAlcohol();
        assertEquals("The minimum age for alcohol should be 21", 21, minAge);
    }

    @Test
    public void testGetMaxNumOfFruits() {
        int maxFruits = bevShop.getMaxNumOfFruits();
        assertEquals("The maximum number of fruits should be 5", 5, maxFruits);
    }

    @Test
    public void testIsMaxFruit() {
        boolean isMax = bevShop.isMaxFruit(6);
        assertTrue("The number 6 should be considered as max fruits", isMax);
        isMax = bevShop.isMaxFruit(4);
        assertFalse("The number 4 should not be considered as max fruits", isMax);
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        int maxOrders = bevShop.getMaxOrderForAlcohol();
        assertEquals("The maximum number of alcohol orders should be 3", 3, maxOrders);
    }

    @Test
    public void testIsEligibleForMore() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.processAlcoholOrder("Beer1", Size.LARGE);
        bevShop.processAlcoholOrder("Beer2", Size.LARGE);
        bevShop.processAlcoholOrder("Beer3", Size.LARGE);
        assertFalse("The current order should not be eligible for more alcohol", bevShop.isEligibleForMore());
        bevShop.startNewOrder(11, Day.TUESDAY, "Bob", 30);
        bevShop.processAlcoholOrder("Ber2.0", Size.LARGE);
        assertTrue("The current order should be eligible for more alcohol", bevShop.isEligibleForMore());
    }

    @Test
    public void testIsValidAge() {
        assertTrue("Age 21 should be considered a valid age for alcohol", bevShop.isValidAge(21));
        assertFalse("Age 20 should not be considered a valid age for alcohol", bevShop.isValidAge(20));
    }

    @Test
    public void testIsValidTime() {
        assertTrue("Time 10 should be considered a valid time", bevShop.isValidTime(10));
        assertFalse("Time 5 should not be considered a valid time", bevShop.isValidTime(5));
        assertTrue("Time 23 should be considered a valid time", bevShop.isValidTime(23));
        assertFalse("Time 24 should not be considered a valid time", bevShop.isValidTime(24));
    }

    @Test
    public void testGetNumOfAlcoholDrink() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        bevShop.startNewOrder(11, Day.TUESDAY, "Bob", 30);
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        bevShop.processAlcoholOrder("Wine", Size.SMALL);
        int numAlcoholDrinks = bevShop.getNumOfAlcoholDrink();
        assertEquals("The number of alcohol drinks should be 2", 2, numAlcoholDrinks);
    }

    @Test
    public void testToString() {
        bevShop.startNewOrder(8, Day.MONDAY, "dylan", 18);
        bevShop.processCoffeeOrder("cofee", Size.MEDIUM, true, false);
        bevShop.processSmoothieOrder("fart", Size.SMALL, 2, true);
        Order order = bevShop.getCurrentOrder();

        String expected = "Order{orderNo=" + order.getOrderNo() + ", orderTime=8, orderDay=MONDAY, customer=Customer{name='dylan', age=18}, beverages=[";
        expected += "Coffee{name='cofee', size=MEDIUM, extraShot=true, extraSyrup=false, price=3.0}, ";
        expected += "Smoothie{name='fart', size=SMALL, numOfFruits=2, addProtein=true, price=4.5}]}";

        String actual = bevShop.toString();
        assertTrue("The toString() output should match the expected output", actual.contains(expected));
    }
}