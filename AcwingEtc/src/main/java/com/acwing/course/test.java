package com.acwing.course;

import java.io.*;
import java.util.*;
public class test {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }
        System.out.print(map);
    }

    public static void reverse(int[] arr) {

    }



}
