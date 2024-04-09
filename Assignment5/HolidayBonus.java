/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: holidaybonus calculations
 * Due: 4/8/24
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dylan Avallone
*/

package assignment5;


public class HolidayBonus {

    // Constants for bonus amounts
    public static final double HIGH_BONUS = 5000.00;
    public static final double LOW_BONUS = 1000.00;
    public static final double OTHER_BONUS = 2000.00;

    // Calculate bonuses for each store
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] <= 0) continue; // Skip negative or zero sales
                double bonus = OTHER_BONUS;
                if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
                    bonus = HIGH_BONUS;
                } else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
                    bonus = LOW_BONUS;
                }
                bonuses[i] += bonus;
            }
        }
        return bonuses;
    }

    // Calculate total of all Holiday Bonuses for District
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double totalBonus = 0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}
