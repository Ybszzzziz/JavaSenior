package IOtest;

import org.junit.Test;

import java.io.*;

/**
 * @author Yan
 * @create 2022-12-22 11:29
 **/
public class ObjectInputOutputStreamTest {
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));

            oos.writeObject(new String("阿里巴巴"));
            oos.flush();
            oos.writeObject(new Person(18,"黎明"));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null){

                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));

            Object o = ois.readObject();
            String str = (String) o;
            System.out.println(str);
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null){

                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
