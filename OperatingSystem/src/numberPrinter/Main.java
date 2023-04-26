package numberPrinter;

public class Main {

    public Main() {}

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread t1 = new Thread(np);
            t1.start();
        }
    }
}
