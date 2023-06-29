package IOtest;

import java.io.*;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Yan
 * @create 2022-12-21 20:52
 **/
public class Exer {
    public static void main(String[] args) {
        Map<Character, Integer> count = null;
        try {
             count = wordCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Map.Entry<Character, Integer>> iterator = count.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + " == " + value);
        }


    }
    public static Map<Character,Integer> wordCount() throws IOException {
        File outfile = new File("wordCount.txt");
        File inputfile = new File("word.txt");
        FileWriter fileWriter = new FileWriter(outfile);
        FileReader fileReader = new FileReader(inputfile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        HashMap<Character, Integer> map = new HashMap<>();

        char [] cbuf = new char[1024];
        int len;
        while ((len = bufferedReader.read(cbuf)) != -1){
            for (int i = 0; i < len; i++) {
                if (map.containsKey(cbuf[i])){
                    int var = map.get(cbuf[i]);
                    map.put(cbuf[i],++var);
                }else {
                    map.put(cbuf[i],1);
                }
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
        String[] str = new String[map.size()];
        int i = 0;
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> characterIntegerEntry = iterator.next();
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
             str[i] = key.toString() +" === " +value.toString() + "\n";
             i++;
        }
        for (int j = 0; j < i; j++) {
            bufferedWriter.write(str[j].trim());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
        return map;
    }
}
