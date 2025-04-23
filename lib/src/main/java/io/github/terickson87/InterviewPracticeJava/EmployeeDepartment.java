package io.github.terickson87.InterviewPracticeJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

record Employee(int Id, String name, int depId) {}

record Department(int Id, String name) {};

record EmployeeDepName (int Id, String name, String depName) {};

public class EmployeeDepartment {
    // Have a service, employee service which return a list of employees, employee ID, name, department ID
    // Can simulate with a static function with a 3 second delay
    // Another function, Department function, return department list with ID and Name, delay 5 seconds
    // Call the functions in parallel
    // Print out employees with department name

    static CompletableFuture<List<Employee>> getEmployees() throws InterruptedException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Tom", 1));
        employees.add(new Employee(2, "Joe", 2));
        employees.add(new Employee(3, "John", 3));

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return employees;
        });
    }

    static CompletableFuture<List<Department>> getDepartments() throws InterruptedException {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "Dep1"));
        departments.add(new Department(2, "Dep2"));
        departments.add(new Department(3, "Dep3"));

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return departments;
        });
    }

    static List<EmployeeDepName> getEmployeesWithDepNames() throws InterruptedException, ExecutionException {
        CompletableFuture<List<Employee>> employees = getEmployees();
        CompletableFuture<List<Department>> departments = getDepartments();
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(employees, departments);
        combinedFuture.get();

        List<EmployeeDepName> employeeDepNames = new ArrayList<>();
        for (Employee employee: employees.get()) {
            String depName = "No Department Name Found";
            for (Department department: departments.get()) {
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
