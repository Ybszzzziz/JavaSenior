package StreamAPITest;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Yan
 * @create 2022-12-26 20:08
 *
 * Stream关注的是对数据的运算，与CPU打交道
 * 集合 关注的是数据的的存储，与内存打交道
 * * ①Stream 自己不会存储元素。
 * * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * USE
 * *① Stream的实例化
 * * ② 一系列的中间操作（过滤、映射、...)
 * * ③ 终止操作
 **/
public class StreamApi {

    //通过集合方式创建Stream
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //返回顺序流
        Stream<Employee> stream = employees.stream();
        //返回并行流
        Stream<Employee> employeeStream = employees.parallelStream();


    }

    //通过数组
    @Test
    public void test2(){

        int[] Arr = new int[]{1,2,3,4,5};
        Employee tom = new Employee(1001, "TOM");
        Employee jack = new Employee(1002, "Jack");
        Employee[] employees =  new Employee[]{tom,jack};
        IntStream stream1 = Arrays.stream(Arr);
        Stream<Employee> stream = Arrays.stream(employees);
    }

    //方式三：通过Stream的of（）
    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(20).forEach(System.out::println);



    }

    //筛选与切片
    @Test
    public void test4(){
        List<Employee> list = EmployeeData.getEmployees();

        Stream<Employee> stream = list.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println("**********");

        list.stream().limit(3).forEach(System.out::println);
        list.add(new Employee(1010,"闫博帅",40,9000));
        list.add(new Employee(1010,"闫博帅",40,9000));
        list.add(new Employee(1010,"闫博帅",40,9000));
        list.add(new Employee(1010,"闫博帅",40,9000));
        //System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
    }
    //映射
    @Test
    public void test5(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stream = employees.stream().map(Employee::getName).filter(name -> name.length() > 3);
        stream.forEach(System.out::println);

        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(StreamApi::fromStringToStream);
        streamStream.forEach(s -> {s.forEach(System.out::println);});
        System.out.println("***********");
        Stream<Character> stream1 = list.stream().flatMap(StreamApi::fromStringToStream);
        stream1.forEach(System.out::println);
    }
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> characters = new ArrayList<>();
        for (Character character : str.toCharArray()){
            characters.add(character);
        }
        return characters.stream();
    }
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(12, 34, 24, 46, 58, 0, 1);
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(System.out::println);
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(
                (e1,e2) -> { return Integer.compare(e1.getAge(), e2.getAge());}
        ).forEach(System.out::println);
    }




}
