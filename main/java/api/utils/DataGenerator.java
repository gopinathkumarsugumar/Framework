package api.utils;

import api.payloads.Employee;

public class DataGenerator {
    public static String getRandomEmployeeId() {
        return String.valueOf(System.currentTimeMillis()).substring(7);
    }

    public static Employee getCreateEmployeePayload(String firstName, String lastName) {
        return new Employee(firstName, lastName, getRandomEmployeeId());
    }
}
