package StreamAPITest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yan
 * @create 2023-01-06 20:12
 **/
public class StreamApi2 {
    //1.匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(p -> p.getAge() > 18);
        System.out.println(b);
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() > 10000));
        System.out.println(employees.stream().noneMatch(employee -> employee.getName().startsWith("雷")));
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println(employees.parallelStream().findAny());
    }
    @Test
    public void test2(){

        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(employee -> employee.getSalary() > 5000).count();
        System.out.println(count);
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> max = doubleStream.max(Double::compareTo);
        System.out.println(max);
        System.out.println("**********");
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
        employees.stream().forEach(System.out::println);
        employees.forEach(System.out::println);
    }
    //2.归约
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 46, 21, 23);
        Integer reduce = list.stream().reduce(2, Integer::sum);
        System.out.println(reduce);


        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);

    }
    //3.收集
    @Test
    public void test4(){
        List<Employee> employees = EmployeeData.getEmployees();
        Set<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }
}
