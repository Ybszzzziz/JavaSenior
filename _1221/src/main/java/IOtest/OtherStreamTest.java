package IOtest;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yan
 * @create 2022-12-22 9:52
 **/
public class OtherStreamTest {
    public static void main(String[] args) {


            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
                isr = new InputStreamReader(System.in);
                br = new BufferedReader(isr);

                while (true){
                    System.out.println("请输入字符串");
                    String s = br.readLine();
                    if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                        System.out.println("程序退出");
                        break;
                    }
                    System.out.println(s.toUpperCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null){

                        br.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (isr != null){

                        isr.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }

    }


