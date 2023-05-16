package designPatterns.singleton.v1;

public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getObj() {

        if (instance == null) {
            // use synchronized block only, when instance is null
            synchronized (instance) {
                // use double check locking to handle concurrency
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
