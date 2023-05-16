package designPatterns.builder.studentbuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Student s = Student.builder()
                .setId(1)
                .setName("Hayat")
                .setPsp(99)
                .setYoe(2)
                .setAge(25).build();

        System.out.println(s.getName() + " is authorized for interviews.");
    }
}
