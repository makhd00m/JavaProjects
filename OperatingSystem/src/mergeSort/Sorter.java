package mergeSort;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    public List<Integer> call() throws Exception {
        if(this.arrayToSort.size() <= 1) {
            return this.arrayToSort;
        } else {

            int mid = this.arrayToSort.size() >> 1;
            List<Integer> leftArrayToSort = new ArrayList<>();
            List<Integer> rightArrayToSort = new ArrayList<>();

            for(int i = 0; i < mid; i++)
                leftArrayToSort.add((Integer)this.arrayToSort.get(i));

            for(int i = mid; i < this.arrayToSort.size(); i++)
                rightArrayToSort.add((Integer)this.arrayToSort.get(i));

            Sorter leftSorter = new Sorter(leftArrayToSort, this.executorService);
            Sorter rightSorter = new Sorter(rightArrayToSort, this.executorService);

            Future<List<Integer>> leftSortedArrayFuture = this.executorService.submit(leftSorter);
            Future<List<Integer>> rightSortedArrayFuture = this.executorService.submit(rightSorter);

            List<Integer> leftArray = leftSortedArrayFuture.get();
            List<Integer> rightArray = rightSortedArrayFuture.get();

            List<Integer> sortedArray = new ArrayList<>();
            int i = 0;
            int j = 0;

            while(i < leftArray.size() && j < rightArray.size()) {
                if(leftArray.get(i) < rightArray.get(j)) {
                    sortedArray.add(leftArray.get(i));
                    i++;
                } else {
                    sortedArray.add(rightArray.get(j));
                    j++;
                }
            }

            while(i < leftArray.size()) {
                sortedArray.add(leftArray.get(i));
                i++;
            }
            while (j < rightArray.size()) {
                sortedArray.add(rightArray.get(j));
                j++;
            }

            return sortedArray;
        }
    }
}
