package week01; //declaring class in package week01
import java.util.*; 
/**
 *Counter.java
 *COSC 241 Lab 1.
 *@author Shaun Liew
*/

public class Counter{
       
    /**
     * main method that takes user input and displays # of words and lines.
     *@param args ignored in this instance.
     */
    
    public static void main(String [] args){
 
        int lineCount = 0, wordCount = 0; 
        String input = "";
        Scanner sc = new Scanner(System.in);
        
        /** while loop that counts number of words and lines */
        
        while(sc.hasNextLine()){
            lineCount++;
            input = sc.nextLine();
            if(input.length() > 0){
                wordCount+= input.split("\\s").length; //split to seperate words
            }
        }
       
        System.out.println("lines: " + lineCount + "\nwords: " + wordCount);
    }// end main method
}// end class

