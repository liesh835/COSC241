package week10;

/**
 * Creating an EmptyPileException through implementing RuntimeException.
 * @author Shaun Liew
 */

public class EmptyPileException extends RuntimeException{
    /**
     * a constructor to supply a given message when exception occurs.
     * @param message the given message
     */
    
    public EmptyPileException(String message){
        super(message);
    }
}
