package assignment1;

import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    // Student Information variables
    static String name;
    static String mNum;
    static String userDescription;
    static String dueDate;

    // Color information variables
    static final String RED = "Red";
    static final String ORANGE = "Orange";
    static final String YELLOW = "Yellow";
    static final String GREEN = "Green";
    static final String BLUE = "Blue";
    static final String PURPLE = "Purple";
    static final String PINK = "Pink";
    static int userScore = 0;

    public static void main(String[] args) {
        Scanner varInput = new Scanner(System.in);
        Random rand = new Random();

        // Output student info questions
        System.out.print("Enter your name: ");
        name = varInput.nextLine();

        System.out.print("Enter your M#: ");
        mNum = varInput.nextLine();

        System.out.print("Describe Yourself: ");
        userDescription = varInput.nextLine();

        System.out.print("Enter Due Date: ");
        dueDate = varInput.nextLine();
        
      

        System.out.println("CMSC203 Assignment1: Test your ESP skills!");

        // Color Guessing code
        for (int i = 1; i <= 11; i++) {
            // determines random color
            String compColor; //Computer Color
            int compColorRandom = rand.nextInt(7) + 1; // Range is 1-7 for 7 colors
            switch (compColorRandom) {
                case 1:
                    compColor = RED;
                    break;
                case 2:
                    compColor = ORANGE;
                    break;
                case 3:
                    compColor = YELLOW;
                    break;
                case 4:
                    compColor = GREEN;
                    break;
                case 5:
                    compColor = BLUE;
                    break;
                case 6:
                    compColor = PURPLE;
                    break;
                case 7:
                    compColor = PINK;
                    break;
                default:
                    compColor = ""; // Default value for compColor
            }
            
            //Round string output
            System.out.println("Round " + i); // i value in for loop is also round #
            System.out.println("I'm thinking of a color");
            System.out.println("Is it Red, Orange, Yellow, Green, Blue, Purple, or Pink?");
            System.out.println("Enter your Guess: ");
            String userColor = varInput.nextLine();
            System.out.println("I was thinking of " + compColor);

            if (userColor.equalsIgnoreCase(compColor)) {
                userScore++;
            }
        }
        // Close the Scanner
        varInput.close();
        // loop ends after repeating 11 times
        System.out.println("Game Over");
        System.out.println("You guessed " + userScore + " out of 11 colors correctly.");
        System.out.println("Student name: " + name);
        System.out.println("User Description: " + userDescription);
        System.out.println("Due Date: " + dueDate);
    }
}
