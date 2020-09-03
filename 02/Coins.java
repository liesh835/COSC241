package week02;
import java.util.*;
/**
 * COSC 241 Lab 2 Coins.java.
 * @author Shaun Liew
 */

public class Coins{

    /**
     * constant boolean that represents heads.
     */
    
    public static final boolean HEADS = true;

    /**
     * constant boolean that represents tails.
     */
    
    public static final boolean TAILS = false;

    /**
     * data field of an array of booleans.
     */
    
    private boolean[] coins;
    /**
     * Constructor that initializes data field.
     * @param coins boolean array
     */
    
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /**
     * Constructor that creates a string of char 'H' or 'T' based on
     * the boolean of the element in the array.
     * @param c String
     */

    public Coins(String c){
        this.coins = new boolean[c.length()];
        for(int i = 0; i < c.length(); i++){
            if(c.charAt(i) == 'H'){
                this.coins[i] = HEADS;
            }else{
                
                this.coins[i] = TAILS;
            }
        }
    }

    /**
     * Constructor that simulates a coin flip as a random integer of
     * either 0 or 1 represents heads or tails respectively.
     * @param length int
     */
    
    public Coins(int length){
        this.coins = new boolean[length];
        Random rand = new Random(); // creating instance of Random

        for(int i = 0; i < length; i++){
            if(rand.nextInt(2) == 0){
                this.coins[i] = HEADS;
            }else if(rand.nextInt(2) == 1){
                this.coins[i] = TAILS;
            }
        }
    }

    /**
     * method that counts the number of heads present in the array.
     * @return heads
     */
    
    public int countHeads(){
        int heads = 0;
        for(int i = 0; i < this.coins.length; i++){
            
            if(this.coins[i] == HEADS){
            
                heads++;
            }
        }
        return heads;
    }

       
        
    /**
     * method that counts the number of sequence of the same type of coin
     * known as runs.
     * @return runs
     */
    
    public int countRuns(){
        int runs = 0;
        
        if(this.coins.length > 0){
            runs++;
            for(int i = 0; i < this.coins.length-1; i++){
                if (!this.coins[i] == this.coins[i+1]){
                    runs++;
                }
            }
        }
        return runs;
    }

    /**
     * method that Strings together chars 'H' or 'T' based on the
     * boolean present in the current element in the array.
     * @return coinStr
     */
    
    public String toString(){
        String coinStr = "";
        for(int i = 0; i < this.coins.length; i++){
            if(this.coins[i] == HEADS){
                
                coinStr += 'H';
                
            }else if(this.coins[i] == TAILS){
                
                coinStr += 'T';
            }
        }
        
        return coinStr;
    }

    /**
     * main method that creates instances of Coins and calls appropriate
     * methods on those instances.
     * @param args ignored in this case
     */
    
    public static void main (String [] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        Coins c1 = new Coins("HHTHHHTTT");
        Coins c2 = new Coins(10);
        System.out.println(c.countHeads());
        System.out.println(c1.countRuns());
        System.out.println(c2.countHeads());
    } // end main
} // end class
