/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: test cases for twodimraggedarrayutility
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

public class TwoDimRaggedArrayUtilityStudentTest {

    private double[][] data;

    @Before
    public void setUp() {
        data = new double[][] {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
    }

    @Test
    public void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals("Incorrect total calculation", 45.0, total, .001);
    }

    @Test
    public void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals("Incorrect average calculation", 5.0, average, .001);
    }

    @Test
    public void testGetRowTotal() {
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
        assertEquals("Incorrect row total calculation for row 1", 9.0, rowTotal, .001);
    }

    @Test
    public void testGetColumnTotal() {
        double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
        assertEquals("Incorrect column total calculation for column 0", 11.0, columnTotal, .001);
    }

    @Test
    public void testGetHighestInRow() {
        double highest = TwoDimRaggedArrayUtility.getHighestInRow(data, 2);
        assertEquals("Incorrect highest value in row 2", 9.0, highest, .001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        int index = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2);
        assertEquals("Incorrect index of highest value in row 2", 3, index);
    }

    @Test
    public void testGetLowestInRow() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
        assertEquals("Incorrect lowest value in row 1", 4.0, lowest, .001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        int index = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
        assertEquals("Incorrect index of lowest value in row 1", 0, index);
    }

    @Test
    public void testGetHighestInColumn() {
        double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 1);
        assertEquals("Incorrect highest value in column 1", 7.0, highest, .001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        int index = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1);
        assertEquals("Incorrect index of highest value in column 1", 2, index);
    }

    @Test
    public void testGetLowestInColumn() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);
        assertEquals("Incorrect lowest value in column 0", 1.0, lowest, .001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        int index = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0);
        assertEquals("Incorrect index of lowest value in column 0", 0, index);
    }

    @Test
    public void testGetHighestInArray() {
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals("Incorrect highest value in the array", 9.0, highest, .001);
    }

    @Test
    public void testGetLowestInArray() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals("Incorrect lowest value in the array", 1.0, lowest, .001);
    }
}
