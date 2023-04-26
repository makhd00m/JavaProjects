package designPatterns.factory;

import designPatterns.factory.components.Button.Button;
import designPatterns.factory.components.Button.WindowsButton;
import designPatterns.factory.components.dropdown.DropDown;
import designPatterns.factory.components.dropdown.WindowsDropDown;
import designPatterns.factory.components.menu.Menu;
import designPatterns.factory.components.menu.WindowsMenu;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public DropDown createDropDown() {
        return new WindowsDropDown();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }
}
