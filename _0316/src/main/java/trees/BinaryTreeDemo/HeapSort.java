package trees.BinaryTreeDemo;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Yan
 * @create 2023-04-03 20:56
 **/
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排列
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序~~~");
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成将以 i 对应的非叶子节点的数调整成大顶堆
     * @param arr 待调整数组
     * @param i 表示非叶子节点的在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length){

        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if ( k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;

    }
}
