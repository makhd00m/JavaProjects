package designPatterns.builder.driverbuilder;

import java.security.InvalidParameterException;

/**
 * Use Builder pattern
 * when it is required to create complex object
 * when telescoping constructors are present
 */
public class Driver {
    private String name;
    private int age;
    private String address;

    private Driver(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    // return builder object which takes care of validation and main object creation
    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder setName(String name) {
            this.name = name;
            // method chaining
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Driver build() {

            // validations
            if(this.name.length() < 2)
                throw new InvalidParameterException("Name can't have less than 2 characters");
            if(this.address.length() == 0)
                throw new InvalidParameterException("Address shouldn't be empty");

            // create and return object
            return new Driver(this);
        }
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
}
