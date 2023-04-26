package designPatterns.factory;

import designPatterns.factory.components.Button.Button;
import designPatterns.factory.components.dropdown.DropDown;
import designPatterns.factory.components.menu.Menu;

public interface UIFactory {
    Button createButton();
    DropDown createDropDown();
    Menu createMenu();
}
