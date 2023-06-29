package sorts.ShellSort;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-03-24 14:29
 **/
public class shell {
    public static void main(String[] args) {
        int[] arr = {9,4,7,6,8,4,2,1,3,0};
        sort2(arr);

    }

    public static void shellSort(int[] arr){
        int temp = 0;

        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i - gap; j >= 0  ; j -= gap) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }

            }

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void sort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                if (arr[j] < arr[j-gap]){
                    while (j - gap >= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
