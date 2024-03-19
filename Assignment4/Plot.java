/*
 * Class: CMSC203 
 * Instructor:
 * Description: this class plots the coordinates of each property
 * Due: 03/18/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dylan Avallone
*/

package assignment4;
public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

   
    public Plot() {
        this(0, 0, 1, 1);  // default constructor
    }

    // Constructor with attributes
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // its copy constructor
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Check if plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        return !(x + width <= plot.x || plot.x + plot.width <= x ||
                 y + depth <= plot.y || plot.y + plot.depth <= y);
    }

    // Check if plot encompasses another plot
    public boolean encompasses(Plot plot) {
        return (x <= plot.x && x + width >= plot.x + plot.width &&
                y <= plot.y && y + depth >= plot.y + plot.depth);
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }


    @Override
    public String toString() {     // toString method
        return x + "," + y + "," + width + "," + depth;
    }
}
