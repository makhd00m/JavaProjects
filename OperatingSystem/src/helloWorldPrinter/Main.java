package helloWorldPrinter;

public class Main {

    public Main() {}

    public static void doPrinting() {
        System.out.println("Hello World - thread name is : " +Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Hello World printed from : " + Thread.currentThread().getName());
        HelloWorldPrinter hw = new HelloWorldPrinter();
        Thread t1 = new Thread(hw);

        t1.start();
        doPrinting();
        doPrinting();
    }
}
