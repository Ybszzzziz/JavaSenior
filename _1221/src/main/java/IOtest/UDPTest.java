package IOtest;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Yan
 * @create 2022-12-22 16:51
 **/
public class UDPTest {
    /**发送端
     *
     */
    @Test
    public void sender() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "我是UDP方式发送的导弹";
        byte[] bytes = str.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length, InetAddress.getLocalHost(),9090);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }

    //接收端

    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new java.lang.String(datagramPacket.getData(),0,datagramPacket.getLength()));
    }
}
