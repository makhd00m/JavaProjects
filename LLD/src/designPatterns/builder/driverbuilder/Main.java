package designPatterns.builder.driverbuilder;

public class Main {

    public static void main(String[] args) {
        Driver.Builder builder = Driver.getBuilder();

        Driver driver1 = builder.setName("Hayat")
                .setAge(25)
                .setAddress("Whitefield, Bangalore")
                .build();

        Driver driver2 = builder.setName("Akash")
                .setAge(25)
                .setAddress("Electronics City, Bangalore")
                .build();

        System.out.println(driver1);
        System.out.println(driver2);
    }
}
