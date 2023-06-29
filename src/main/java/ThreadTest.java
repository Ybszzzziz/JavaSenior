import sun.security.jca.GetInstance;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yan
 * @create 2022-12-07 9:59
 **/
public class ThreadTest {
    public static void main(String[] args) {
//        WindowTest windowTest = new WindowTest();
//        Thread thread = new Thread(windowTest);
//        Thread thread2 = new Thread(windowTest);
//        Thread thread3 = new Thread(windowTest);
//        thread.setName("窗口1");
//        thread2.setName("窗口2");
//        thread3.setName("窗口3");
//        thread.start();
//        thread2.start();
//        thread3.start();
//        MThread mThread = new MThread();
//        Thread t1 = new Thread(mThread);
//        Thread t2 = new Thread(mThread);
//        t1.setName("线程一");
//        t2.setName("线程二");
//        t1.start();
//        t2.start();
//        Window window = new Window();
//        Window window1 = new Window();
//        Window window2 = new Window();
//        window.start();
//        window1.start();
//        window2.start();
        Middle middle = new Middle();
        Thread thread = new Thread(middle);
        Thread thread2 = new Thread(middle);
        Thread thread3 = new Thread(middle);
        thread.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
class Middle implements Runnable{
    private int ticket = 100;
    //实例化ReentranLock
    private ReentrantLock lock = new ReentrantLock(true);
    public void run(){
        while (true){
            try {

                //调用Lock（）方法
                //noinspection AlibabaLockShouldWithTryFinally
                lock.lock();

                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+":售票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
//继承Thread类
class Window extends Thread{

    private static int tickets = 100;
    @Override
    public void run() {

        while (true) {
            sell();
        }
    }
    public static synchronized void sell(){
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (tickets > 0){
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+tickets);
            tickets--;
        }
    }
}
//实现Runnable接口，创建类实现抽像方法，将此对象通过参数传递到Thread类中，创建Thread类对象，通过Thread类调用start().
class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

}
//使用实现Runnable接口的方法买票
class WindowTest implements Runnable{
    private  int ticket = 100;

    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName()+":"+"卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }

}
class Bank{
    public Bank(){}
    private static Bank instance = null;
    //懒汉式，什么时候用什么时候实例化
    private static Bank getInstance(){
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
class Bank1{
    public Bank1(){};
    private static Bank instance = new Bank();
    //饿汉式，创建类的时候就实例化
    private static Bank getInstance(){
        return instance;
    }

}
