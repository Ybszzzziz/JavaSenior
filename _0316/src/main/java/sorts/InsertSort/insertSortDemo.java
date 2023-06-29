package sorts.InsertSort;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-06-08 8:47
 **/
public class insertSortDemo {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int insertVal = nums[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < nums[insertIndex]){
                nums[insertIndex+1] = nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex+1] = insertVal;
        }
    }

}
