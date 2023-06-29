package IOtest;

import com.sun.security.ntlm.Server;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yan
 * @create 2022-12-22 15:25
 **/
public class TCPTest {
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream socketOutputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 7894);
            socketOutputStream = socket.getOutputStream();
            socketOutputStream.write("我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketOutputStream != null){

                try {
                    socketOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2(){
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(7894);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,len);

            }
            String s = byteArrayOutputStream.toString();
            System.out.println(s);
            System.out.println("连接来自于:"+accept.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (byteArrayOutputStream != null){

                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            if (inputStream != null){

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null){

                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //服务端接受数据后，保存在本地
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("图标.png"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("图标-copy-copy.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int len ;
        while ((len = inputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,len);
        }

        bufferedOutputStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }

//    服务端接受数据后，保存在本地,并返回返回接收成功
    @Test
    public void client1(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("图标.png"));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }

            socket.shutdownOutput();

            //接收数据
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[5];
            int len1;
            while ((len1 = inputStream.read(bytes1)) != -1){
                byteArrayOutputStream.write(bytes1,0,len1);
            }
            System.out.println(byteArrayOutputStream.toString());

            byteArrayOutputStream.close();
            inputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("图标-copy-copy2.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int len ;
        while ((len = inputStream.read(bytes)) != -1){
            bufferedOutputStream.write(bytes,0,len);
        }
        //给予客户端反馈
        System.out.println("*********");
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("你好美女，照片我已收到".getBytes());

        bufferedOutputStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
        outputStream.close();

    }



}
