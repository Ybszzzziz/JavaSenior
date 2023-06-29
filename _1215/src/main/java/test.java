import org.junit.Rule;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Yan
 * @create 2022-12-15 15:37
 **/
public class test {

    @Test
    public void test1(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(new String("王伟"));
        list.add("abc");
        list.add(123);
        System.out.println(list);
        list.add(2,"BB");
        System.out.println(list);

        List asList = Arrays.asList(1, 23, 3);
         list.addAll(asList);
        System.out.println(list.size());
        Iterator it = list.iterator();
        System.out.println("**********");
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
    @Test
    public void test3(){
        HashMap map = new HashMap();
        map.put("AA",123);
        map.put("CC",124);
        map.put("BB",125);
        map.put("AA",126);
        System.out.println(map);

        HashMap map1 = new HashMap();
        map1.put("YY",978);
        map1.putAll(map);
        System.out.println(map1);
        Object cc = map.remove("CC");
        System.out.println("****");
        System.out.println(cc);
        System.out.println(map);

        map.clear();
        System.out.println(map);


    }
    @Test
    public void test4(){
        HashMap map = new HashMap();
        map.put("AA",123);
        map.put("CC",124);
        map.put("BB",125);
        map.put("AA",126);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            Object obj = map.get(next);
            System.out.println(next+"===="+obj);
        }
        System.out.println("****************");
        Collection values = map.values();
        for (Object i : values){
            System.out.println(i);
        }
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey()+"---->"+entry.getValue()  );
        }

    }

    @Test
    public void test6(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(1679);
        list.add(1346);
        list.add(134);
        list.add(1234);
        List objects = Arrays.asList(new Object[list.size()]);
        Collections.copy(objects,list);
        System.out.println(objects);
    }
    @Test
    public void test7(){
        HashMap map = new HashMap();
        map.put(1001,12);
        map.put(1004,13);
        map.put(1003,14);
        map.put(1002,15);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test8() throws IOException {
        File file = new File("C:\\Users\\23694\\Desktop\\闫博帅\\helloworld.txt");
        File file1 = new File(file.getParent(), "Golang.txt");
        file1.createNewFile();
        System.out.println(file.getName());

    }
    @Test
    public void test9(){
        File file1 = new File("C:\\Users\\23694\\Desktop\\闫博帅");
        File[] files = file1.listFiles();
        for (File f : files){

            if (f.getName().endsWith(".jpg")){
                System.out.println(f.getName());
            }else {
                System.out.println("error");
            }


        }

    }
    @Test
    public void test10() throws IOException {
        File file = new File("C:\\Users\\23694\\Desktop\\闫博帅\\新建文件夹\\a.txt");
        File file1 = new File(file.getParent(),"b.txt");
        file1.createNewFile();
    }











}
