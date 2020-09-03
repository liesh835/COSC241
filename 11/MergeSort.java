package week11;

/**
 * merge sorting.
 *
 * @author Shaun Liew
 */

public class MergeSort extends Sorter {
    
    /**
     * Creates a new MergeSort constructor given integers as parameters.
     * @param nums integers to sort.
     */

    public MergeSort(Integer [] nums){
        super(nums);
    }

    /**
     * Sorts integers through calling on the mergeSort method.
     */

    public void sortNums(){
        int comparisons = 0;
        mergeSort(0, nums.length-1);
    }

    /**
     * recursive method that sorts the integers.
     * @param left the beginning of an array
     * @param right the last item in an array
     */


    public void mergeSort(int left, int right){
            
        if(left < right){
            comparisons++;
            int mid = (left + right)/2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            mergeNums(left, mid + 1, right);
        }
    }

    /**
     * recursive method that merges the sorted integers.
     * @param left the beginning of an array
     * @param mid the middle of an array
     * @param right the last item in an array
     */

    public void mergeNums(int left, int mid, int right){

        int [] temp = new int [nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
        
        int i = left;
        int j = left;
        int k = mid;

        while(i < mid && k <= right){
            comparisons+= 2;
                
            if(temp[i] < temp[k]){
                comparisons++;
                nums[j++] = temp[i++];
            }else{
                comparisons++;
                nums[j++] = temp[k++];
            }
            update();
        }
        
        while(i < mid){
            comparisons++;
            nums[j++] = temp[i++];
            update();
        }
        
        while(j <= right){
            comparisons++;
            nums[j++] = temp[k++];
        }
        update();
    }
}

