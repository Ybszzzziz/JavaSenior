package sorts.QuickSort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Yan
 * @create 2023-03-29 18:56
 **/
public class QSort {
    public static void main(String[] args) {
        int[] arr = {12, 4, 2, -2, -2, 0, 2, 4, 456, -2, 4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right) / 2];
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }
        if(l == r){
            l += 1;
            r -= 1;
        }
        if (left < r){
            quickSort(arr,left,r);
        }
        if (right > l){
            quickSort(arr,l,right);
        }

    }
}
