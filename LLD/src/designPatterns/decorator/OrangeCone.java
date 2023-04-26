package designPatterns.decorator;

public class OrangeCone implements IceCream {
    private IceCream iceCream;

    public OrangeCone() {}

    public OrangeCone(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        if(iceCream == null) {
            return 15;
        }
        else {
            return iceCream.getCost() + 15;
        }
    }

    @Override
    public String getDescription() {
        if(iceCream == null) {
            return "Orange Cone";
        }
        else {
            return iceCream.getDescription() + "\nOrange Cone";
        }
    }
}
