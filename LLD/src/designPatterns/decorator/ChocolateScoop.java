package designPatterns.decorator;

public class ChocolateScoop implements IceCream {
    private IceCream iceCream;

    public  ChocolateScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        return iceCream.getCost() + 25;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "\nChocolateScoop";
    }
}
