package IOtest;

import org.junit.Test;

import java.io.*;

/**
 * @author Yan
 * @create 2022-12-21 22:24
 **/
public class InputStreamReaderTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        char[] chars = new char[5];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
        inputStreamReader.close();
        fileInputStream.close();

    }
    @Test
    public void test2() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("hello.txt")));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("hello-gbk.txt")),"gbk");
        char[] chars = new char[5];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            outputStreamWriter.write(chars,0,len);
        }
        outputStreamWriter.close();
        inputStreamReader.close();


    }

}
