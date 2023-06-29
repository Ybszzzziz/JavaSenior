package IOtest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Yan
 * @create 2022-12-22 13:31
 **/
public class RandomAccessFile {
    @Test
    public void test1(){
        java.io.RandomAccessFile randomAccessFile = null;
        java.io.RandomAccessFile randomAccessFile1 = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new File("图标.png"), "r");
            randomAccessFile1 = new java.io.RandomAccessFile(new File("图标1.png"), "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile.read(bytes)) != -1){
                randomAccessFile1.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile1 != null){

                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile != null){

                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test2() throws IOException {
        java.io.RandomAccessFile accessFile = new java.io.RandomAccessFile(new File("hello.txt"), "rw");

        StringBuilder stringBuilder = new StringBuilder((int) (new File("hello.txt").length()));
        accessFile.seek(3);

        byte[] bytes = new byte[1024];
        int len;
        while ((len = accessFile.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,len));
        }
        accessFile.seek(3);
        accessFile.write("xyz".getBytes());
        accessFile.write(stringBuilder.toString().getBytes());

        accessFile.close();
    }

}
