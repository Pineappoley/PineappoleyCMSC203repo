/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: manages order data and monitors conditions of beverages 
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class BevShop extends Object implements BevShopInterface {
    private ArrayList<Order> orders;

    public BevShop() {
        orders = new ArrayList<>();
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(time, day, customer);
        orders.add(newOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null; // Or throw an exception depending on your design
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        return orders.stream().mapToDouble(Order::calcOrderTotal).sum();
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null; // Or throw an exception
    }

    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        Order currentOrder = getCurrentOrder();
        if (currentOrder == null) {
            return false; // If there's no current order, then it's not eligible for more
        }

        int numOfAlcoholDrinks = currentOrder.findNumOfBeveType(Type.ALCOHOL);
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }
    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }
    @Override
    public int getNumOfAlcoholDrink() {
        int totalAlcoholDrinks = 0;
        for (Order order : orders) {
            totalAlcoholDrinks += order.findNumOfBeveType(Type.ALCOHOL);
        }
        return totalAlcoholDrinks;
    }

   
       

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Order order : orders) {
            result.append(order.toString()).append("\n");
        }
        result.append("Total Monthly Sale: ").append(totalMonthlySale());
        return result.toString();
    }
}
