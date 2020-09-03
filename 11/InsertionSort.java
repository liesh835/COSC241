package week11;

/**
 * insertion sorting.
 *
 * @author Shaun Liew
 */

public class InsertionSort extends Sorter {
    
    /**
     * Creates a new InsertionSort constructor given integers as parameters.
     * @param nums integers to sort.
     */

    public InsertionSort(Integer [] nums){
        super(nums);
    }
    /**
     * Sorts integers using insertion.
     */

    public void sortNums(){
        comparisons = 0;
        for(int p = 1; p < nums.length; p++){
            int key = nums[p];
            int i = p - 1;

            while(i >= 0 && nums[i] > key){
                comparisons++;
                nums[i + 1] = nums[i];
                i = i - 1;
            }
            nums[i + 1] = key;
            update();
        }
    }
}
            
