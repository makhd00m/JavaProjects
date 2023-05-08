package reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Vehicle vehicle = new Vehicle(4, "Black");
        printObject(vehicle);
    }

    static void printObject(Object o) throws IllegalAccessException {
        Class objClass = o.getClass();
        for(Field field : objClass.getDeclaredFields()) {
            String value = "";
            if(field.getType().equals(int.class)) {
                value = String.valueOf(field.getInt(o));
            }
            else if(field.getType().equals(String.class)) {
                value = field.get(o).toString();
            }
            System.out.println("Field : " + field.getName() + ", Value : " + value);
        }
    }
}
