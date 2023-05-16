package designPatterns.singleton.v2;

public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {
        return InnerStaticClass.instance;
    }

    private static class InnerStaticClass {
        private static final Singleton instance = new Singleton();
    }
}
