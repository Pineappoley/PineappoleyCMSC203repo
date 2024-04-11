/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: stores and outputs order info.
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
import java.util.List;

public class Order extends Object implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;
    private static int nextOrderSequence = 1; 
    private int sequenceNumber; 
    
    
    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNo = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust);
        this.beverages = new ArrayList<>();
        
        this.sequenceNumber = nextOrderSequence++;
        
        
    }

   
    public int generateOrder() {
        return (int) (Math.random() * (90000 - 10000)) + 10000;
    }

    
    public int getOrderNo() {
        return this.orderNo;
    }

   
    public int getOrderTime() {
        return this.orderTime;
    }

    
    public Day getOrderDay() {
        return this.orderDay;
    }

    
    public Customer getCustomer() {
        return new Customer(this.customer);
    }

    
    public Day getDay() {
        return this.orderDay;
    }

    @Override
    public boolean isWeekend() {
        return this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }
  
    
    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        // This is for Alcohol as per your interface
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        // This is for Coffee as per your interface
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        // This is for Smoothie as per your interface
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        return beverages.stream().mapToDouble(Beverage::calcPrice).sum();
    }
    

    @Override
    public int findNumOfBeveType(Type type) {
        return (int) beverages.stream().filter(b -> b.getType() == type).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderNo=").append(orderNo);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", orderDay=").append(orderDay);
        sb.append(", customer=").append(customer);
        sb.append(", beverages=").append(beverages);
        sb.append('}');
        sb.append("\nOrder total=").append(calcOrderTotal()).append("$");
        
        return sb.toString();
    }

    @Override
    public int compareTo(Order anotherOrder) {
        // Compare based on sequence number
        return Integer.compare(this.sequenceNumber, anotherOrder.sequenceNumber);
    }
}
