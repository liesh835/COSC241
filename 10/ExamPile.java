package week10;
import java.util.*;

/**
 * The interface of an exam pile.
 * @author Shaun Liew
 */

public interface ExamPile {
    public void load(int[] items);
    public int size();
    public int peek();
    public int mark();
    public void delay();
}
