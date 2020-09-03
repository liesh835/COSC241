package week04;
import java.util.*;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Shaun Liew
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(!rowLengthsDecrease(t)){
            return false;
        }else if(!rowValuesIncrease(t)){
            return false;
        }else if(!columnValuesIncrease(t)){
            return false;
        }else if(!isSetOf1toN(t)){
            return false;
        }
        return true;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * method checks if row not longer than a preceding row.
     * @param t a 2D array that represents a tableau.
     * @return true if row is not longer than preceding row.
     */

    public static boolean rowLengthsDecrease(int[][] t){
        int x = 0;

        for(int i = 1; i < t.length; i++){
            if(t[i].length > t[x].length){
                return false;
            }
            x++;
        }
        return true;
    }

    /**
     * method that checks if row values increase from left to right.
     * @param t a 2D array that represents a tableau.
     * @return true if row values increase from left to right.
     */

    public static boolean rowValuesIncrease(int[][] t){
        int j = 1;

        for(int i = 0; i < t.length - 1; i++){
            j = 1;
            for(int x = 0; x < t[i].length - 1; x++){
                if(t[i][x] >= t[i][j]){
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    /**
     * method checks if column values increase as you go down a column.
     * @param t a 2D array that represents a tableau.
     * @return true if column values increase from top to bottom.
     */

    public static boolean columnValuesIncrease(int[][] t){
        int y = 1;

        for(int col = 0; col < t[0].length - 1; col++){
            y = 1;
            for(int row = 0; row < t.length - 1; row++){
                if(col < t[row + 1].length){
                    if(t[row][col] >= t[y][col]){
                        return false;
                    }
                }
                y++;
            }
        }
        return true;
    }

    /**
     * method that checks if numbers in array are unique and not missing.
     * @param t a 2D array that represents a tableau.
     * @return true if all integers are not missing or duplicated.
     */

    public static boolean isSetOf1toN(int[][] t){
        int count = 0, y = 0, x = 1;

        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                y++;
            }
        }                    
            
        int [] set = new int [y];

        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                set[count] = t[row][col];
                count++;
            }
        }

        Arrays.sort(set);
        for(int i = 0; i < set.length; i++){
            if(set[i] != x){
                return false;
            }
            x++;
        }
        return true;
    }
}
