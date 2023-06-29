package HashTab;

/**
 * @author Yan
 * @create 2023-04-02 11:11
 **/
public class test extends Thread{
    public static void main(String[] args) {

        test test = new test();
        test.getSuper();
    }
    public void getSuper(){
        System.out.println(super.getClass().getName());
    }

}

