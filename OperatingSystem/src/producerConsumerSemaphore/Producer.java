package producerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaphoreProducer;
    private Semaphore semaphoreConsumer;

    public Producer(Queue<Shirt> store, int maxSize, String name, Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaphoreProducer = semaphoreProducer;
        this.semaphoreConsumer = semaphoreConsumer;
    }

    public void run() {
        try {
            while(true) {
                this.semaphoreProducer.acquire();
                System.out.println("Current store size is - " + this.store.size() + ", adding shirt to store - " + this.name);
                this.store.add(new Shirt());
                this.semaphoreConsumer.release();
            }
        } catch(InterruptedException e1) {
            throw new RuntimeException(e1);
        }
    }
}
