/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: create coffee beverage, calculate its price, output tostring
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

public class Coffee extends Beverage {
    private static final double EXTRA_SHOT_COST = 0.50;
    private static final double EXTRA_SYRUP_COST = 0.50;
    
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = getSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + getName() + '\'' +
                ", size=" + getSize() +
                ", extraShot=" + extraShot +
                ", extraSyrup=" + extraSyrup +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

    // Getters and setters for extraShot and extraSyrup

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
