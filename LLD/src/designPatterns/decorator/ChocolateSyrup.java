package designPatterns.decorator;

public class ChocolateSyrup implements IceCream {
    private IceCream iceCream;

    public ChocolateSyrup(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        return iceCream.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "\nChocolateSyrup";
    }
}
