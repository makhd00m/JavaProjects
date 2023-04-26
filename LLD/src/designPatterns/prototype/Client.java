package designPatterns.prototype;

public class Client {

    public static StudentRegistry registerBatches(StudentRegistry studentRegistry) {
        Student aprBatch = new Student();
        aprBatch.setAvgBatchPsp(70);
        aprBatch.setBatchName("Apr-Batch");
        aprBatch.setYearOfEnrollment(2022);
        studentRegistry.register(aprBatch);

        Student mayBatch = new Student();
        mayBatch.setAvgBatchPsp(80);
        mayBatch.setBatchName("May-Batch");
        mayBatch.setYearOfEnrollment(2022);
        studentRegistry.register(mayBatch);

        Student janBatch = new Student();
        janBatch.setAvgBatchPsp(90);
        janBatch.setBatchName("Jan-Batch");
        janBatch.setYearOfEnrollment(2023);
        studentRegistry.register(janBatch);

        return studentRegistry;
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        studentRegistry = registerBatches(studentRegistry);

        Student aprilBatchStudent01 = studentRegistry.get("Apr-Batch").clone();
        aprilBatchStudent01.setId(1);
        aprilBatchStudent01.setName("Hayat");
        aprilBatchStudent01.setAge(25);

        System.out.println(aprilBatchStudent01.getId() + "\n" + aprilBatchStudent01.getName() + "\n"
                + aprilBatchStudent01.getBatchName());
    }
}
