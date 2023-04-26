package numberPrinterV2;

public class NumberPrinter implements Runnable {

    private int number;

    public NumberPrinter(int number) {this.number = number;}

    public void run() {
        System.out.println("Number " + this.number + " is printed from thread " + Thread.currentThread().getName());
    }
}
