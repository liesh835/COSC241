package week07;
import java.util.*;
import java.io.File;

/**
 * a generator of letters based on their frequency.
 * @author Shaun Liew.
 */

public class FrequencyGenerator implements WordGenerator {
    
    /** instance of random. */
    private Random random;

    /**
     * constructor initializing r.
     * @param r is Random.
     */

    public FrequencyGenerator(Random r) {
        random = r;
    }

    /**
     * method that returns the next word (random).
     * @param n is an int
     * @return result, the next word
     */

    public String nextWord(int n) {
        ArrayList<Double> arrW = new ArrayList<>();
        
        try{
            Scanner sc = new Scanner(new File("letter-frequencies.txt"));
            while(sc.hasNextDouble()){
                arrW.add(sc.nextDouble());
            }
       
            StringBuilder result = new StringBuilder();
        
            for(int i = 0; i < n; i++) {
                char c = (char) ('a' + chooseIndex(arrW));
                result.append(c);
            }
            
            return result.toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    /**
     * method that returns an int to help create a random word.
     * @return i, an int
     * @param w is a double arraylist
     */

    public int chooseIndex(ArrayList<Double> w){
        int i = 0;
        double r = random.nextDouble();
        while(r > w.get(i)){
            r -= w.get(i);
            i++;
        }
        return i;              
    }
}
