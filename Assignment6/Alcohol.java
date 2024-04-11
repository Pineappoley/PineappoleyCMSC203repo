/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: create alcohol beverage, calculate its price, output tostring
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;


public class Alcohol extends Beverage {
    private boolean isWeekend;
    private static final double WEEKEND_SURCHARGE = 0.60; 

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size); 
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = getSizePrice();
        if (isWeekend) {
            price += WEEKEND_SURCHARGE;
        }
        return price;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;
        Alcohol alcohol = (Alcohol) anotherBev;
        return isWeekend == alcohol.isWeekend;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
               "name='" + getName() + '\'' +
               ", size=" + getSize() +
               ", isWeekend=" + isWeekend +
               ", price=" + calcPrice() +
               '}';
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }
}


