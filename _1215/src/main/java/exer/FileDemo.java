package exer;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Yan
 * @create 2022-12-21 11:10
 **/
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\23694\\Desktop\\闫博帅");
        System.out.println(deleteAllFile(file));

    }
    public static boolean deleteFile(File file1){
        File file = new File(file1.getParent(),file1.getName());
        if (file.delete()){
            return true;
        }else {
            return false;
        }
    }
    public static String showJpg(File file){
        File file1 = new File(file.getParent(),file.getName());
        String[] list = file1.list();
        for (String i : list){

            if (i.endsWith(".jpg")){
                return i;
            }else {
                return null;
            }
        }
        return null;
    }
    public static Long searchFile(File file){
        File[] files = file.listFiles();
        Long sum = 0L;
        for (File f : files){
            if (f.isDirectory()){
                searchFile(f);
            }else {
                sum += f.length();
            }
        }
        return sum;
    }
    public static boolean deleteAllFile(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                deleteAllFile(f);
            }else {
                f.delete();
                return true;
            }
        }
        return false;
    }
    public List<String> getValue(HashMap<String,String> hashMap){
        ArrayList<String> list = new ArrayList<>();
        Collection<String> values = hashMap.values();
        hashMap.put("123","456");
        hashMap.put("yangwei","4346");
        hashMap.put("zaoxie","4234");
        hashMap.put("erzi","4123");
        list.addAll(values);
        return list;

    }
}
