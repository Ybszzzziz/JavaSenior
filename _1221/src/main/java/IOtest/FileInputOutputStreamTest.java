package IOtest;

import org.junit.Test;

import java.io.*;

/**
 * @author Yan
 * @create 2022-12-21 17:03
 **/
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputStream(){
        //造文件
        FileInputStream stream = null;
        try {
            File file = new File("hello.txt");

            //造流
            stream = new FileInputStream(file);

            //读数据
            byte[] bytes = new byte[1024];

            int len;
            while ((len = stream.read(bytes)) != -1){
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null){

                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //关闭流
    }
    @Test
    public void testFileInputOutputStream(){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello3.txt");

            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file1);

            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null)
                {
                    outputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (inputStream != null){

                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void testUp(){

        long start = System.currentTimeMillis();
        allTest("hello.txt","hello4.txt");
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));

    }
    public void allTest(String srcfile,String destfile){
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File file = new File(srcfile);
            File file1 = new File(destfile);

            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file1);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null)
                {
                    outputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (inputStream != null){

                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void BufferedStreamTest(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File("图标.png");
            File file1 = new File("图标-copy.png");

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOutputStream != null){

                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null){

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null){

                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void copyWithBuffered(String srcPath,String destPath){

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedOutputStream != null){

                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null){

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null){

                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void testCopyWithBuffered(){

        long start = System.currentTimeMillis();
        copyWithBuffered("图标.png","图标-copy1.png");
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));

    }
}
