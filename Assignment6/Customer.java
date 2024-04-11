package assignment6;

public class Customer {
    private String name;
    private int age;

    /**
     * Standard constructor to create a new Customer object.
     * 
     * @param name The name of the customer.
     * @param age The age of the customer.
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor to create a new Customer object as a copy of an existing one.
     * 
     * @param other The Customer object to be copied.
     */
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    /**
     * Returns the name of the customer.
     * 
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * 
     * @param name The new name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the customer.
     * 
     * @return The age of the customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     * 
     * @param age The new age of the customer.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the customer.
     * 
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Optionally override equals and hashCode if necessary
}
