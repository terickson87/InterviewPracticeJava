package io.github.terickson87.InterviewPracticeJava;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EmployeeDepartmentTest {
    @Test
    public void testEmployeeDepName() throws InterruptedException {
        List<EmployeeDepName> employeeDepNames = EmployeeDepartment.getEmployeesWithDepNames();
        List<EmployeeDepName> expected = new ArrayList<>();
        expected.add(new EmployeeDepName(1, "Tom", "Dep1"));
        expected.add(new EmployeeDepName(2, "Joe", "Dep2"));
        expected.add(new EmployeeDepName(3, "John", "Dep3"));
        
        assertTrue(employeeDepNames.size() == expected.size());
        assertTrue(employeeDepNames.containsAll(expected));
    }
}
