package trees.BinarySearchDemo;

import java.util.ArrayList;

/**
 * @author Yan
 * @create 2023-03-31 21:36
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1234};
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        list.forEach(System.out::println);
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid = (left+right) / 2;
            if (left > right){
                return -1;
            }
            if (findVal > arr[mid]){
                return binarySearch(arr,mid+1,right,findVal);
            }
            if (findVal < arr[mid]){
                return binarySearch(arr,left,mid-1,findVal);
            }
            else{
                return mid;
            }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left+right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr,left,mid-1,findVal);
        }else {
            ArrayList<Integer> resList = new ArrayList<>();
            int temp = mid-1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                resList.add(temp);
                temp -= 1;
            }
            resList.add(mid);
            temp = mid+1;
            while (true){
                if (temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                resList.add(temp);
                temp += 1;
            }
            return resList;

        }
    }
}
