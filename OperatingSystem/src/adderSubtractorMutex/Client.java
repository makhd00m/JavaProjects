package adderSubtractorMutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public Client() {}

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Lock lock = new ReentrantLock();

        Adder a = new Adder(c, lock);
        Subtractor s = new Subtractor(c, lock);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count value is : " + c.value);
    }
}
