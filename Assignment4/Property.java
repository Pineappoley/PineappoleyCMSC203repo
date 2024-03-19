/*
 * Class: CMSC203 
 * Instructor:
 * Description: this class assigns the data of each property created
 * Due: 03/18/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package assignment4;

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Default constructor
    public Property() {
        this("", "", 0.0, "", new Plot());
    }

    // Constructor with parameters but using a default plot
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, new Plot());
    }

    // Constructor with property details and plot
    public Property(String propertyName, String city, double rentAmount, String owner, Plot plot) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = plot;
    }

    // Constructor with property details and plot dimensions
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this(propertyName, city, rentAmount, owner, new Plot(x, y, width, depth));
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner, new Plot(otherProperty.getPlot()));
    }

    // Getters
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    // Setters
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    // toString method
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
