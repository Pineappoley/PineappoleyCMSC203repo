/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: create 2d ragged array of doubles
 * Due: 4/8/24
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dylan Avallone
*/

package assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {

    // Reads from a file and returns a 2D ragged array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<double[]> tempList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] numbers = scanner.nextLine().trim().split("\\s+");
            double[] row = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                row[i] = Double.parseDouble(numbers[i]);
            }
            tempList.add(row);
        }
        scanner.close();
        return tempList.toArray(new double[0][]);
    }

    // Writes a 2D ragged array into a file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    // Returns the total of all elements in a 2D ragged array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Returns the average of the elements in the 2D ragged array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    // Returns the total of a specified row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

 
    // Returns the total of a specified column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    // Returns the highest value in the specified row
    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.MIN_VALUE;
        for (double val : data[row]) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    // Returns the index of the highest value in the specified row
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = -1;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returnlowest value in the specified row
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        for (double val : data[row]) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    // Return index of the lowest value 
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                index = i;
            }
        }
        return index;
    }

    // Returns the highest value in the specified column
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.MIN_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] > max) {
                max = row[col];
            }
        }
        return max;
    }

    // Returnindex of hihest value 
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns lowest value in column
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.MAX_VALUE;
        for (double[] row : data) {
            if (col < row.length && row[col] < min) {
                min = row[col];
            }
        }
        return min;
    }

   
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        }
        return index;
    }

    // Returns the highest value in the entire array
    public static double getHighestInArray(double[][] data) {
        double max = Double.MIN_VALUE;
        for (double[] row : data) {
            for (double val : row) {
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

  
    public static double getLowestInArray(double[][] data) {
        double min = Double.MAX_VALUE;
        for (double[] row : data) {
            for (double val : row) {
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;
    }
}
