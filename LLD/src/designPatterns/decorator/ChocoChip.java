package designPatterns.decorator;

public class ChocoChip implements IceCream {
    private IceCream iceCream;

    public ChocoChip(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        return iceCream.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "\nChocoChip";
    }
}
