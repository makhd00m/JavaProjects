package designPatterns.decorator;

public class VanillaScoop implements IceCream {
    private IceCream iceCream;

    public VanillaScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public float getCost() {
        return iceCream.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + "\nVanilla Scoop";
    }
}
