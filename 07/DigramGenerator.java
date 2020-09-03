package week07;
import java.io.File;
import java.util.*;

/**
 * generator of random words that considers the previous letter.
 * @author Shaun Liew
 */
public class DigramGenerator implements WordGenerator {
    
    /** instance of random. */
    private Random random;

    /**
     * constructor initializing r.
     * @param r is Random
     */

    public DigramGenerator(Random r) {
        random = r;
    }

    /**
     * method that returns the next word.
     * @param n is an int
     * @return result, a string containing the next word
     */

    public String nextWord(int n) {
        ArrayList<String> continued = new ArrayList<>();     
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        try{

            Scanner sc1 = new Scanner(new File("first-letters.txt"));
            String firstText = sc1.nextLine();
            
            Scanner sc2 = new Scanner(new File("continuations.txt"));
            while(sc2.hasNextLine()){
                continued.add(sc2.nextLine());
            }
            
            StringBuilder result = new StringBuilder();
            result.append(firstText.charAt(random.nextInt(firstText.length())));
            for(int i = 0; i < n - 1; i++) {
                char x = result.charAt(result.length() - 1);
                String continuedLine = continued.get(alphabet.indexOf(x));
                int rand = random.nextInt(continuedLine.length());
                char c = continuedLine.charAt(rand);
                result.append(c);
            }
            return result.toString();
            
        }catch(Exception e){
            return e.getMessage();
        }
    }
}
