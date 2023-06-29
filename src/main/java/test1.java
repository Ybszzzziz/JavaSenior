import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author Yan
 * @create 2022-12-12 16:39
 **/
public class test1 {


    @Test
    public void test() throws UnsupportedEncodingException {
//


    }

    public static void main(String[] args) {
//        test1 test1 = new test1();
//        String string = test1.trim2("   hello world");
//        System.out.println(string);
        int i = 5;
        int j = 2;
        System.out.println(i/j);

    }


    @Test
    public String trim2(String str){
        int i = 0;
        while (true){
            if (str.charAt(i) != ' '){
                break;
            }else {
                i++;
            }
        }
        int j = str.length()-1;
        while (true){
            if (str.charAt(j) != ' '){
                break;
            }else {
                j--;
            }
        }
        String newstr = str.substring(i,j+1);
        return newstr;
    }



}

