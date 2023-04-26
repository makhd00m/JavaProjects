package designPatterns.factory;

import designPatterns.factory.components.Button.Button;
import designPatterns.factory.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatform.WINDOWS);
        UIFactory factory = flutter.createUIFactory();
        Menu menu = factory.createMenu();
        Button button = factory.createButton();
    }
}
