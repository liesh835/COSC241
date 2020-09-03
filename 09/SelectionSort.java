package week09;

/**
 * Selection sorting.
 *
 * @author Shaun Liew
 */

public class SelectionSort extends Sorter {
    /**
     * Creates a new SelectionSort constructor given integers as parameters.
     * @param nums integers to sort.
     */

    public SelectionSort(Integer [] nums){
        super(nums);
    }

    /**
     * sorts integers using selection.
     */

    public void sortNums(){ 
        int smallIndex, temp, smallValue;
        comparisons = 0;
    
        for(int i = 0; i < nums.length ; i++){
            smallIndex = i;
            smallValue = nums [i];
            
            for(int j = i; j < nums.length; j++){
                if(nums[j] < smallValue){ 
                    smallIndex = j;
                    smallValue = nums [j];
                }
                    
                if(++comparisons > 0 && smallValue < nums[i]){ 
                    temp = nums [i];
                    nums [i] = nums [smallIndex];
                    nums [smallIndex] = temp;
                }
                update();
            }   
        }
    }
}

