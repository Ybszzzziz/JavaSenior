package com.acwing.course.Lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Yan
 * @create 2023-06-19 9:03
 **/
public class QuickSortDemo {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        String[] strs = new String[0];
        try{
            n = Integer.parseInt(bf.readLine());
            strs = bf.readLine().split(" ");
        }catch (Exception e){
            e.printStackTrace();
        }
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++){ arr[i] = Integer.parseInt(strs[i]);}
        quickSort(arr,0,n-1);
        for (int i = 0 ; i < n; i++){System.out.println(arr[i]);}

    }
    public static void quickSort(int[] arr, int left, int right){
        if (left >= right) {
            return;
        }
        int l= left - 1, r = right + 1;
        int p = arr[left+right >> 1];
        while (l < r){
            do l++; while (arr[l] < p);
            do r--; while (arr[r] > p);
            if (l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        quickSort(arr,left,r);
        quickSort(arr,r+1,right);
    }
}
