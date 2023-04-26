package producerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaphoreProducer;
    private Semaphore semaphoreConsumer;

    public Consumer(Queue<Shirt> store, int maxSize, String name, Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaphoreProducer = semaphoreProducer;
        this.semaphoreConsumer = semaphoreConsumer;
    }

    public void run() {
        try {
            while(true) {
                this.semaphoreConsumer.acquire();
                System.out.println("Current store size is - " + this.store.size() + ", removing from store - " + this.name);
                this.store.remove();
                this.semaphoreProducer.release();
            }
        } catch (InterruptedException e2) {
        }
    }
}
