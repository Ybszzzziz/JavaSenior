package IOtest;

import org.junit.Test;

import java.io.*;

/**
 * @author Yan
 * @create 2022-12-21 15:55
 **/
public class FIleReaderWriterTest {
    public static void main(String[] args) {

    }

    @Test
    public void testFileReader(){

        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            //read()返回文件的字符。如果达到文件末尾，返回-1
            //方式一：
//        int read = fileReader.read();
//        while (read != -1){
//            System.out.print((char) read);
//            read = fileReader.read();
//        }
            //方式二
            int read;
            while ((read = fileReader.read()) != -1){
                System.out.print((char) read);
            }
            //流的关闭操作
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null){

                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void test1() throws IOException {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){

                fileReader.close();
            }
        }
    }
    @Test
    public void test2() throws IOException {
        //提供File类的对象，指明写出文件
        File file = new File("hello1.txt");

        //提供FileWriter对象，用于数据的写出
        FileWriter writer = new FileWriter(file,true);

        //写出的的操作
        writer.write("i have a dream\n");
        writer.write("i hava a dick");

        //流资源的关闭
        writer.close();
    }

    @Test
    public void test3(){
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            fileWriter = new FileWriter(destFile);
            fileReader = new FileReader(srcFile);

            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

                try {if (fileReader != null){
                    fileReader.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fileWriter != null){

                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    @Test
    public void testBufferedWriterReader(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello5.txt")));
            //方式一：
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = bufferedReader.read(cbuf)) != -1){
//                bufferedWriter.write(cbuf,0,len);
//            }
            //方式二：
            String data;
            while ((data = bufferedReader.readLine()) != null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null){

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null){

                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
