package com.atguigu.test;

import org.junit.Test;

import java.util.List;

/**
 * @author Yan
 * @create 2022-12-20 19:25
 **/
public class GenericTest {

    @Test
    public void test1(){
        Order<String> order = new Order<>("shox",1,"random");

    }
    @Test
    public void test2(){
        Suborder suborder = new Suborder();
        Integer arr[] = new Integer[]{1,2,3,4};
        List<Integer> es = suborder.copyFromArray(arr);
        System.out.println(es);

    }

}
