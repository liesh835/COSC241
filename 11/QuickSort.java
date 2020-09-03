package week11;

/**
 * quick sorting.
 *
 * @author Shaun Liew
 */

public class QuickSort extends Sorter {
    
    /**
     * Creates a new QuickSort constructor given integers as parameters.
     * @param nums integers to sort.
     */

    public QuickSort(Integer [] nums){
        super(nums);
    }

    /**
     * Sorts integers through calling on the quickSort method.
     */

    public void sortNums(){
        int comparisons = 0;
        quickSort(0, nums.length-1);
    }

    /**
     * recursive method for quick sorting the integers.
     * @param left the beginning of an array
     * @param right the end of an array
     */
    
    public void quickSort(int left, int right){
        if(left < right){
            int p = partition(left,right);
            quickSort(left, p);
            quickSort(p + 1, right);
        }
        update();
    }

    /**
     * the main sorting algorithm for quick sorting.
     * @param left the beginning of the array
     * @param right the last item in the array
     * @return hole the index of the hole
     */
    
    public int partition(int left, int right){
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        int hole = left;
        
        while(true){
            while(j > hole && nums[j] >= pivot){
                comparisons+=2;
                j--;
            }
            update();
            
            if(j == hole){
                comparisons++;
                break;
            }else{
                nums[hole] = nums[j];
                hole = j;
            }
            update();

            while(i < hole && nums[i] < pivot){
                comparisons+=2;
                i++;
            }
            update();

            if(i == hole){
                comparisons++;
                break;
            }else{
                nums[hole] = nums[i];
                hole = i;
            }
            update();
        }
        nums[hole] = pivot;
        return hole;
    }
}


                       
