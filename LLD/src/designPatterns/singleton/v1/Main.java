package designPatterns.singleton.v1;

public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getObj();
        Singleton s2 = Singleton.getObj();
        Singleton s3 = Singleton.getObj();
    }
}
