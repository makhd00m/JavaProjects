package helloWorldPrinter;

public class HelloWorldPrinter implements Runnable {

    public HelloWorldPrinter() {}

    public void run() {
        System.out.println("Hello World from other class - Current thread name is : " + Thread.currentThread().getName());
    }
}
