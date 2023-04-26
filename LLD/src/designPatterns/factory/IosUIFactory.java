package designPatterns.factory;

import designPatterns.factory.components.Button.IosButton;
import designPatterns.factory.components.Button.Button;
import designPatterns.factory.components.dropdown.DropDown;
import designPatterns.factory.components.dropdown.IosDropDown;
import designPatterns.factory.components.menu.IosMenu;
import designPatterns.factory.components.menu.Menu;

public class IosUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public DropDown createDropDown() {
        return new IosDropDown();
    }

    @Override
    public Menu createMenu() {
        return new IosMenu();
    }
}
