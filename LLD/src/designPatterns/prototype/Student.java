package designPatterns.prototype;

public class Student implements Prototype<Student> {
    private int id;
    private String name;
    private int age;
    private int avgBatchPsp;
    private String batchName;
    private int yearOfEnrollment;

    public Student() {}

    public Student(Student student) {
        this.avgBatchPsp = student.avgBatchPsp;
        this.batchName = student.batchName;
        this.yearOfEnrollment = student.yearOfEnrollment;
    }

    public Student clone() {
        return new Student(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(int avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    public String getBatchName() {
        return this.batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }
}
