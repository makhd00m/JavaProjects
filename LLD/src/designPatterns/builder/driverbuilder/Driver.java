package designPatterns.builder.driverbuilder;

import java.security.InvalidParameterException;

public class Driver {
    private String name;
    private int age;
    private String address;

    private Driver(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {
        private String name;
        private int age;
        private String address;

        public Builder setName(String name) {
            this.name = name;
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
            if(this.name.length() < 2)
                throw new InvalidParameterException("Name can't have less than 2 characters");
            if(this.address.length() == 0)
                throw new InvalidParameterException("Address shouldn't be empty");

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
