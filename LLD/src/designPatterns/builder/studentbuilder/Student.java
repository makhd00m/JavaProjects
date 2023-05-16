package designPatterns.builder.studentbuilder;

public class Student {
    private int id;
    private String name;
    private int psp;
    private int yoe;
    private int age;

    private Student(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.psp = b.psp;
        this.yoe = b.yoe;
        this.age = b.age;
    }

    static class Builder {
        private int id;
        private  String name;
        private int psp;
        private int yoe;
        private int age;

        public Builder() {}

        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setPsp(int psp) {
            this.psp = psp;
            return this;
        }
        public Builder setYoe(int yoe) {
            this.yoe = yoe;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Student build() throws Exception {

            if(this.psp < 70)
                throw new Exception();
            if(this.yoe < 2)
                throw new Exception();
            if(this.age < 18)
                throw new Exception();

            Student s = new Student(this);
            return s;
        }
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getPsp() {
        return this.psp;
    }
    public int getYoe() {
        return this.yoe;
    }
    public int getAge() {
        return this.age;
    }
    public static Builder builder() {
        Builder b = new Builder();
        return b;
    }
}
