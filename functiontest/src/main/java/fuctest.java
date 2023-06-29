import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Yan
 * @create 2022-12-26 10:40
 **/
public class fuctest {


    @Test
    public void test3(){
        Comparator<String> comparator = String::compareTo;

        Person p = new Person("闫",24);
        Person p1 = new Person("闫",24);


        System.out.println(comparator.compare("abc", "abc"));
        System.out.println(comparator.compare(p1.name, p.name));
    }

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("价格为："+aDouble);
            }
        });


    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","天津","南京","东京","西京","普京");

        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);
        List<String> filterString1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterString1);


    }

    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){

                stringArrayList.add(s);


            }

        }
        return stringArrayList;

    }

}
class Person{
    public String name;
    public int age;

    public Person(String name,int age){

        this.name = name;
        this.age = age;
    }

    public Person(){

    }



}
