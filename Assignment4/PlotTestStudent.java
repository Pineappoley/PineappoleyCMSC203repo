/*
 * Class: CMSC203 
 * Instructor:
 * Description: tests methods in plot class
 * Due: 03/18/2024
 * Platform/compiler:eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package assignment4;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot plot = new Plot(2, 3, 5, 6);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(5, plot.getWidth());
        assertEquals(6, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot original = new Plot(1, 2, 3, 4);
        Plot copy = new Plot(original);
        assertEquals(original.getX(), copy.getX());
        assertEquals(original.getY(), copy.getY());
        assertEquals(original.getWidth(), copy.getWidth());
        assertEquals(original.getDepth(), copy.getDepth());
    }

    @Test
    public void testSettersAndGetters() {
        Plot plot = new Plot();
        plot.setX(10);
        plot.setY(20);
        plot.setWidth(30);
        plot.setDepth(40);

        assertEquals(10, plot.getX());
        assertEquals(20, plot.getY());
        assertEquals(30, plot.getWidth());
        assertEquals(40, plot.getDepth());
    }

    @Test
    public void testOverlapsTrue() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 3, 3);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    public void testOverlapsFalse() {
        Plot plot1 = new Plot(1, 1, 2, 2);
        Plot plot2 = new Plot(5, 5, 2, 2);
        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    public void testEncompassesTrue() {
        Plot largePlot = new Plot(1, 1, 10, 10);
        Plot smallPlot = new Plot(2, 2, 2, 2);
        assertTrue(largePlot.encompasses(smallPlot));
    }

    @Test
    public void testEncompassesFalse() {
        Plot largePlot = new Plot(1, 1, 10, 10);
        Plot smallPlot = new Plot(2, 2, 10, 10);
        assertFalse(largePlot.encompasses(smallPlot));
    }

    @Test
    public void testToString() {
        Plot plot = new Plot(2, 3, 4, 5);
        String expected = "2,3,4,5";
        assertEquals(expected, plot.toString());
    }
}
