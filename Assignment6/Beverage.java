/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: get beverage detail(size,type,name,price) from each drink subclass
 * Due: 4/29/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package assignment6;

public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public double addSizePrice() {
        switch (this.size) {
            case MEDIUM:
            	 return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + SIZE_PRICE*2;
            default:
                return BASE_PRICE;
        }
    }
   public double getSizePrice() {
	   return addSizePrice();
   }
    
    public abstract double calcPrice();

    @Override
    public String toString() {
        return name + ", " + size;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Beverage beverage = (Beverage) anotherBev;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }
}
