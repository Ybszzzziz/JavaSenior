package sorts.BubbleSorting;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-03-16 15:28
 **/
public class bubble {
    public static void main(String[] args) {
        boolean flag = false;
        int temp = 0;
        int[] arr = new int[]{2,3,4,1,5,9,0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }

            }
            System.out.println(Arrays.toString(arr));
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}



