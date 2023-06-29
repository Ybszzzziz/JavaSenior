package IOtest;

import java.io.Serializable;

/**
 * @author Yan
 * @create 2022-12-22 11:39
 **/
public class Person implements Serializable {
    public static final long serialVersionUID = 897465652123L;
    private int age;
    private String name;

    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
