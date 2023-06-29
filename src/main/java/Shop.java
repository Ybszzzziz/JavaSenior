/**
 * @author Yan
 * @create 2022-12-08 10:05
 **/
public class Shop {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);
        consumer.setName("消费者");
        producer.setName("生产者");
        consumer.start();
        producer.start();
    }



}

class Consumer extends Thread{

    public Consumer(Clerk clerk){

    }

    @Override
    public void run() {

        try {
            Clerk.sell();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Producer extends Thread{

    public Producer(Clerk clerk){

    }

    @Override
    public void run() {

        try {
            Clerk.product();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Clerk{
    public static int product = 0;
    public Clerk(){

    }

    public synchronized static void product() throws InterruptedException {
        while (true){

            if (product < 20){
                Thread.sleep(100);
                product++;
                System.out.println(Thread.currentThread().getName()+"生产第"+product+"个产品...");
                Clerk.class.notify();
            }else {
                try {
                    Clerk.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

    public synchronized static void sell() throws InterruptedException {
        while (true){

            if ( product > 0){
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName()+"消费第"+product+"个产品...");
                product--;
                Clerk.class.notify();
            }else {
                try {
                Clerk.class.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

}
