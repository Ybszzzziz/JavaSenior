package com.atguigu.java;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yan
 * @create 2022-12-22 18:55
 **/
public class Reflectiontest {
    public static void main(String[] args) {

    }
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object instance = constructor.newInstance("Tom", 12);
        Person person = (Person) instance;
        System.out.println(instance.toString());
        //2.通过反射，调用对象指定的属性、方法
        Field age = personClass.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person);
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);
        //通过反射，可以调用类的私有结构，例如 私有构造器，方法，属性
        Constructor constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("Jerry");
        System.out.println(p1);
        //调用属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");
        System.out.println(nation);
    }

    //获取Class大的类的实例
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName（String classPath）
        Class<?> clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);


    }
    @Test
    public void test3() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        //创建运行时类的对象
        Person person = clazz.newInstance();

    }
    @Test
    //调用运行时类的主要结构：属性、方法、构造器
    public void testField() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        //获取指定的属性
        Field age = clazz.getField("age");
        age.set(person,25);
        int pAge = (int) age.get(person);
        System.out.println(pAge);


    }
    @Test
    public void testFiled1() throws NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class clazz = Person.class;
        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);
        name.set(person,"tom");
        System.out.println(name.get(person));

    }

    //操作运行时类的指定方法
    @Test
    public void test4() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object invoke = showNation.invoke(person, "USA");
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        System.out.println("***********");
        showDesc.invoke(person);
    }

    //操作运行时的构造器
    @Test
    public void test5() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person person = constructor.newInstance("Jack");
        System.out.println(person);


    }
}
