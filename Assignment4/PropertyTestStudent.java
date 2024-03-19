/*
 * Class: CMSC203 
 * Instructor:
 * Description: tests property class methods
 * Due: 03/18/2024
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package assignment4;

import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.01);
        assertEquals("", property.getOwner());
        assertNotNull(property.getPlot());
    }

    @Test
    public void testParameterizedConstructor() {
        Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner");
        assertEquals("Test Property", property.getPropertyName());
        assertEquals("Test City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("Test Owner", property.getOwner());
        assertNotNull(property.getPlot());
    }

    @Test
    public void testFullParameterizedConstructor() {
        Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner", 1, 2, 3, 4);
        assertEquals("Test Property", property.getPropertyName());
        assertEquals("Test City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("Test Owner", property.getOwner());
        assertEquals(1, property.getPlot().getX());
        assertEquals(2, property.getPlot().getY());
        assertEquals(3, property.getPlot().getWidth());
        assertEquals(4, property.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Test Property", "Test City", 1000.0, "Test Owner", 1, 2, 3, 4);
        Property copy = new Property(original);
        assertEquals(original.getPropertyName(), copy.getPropertyName());
        assertEquals(original.getCity(), copy.getCity());
        assertEquals(original.getRentAmount(), copy.getRentAmount(), 0.01);
        assertEquals(original.getOwner(), copy.getOwner());
        assertEquals(original.getPlot().getX(), copy.getPlot().getX());
        assertEquals(original.getPlot().getY(), copy.getPlot().getY());
        assertEquals(original.getPlot().getWidth(), copy.getPlot().getWidth());
        assertEquals(original.getPlot().getDepth(), copy.getPlot().getDepth());
    }

    @Test
    public void testSettersAndGetters() {
        Property property = new Property();
        property.setPropertyName("New Name");
        property.setCity("New City");
        property.setRentAmount(2000.0);
        property.setOwner("New Owner");
        property.setPlot(new Plot(5, 6, 7, 8));

        assertEquals("New Name", property.getPropertyName());
        assertEquals("New City", property.getCity());
        assertEquals(2000.0, property.getRentAmount(), 0.01);
        assertEquals("New Owner", property.getOwner());
        assertEquals(5, property.getPlot().getX());
        assertEquals(6, property.getPlot().getY());
        assertEquals(7, property.getPlot().getWidth());
        assertEquals(8, property.getPlot().getDepth());
    }

    @Test
    public void testToString() {
        Property property = new Property("Test Property", "Test City", 1000.0, "Test Owner");
        String expected = "Test Property,Test City,Test Owner,1000.0";
        assertEquals(expected, property.toString());
    }
}
