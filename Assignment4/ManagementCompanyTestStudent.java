/*
 * Class: CMSC203 
 * Instructor:
 * Description: Tests all methods in managementcompany class except setup & teardown
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

public class ManagementCompanyTestStudent {
    
    @Test
    public void testDefaultConstructor() {
        ManagementCompany mc = new ManagementCompany();
        assertEquals("", mc.getName());
        assertEquals("", mc.getTaxID());
        assertEquals(0.0, mc.getMgmFeePer(), 0.01);
        assertNotNull(mc.getPlot());
        assertEquals(0, mc.getPropertiesCount());
    }

    @Test
    public void testParameterizedConstructor() {
        ManagementCompany mc = new ManagementCompany("Company", "123456789", 10.0);
        assertEquals("Company", mc.getName());
        assertEquals("123456789", mc.getTaxID());
        assertEquals(10.0, mc.getMgmFeePer(), 0.01);
        assertNotNull(mc.getPlot());
    }

    @Test
    public void testAddProperty() {
        ManagementCompany mc = new ManagementCompany();
        int index = mc.addProperty("Test Property", "Test City", 1000.0, "Test Owner");
        assertEquals(0, index);
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    public void testAddPropertyFull() {
        ManagementCompany mc = new ManagementCompany();  // Assuming it creates a default plot like 10x10
        // Assuming MAX_PROPERTY is 5
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            // loop to make max amount of properties and space them apart
            mc.addProperty("Property " + i, "City " + i, 1000.0 * i, "Owner " + i, i, i, 1, 1); 
        }
        // 6th property added which should result in an error message
        int index = mc.addProperty("Extra Property", "Extra City", 5000.0, "Extra Owner", 10, 10, 1, 1);
        assertEquals(-1, index); // Sould be -1 since array is full
    }


    @Test
    public void testGetTotalRent() {
        ManagementCompany mc = new ManagementCompany();
        // Add 2 properties rent together
        mc.addProperty("Property 1", "City 1", 1000.0, "Owner 1", 0, 0, 1, 1);
        mc.addProperty("Property 2", "City 2", 2000.0, "Owner 2", 1, 1, 1, 1);

        double totalRent = mc.getTotalRent();
        assertEquals(3000.0, totalRent, 0.01); // total rent should be 3000
    }

    @Test
    public void testGetHighestRentProperty() {
        ManagementCompany mc = new ManagementCompany();
        // create 2 properties and compare to see which rent is greatest
        mc.addProperty("Property 1", "City 1", 1000.0, "Owner 1", 0, 0, 1, 1);
        mc.addProperty("Property 2", "City 2", 2000.0, "Owner 2", 1, 1, 1, 1);

        Property highestRentProp = mc.getHighestRentProperty();
        assertNotNull(highestRentProp);
        assertEquals(2000.0, highestRentProp.getRentAmount(), 0.01); // highest rent should be 2000
    }


    @Test
    public void testToString() {
        ManagementCompany mc = new ManagementCompany("Company", "123456789", 10.0);
        mc.addProperty("Test Property", "Test City", 1000.0, "Test Owner");
        String resultString = mc.toString();
        assertNotNull(resultString);
      
    }
}
