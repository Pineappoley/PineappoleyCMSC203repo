/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: create smoothie beverage, calculate its price, output tostring
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/
package assignment6;

public class Smoothie extends Beverage {
    private static final double COST_PER_FRUIT = 0.50;
    private static final double PROTEIN_POWDER_COST = 1.50;
    
    private int numOfFruits;
    private boolean addProtein;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = getSizePrice();
        price += numOfFruits * COST_PER_FRUIT;
        if (addProtein) {
            price += PROTEIN_POWDER_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Smoothie{" +
                "name='" + getName() + '\'' +
                ", size=" + getSize() +
                ", numOfFruits=" + numOfFruits +
                ", addProtein=" + addProtein +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
    }

    // Getters and setters for numOfFruits and addProtein

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}
