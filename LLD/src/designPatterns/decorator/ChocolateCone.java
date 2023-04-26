package designPatterns.decorator;

public class ChocolateCone implements IceCream {
    private IceCream iceCream;

    public ChocolateCone() {}

    public ChocolateCone(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        if(iceCream == null) {
            return 20;
        }
        else {
            return iceCream.getCost() + 20;
        }
    }

    @Override
    public String getDescription() {
        if(iceCream == null) {
            return "Chocolate Cone";
        }
        else {
            return iceCream.getDescription() + "\nChocolate Cone";
        }
    }
}
