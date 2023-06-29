package sorts.MergeSortTest;

import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-03-29 20:22
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
//        System.out.println(temp[0]);
        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left+right) / 2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,right,mid,temp);
        }
    }
    //合并的方法

    /**
     *
     * @param arr
     * @param left 左边有序序列的初始索引
     * @param right 右边索引
     * @param mid 中间索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int right,int mid,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        //2 4 8 9 6 5 4
        //0 1 2 3 4 5 6
        //1
        while (i <= mid && j <= right){
            if (arr[i] >= arr[j]){
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }else {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            }
        }
        //2
        while (i <= mid){
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right){
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }
        //3
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}
