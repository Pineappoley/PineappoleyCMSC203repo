/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: test cases for holiday bonus
 * Due: 4/8/24
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dylan Avallone
*/

package assignment5;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class HolidayBonusStudentTest {

    private double[][] data;

    @Before
    public void setUp() throws Exception {
        data = new double[][] {
            {10.0, 20.0, 30.0},  // store 1
            {40.0, 5.0, -10.0},  // store 2
            {0.0, 15.0, 25.0}    // store 3
        };
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);

        assertNotNull("Bonuses array should not be null", bonuses);
        assertEquals("Incorrect number of bonuses calculated", data.length, bonuses.length);

        // Check if bonuses are calculated correctly 
        assertTrue("Bonus for store 1 should be calculated correctly", bonuses[0] > 0);
        assertTrue("Bonus for store 2 should be calculated correctly", bonuses[1] > 0);
        assertTrue("Bonus for store 3 should be calculated correctly", bonuses[2] > 0);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(data);

        // Check if total bonus is calculated correctly
        assertTrue("Total holiday bonus should be a positive value", totalBonus > 0);
    }
}
