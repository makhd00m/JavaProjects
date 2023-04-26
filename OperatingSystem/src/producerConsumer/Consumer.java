package producerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String name;

    public Consumer(Queue<Shirt> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run() {
        while(true) {
            System.out.println("Current store size is - " + this.store.size() + ", removing from store - " + this.name);
            this.store.remove();
        }
    }
}
