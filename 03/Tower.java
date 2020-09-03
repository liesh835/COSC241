package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Shaun Liew
 */
public class Tower{

    /** The top block. */
    private char top;
 
    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }

    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }

    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**
     * method that returns the the number of blocks in the tower.
     * @return i containing the height of the tower
     */
    public int height(){
        int i = 0;
        
        if(isEmpty()){     
            return i;
        }else{
            return i += rest.height() + 1;
        }              
    }
    /**
     * method that returns the number of blocks at the given block in tower.
     * @param c char representing block in tower
     * @return counting containing number of blocks
     */

    public int count(char c){
        int counting = 0;
        
        if(isEmpty()){
            return counting;     
        }else if(c == this.top){
            return counting += rest.count(c) + 1 ;
        }else{
            return counting = rest.count(c);
        }
    }

}
