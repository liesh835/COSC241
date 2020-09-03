package week10;
import java.util.*;

/**
 * An implementation of an Exam Pile which is viewed through its
 * ExamPile superclass.
 * @author Shaun Liew
 */

public class EP implements ExamPile{

    /** creating a new ArrayList */
    private ArrayList <Integer> exams = new ArrayList<>();

    /**
     * Loads the given array of integers into the array list.
     * @param items the integers to be loaded
     */
    
    public void load(int [] items){
        for(int i : items){
            exams.add(i);
        }
    }

    /**
     * The number of exams remaining in the pile.
     * @return eSize the size of the arraylist
     */
    
    public int size(){
        int eSize = exams.size();
        return eSize;
    }

    /**
     * To look at the top of the exam pile.
     * @return exams.get(0) the first integer in the array list
     */

    public int peek(){
        if(this.size() == 0){
            throw new EmptyPileException("Peek on empty exam pile");
        }
        return exams.get(0);
    }

    /**
     * To remove the marked exam from the pile.
     * @return top the first value in the pile
     */

    public int mark(){
        int top = this.peek();
        exams.remove(0);
        return top;
    }

    /**
     * To move the top exam to the bottom of the pile.
     */

    public void delay(){
        int top = this.peek();
        exams.remove(0);
        exams.add(top);
    }

    /**
     * To check if two separate piles are loaded with the same integers.
     * @param e an instance of EP
     * @return exams.containsAll(e.exams) true if two piles are equal
     */

    public boolean equals(EP e){
        return exams.containsAll(e.exams);
    }

    /**
     * toString that separates the integers in a pile.
     * @return result.toString() a recursive separation of integers
     */

    public String toString(){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < this.size(); i++){
            result.append(exams.get(i));
            if(this.size() > i+1){
                result.append(" ");
            }
        }
        return result.toString();
    }

    /**
     * Sorting an array of integers using a string.
     * @return sort.toString() a StringBuilder of string containing "D" and "M"
     */

    public String sortingSteps(){
        StringBuilder sort = new StringBuilder();
        int i = 0;
        
        while(exams.size() != 0){
            if(exams.get(0) == i){
                sort.append("M");
                mark();
                i++;
            }else{
                sort.append("D");
                delay();
            }
        }
        return sort.toString();
    }

    /**
     * Takes a String of "D"'s  and "M"'s and converts them back into the
     * originally unsorted list of integers.
     * @param steps the given string to reconstruct
     * @return empty the reconstruted exam pile
     */

    public static EP reconstruct(String steps){
        LinkedList <Integer> numList = new LinkedList <Integer>();
        EP empty = new EP();
        String reversedSteps = new StringBuilder(steps).reverse().toString();
        char [] stepsCh = reversedSteps.toCharArray();
        int mCount = 0;

        for(int i = 0; i < steps.length(); i++){
            if(steps.charAt(i) == 'M'){
                mCount++;
            }
        }
        
        for(int i = 0; i < mCount; i++){
            numList.add(i);
        }

        for(char c : stepsCh){
            if(c == 'M'){
                empty.exams.add(0,numList.getLast());
                numList.removeLast();
            } else {
                int lastItem = empty.exams.get(empty.exams.size() - 1);
                empty.exams.add(0, lastItem);
                empty.exams.remove(empty.exams.size() - 1);
            }
        }
        return empty;
    }
}

