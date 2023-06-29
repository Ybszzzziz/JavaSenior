package com.atguigu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yan
 * @create 2022-12-20 19:30
 **/
public class Suborder extends Order<Float>{

    public <E> List<E> copyFromArray(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }
}
