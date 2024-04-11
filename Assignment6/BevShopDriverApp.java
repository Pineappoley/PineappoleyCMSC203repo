/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Responsible for outputting interface prompts to console and user inputs
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to Bradley's Beverage Shop!");
            System.out.println("1. Start a new order");
            System.out.println("2. Display all orders");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
            	boolean validTime = false;
                int time = 0;
                while (!validTime) {
                    System.out.print("Enter time (8-23): ");
                    time = scanner.nextInt();
                    validTime = bevShop.isValidTime(time);
                    if (!validTime) {
                        System.out.println("Invalid time. Please try again.");
                    }
                }
                	System.out.print("Enter day (1=MONDAY, 2=TUESDAY, ... 7=SUNDAY): ");
                    int dayOrdinal = scanner.nextInt();
                    Day day = Day.values()[dayOrdinal - 1];
                    scanner.nextLine(); // consume the rest of the line
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Customer age: ");
                    int age = scanner.nextInt();

                    bevShop.startNewOrder(time, day, name, age);

                    boolean addingBeverages = true;
                    while (addingBeverages) {
                        System.out.println("1. Add Coffee");
                        System.out.println("2. Add Smoothie");
                        System.out.println("3. Add Alcohol");
                        System.out.println("4. Finish Order");
                        System.out.print("Choose an option: ");
                        int beverageOption = scanner.nextInt();

                        switch (beverageOption) {
                        case 1:
                            System.out.print("Enter coffee name: ");
                            scanner.nextLine(); // consume newline
                            String coffeeName = scanner.nextLine();
                            System.out.print("Enter size (1=SMALL, 2=MEDIUM, 3=LARGE): ");
                            int coffeeSizeOrdinal = scanner.nextInt();
                            Size coffeeSize = Size.values()[coffeeSizeOrdinal - 1];
                            System.out.print("Extra shot (true/false): ");
                            boolean extraShot = scanner.nextBoolean();
                            System.out.print("Extra syrup (true/false): ");
                            boolean extraSyrup = scanner.nextBoolean();
                            bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                            break;

                        case 2:
                            System.out.print("Enter smoothie name: ");
                            scanner.nextLine(); // consume newline
                            String smoothieName = scanner.nextLine();
                            System.out.print("Enter size (1=SMALL, 2=MEDIUM, 3=LARGE): ");
                            int smoothieSizeOrdinal = scanner.nextInt();
                            Size smoothieSize = Size.values()[smoothieSizeOrdinal - 1];
                            System.out.print("Number of fruits: ");
                            int numOfFruits = scanner.nextInt();

                            if (numOfFruits > bevShop.getMaxNumOfFruits()) {
                                System.out.println("The number of fruits exceeds the maximum limit of " + bevShop.getMaxNumOfFruits());
                                break;
                            }

                            System.out.print("Add protein (true/false): ");
                            boolean addProtein = scanner.nextBoolean();
                            bevShop.processSmoothieOrder(smoothieName, smoothieSize, numOfFruits, addProtein);
                            break;


                        case 3:
                            Order currentOrder = bevShop.getCurrentOrder();
                            if (currentOrder != null && currentOrder.getCustomer().getAge() >= bevShop.getMinAgeForAlcohol()) {
                                System.out.print("Enter alcohol name: ");
                                scanner.nextLine(); // consume newline
                                String alcoholName = scanner.nextLine();
                                System.out.print("Enter size (1=SMALL, 2=MEDIUM, 3=LARGE): ");
                                int alcoholSizeOrdinal = scanner.nextInt();
                                Size alcoholSize = Size.values()[alcoholSizeOrdinal - 1];

                                bevShop.processAlcoholOrder(alcoholName, alcoholSize);
                            } else {
                                System.out.println("Alcohol cannot be purchased. Customer is below the minimum age.");
                            }
                            break;


                            case 4:
                                addingBeverages = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }

               
            
                }
                 else if (option == 2) {
                // Display all orders
                for (int i = 0; i < bevShop.totalNumOfMonthlyOrders(); i++) {
                    Order order = bevShop.getOrderAtIndex(i);
                    System.out.println(order);
                    
                }
                System.out.println("Total Monthly Sales: " + bevShop.totalMonthlySale() + "$");
            } 
                 else if (option == 3) {
                // Exit
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
