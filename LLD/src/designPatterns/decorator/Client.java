package designPatterns.decorator;

public class Client {
    public static void main(String[] args) {
        IceCream ic = new ChocoChip(new ChocolateScoop(new VanillaScoop(new ChocolateCone(new ChocolateSyrup(new OrangeCone())))));

        System.out.println("Total Cost : " + ic.getCost());
        System.out.println(ic.getDescription());
    }
}
