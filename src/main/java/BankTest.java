import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yan
 * @create 2022-12-07 20:06
 **/
public class BankTest {
    public static void main(String[] args) {
//        Account1 account1 = new Account1();
//        Thread thread1 = new Thread(account1);
//        Thread thread2 = new Thread(account1);
//        thread2.setName("账户二");
//        thread1.setName("账户一");
//        thread1.start();
//        thread2.start();
//        Account2 account2 = new Account2();
//        Account2 account3 = new Account2();
//        account2.setName("账户一");
//        account3.setName("账户二");
//        account2.start();
//        account3.start();
        Account account = new Account();
        Customer customer = new Customer(account);
        Customer customer2 = new Customer(account);
        customer.setName("客户1");
        customer2.setName("客户2");
        customer.start();
        customer2.start();
    }
}

class Account1 implements Runnable {
    private double balance;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {


            try {
                //noinspection AlibabaLockShouldWithTryFinally
                lock.lock();
                for (int i = 0; i < 3; i++) {
                    notify();
                    balance += 1000;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "存钱" + "余额为：  " + balance);
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

    }


class Account2 extends Thread {

    private static double balance;

    @Override
    public void run() {
        try {

            depositMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void depositMoney() throws InterruptedException {
        for (int i = 0; i < 3; i++) {

            Thread.sleep(100);
            balance += 100;
            System.out.println(Thread.currentThread().getName() + "存钱" + "余额为：  " + balance);
        }
    }
}

class Accoun3 extends Thread{
    private static double balance;
    @Override
    public void run() {

        //synchronized()
        for (int i = 0; i < 3; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance += 100;
            System.out.println(Thread.currentThread().getName() + "存钱" + "余额为：  " + balance);
        }
    }
}

class Account{
    private double balance;
    private Account account;
    private Customer customer;
    Object obj = new Object();
    public void deposit(double money) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            obj.notifyAll();

            if (money > 0){
                balance += money;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"存钱成功！余额为："+balance);
                obj.wait();
            }
        }
    }
}

class Customer extends Thread{
    public Account acct;

    public Account getAcct() {
        return acct;
    }

    public Customer(Account acct){
        this.acct = acct;
    }
    @Override
    public void run() {
        synchronized (acct.obj){

            try {
                acct.deposit(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}