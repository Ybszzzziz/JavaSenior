package sorts.selectsort;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-03-22 20:49
 **/
public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{22,1,3,4,63,102};
        selectSort(arr);
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
