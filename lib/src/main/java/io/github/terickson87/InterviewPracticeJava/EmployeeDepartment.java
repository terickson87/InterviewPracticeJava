package io.github.terickson87.InterviewPracticeJava;

import java.util.ArrayList;
import java.util.List;

record Employee(int Id, String name, int depId) {}

record Department(int Id, String name) {};

record EmployeeDepName (int Id, String name, String depName) {};

public class EmployeeDepartment {
    // Have a service, employee service which return a list of employees, employee ID, name, department ID
    // Can simulate with a static function with a 3 second delay
    // Another function, Department function, return department list with ID and Name, delay 5 seconds
    // Call the functions in parallel
    // Print out employees with department name

    static List<Employee> getEmployees() throws InterruptedException {
        Thread.sleep(3000);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Tom", 1));
        employees.add(new Employee(2, "Joe", 2));
        employees.add(new Employee(3, "John", 3));

        return employees;
    }

    static List<Department> getDepartments() throws InterruptedException {
        Thread.sleep(5000);
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "Dep1"));
        departments.add(new Department(2, "Dep2"));
        departments.add(new Department(3, "Dep3"));

        return departments;
    }

    static List<EmployeeDepName> getEmployeesWithDepNames() throws InterruptedException {
        List<Employee> employees = getEmployees();
        List<Department> departments = getDepartments();

        List<EmployeeDepName> employeeDepNames = new ArrayList<>();
        for (Employee employee: employees) {
            String depName = "No Department Name Found";
            for (Department department: departments) {
                if (department.Id() == employee.depId()) {
                    depName = department.name();
                }
            }
            EmployeeDepName employeeDepName = new EmployeeDepName(employee.Id(), employee.name(), depName);
            employeeDepNames.add(employeeDepName);
        }

        return employeeDepNames;
    }
}
