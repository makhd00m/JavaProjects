package mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public Client() {}

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(5, 4, 7, 1, 6, 3, 2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(list, executorService);
        Future<List<Integer>> sortedListFuture = executorService.submit(sorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
        executorService.shutdown();
    }
}
