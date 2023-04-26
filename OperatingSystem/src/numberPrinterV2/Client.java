package numberPrinterV2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public Client() {}

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executor.execute(np);
        }

        executor.shutdown();
    }
}
