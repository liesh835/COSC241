package week11;

/**
 * heap sorting.
 *
 * @author Shaun Liew
 */

public class HeapSort extends Sorter {
    
    /**
     * Creates a new HeapSort constructor given integers as parameters.
     * @param nums integers to sort.
     */

    public HeapSort(Integer [] nums){
        super(nums);
    }

    /**
     * Sorts integers through calling on the heapSort method.
     */

    public void sortNums(){
        int comparisons = 0;
        heapSort(nums.length);
    }

    /**
     * main method for heap sorting.
     * @param num the length of the array
     */

    public void heapSort(int num){
        for (int i = (num/2) - 1; i >= 0; i--){
            heapify(num, i);
        }

        for(int i = num - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(i,0);
        }
    }

    /**
    * Recursive method for sorting integers through HeapSort.
    * @param num the length of the array
    * @param i the root node
    */

    public void heapify(int num, int i){
        int high = i;
        int left = (i*2) + 1;
        int right = (i*2) + 2;

        if(left < num && nums[left] > nums[high]){
            comparisons += 2;
            high = left;
        }
        update();

        if(right < num && nums[right] > nums[high]){
            comparisons+=2;
            high = right;
        }
        update();

        if(high != i){
            comparisons++;
            int temp = nums[i];
            nums[i] = nums[high];
            nums[high] = temp;
            heapify(num, high);
        }
        update();
    }
}
            
