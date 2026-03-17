import java.util.ArrayList;
import java.util.List;

// 1. Interface defining Departmental behaviors
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// 2. Abstract Base Class demonstrating Abstraction and Encapsulation
abstract class Employee implements Department {
    // Private fields to restrict direct access (Encapsulation)
    private int employeeId;
    private String name;
    private double baseSalary;
    private String departmentName;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.departmentName = "Unassigned";
    }

    // Getter and Setter methods for Encapsulation
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    // Concrete method to display general information
    public void displayDetails() {
        System.out.printf("ID: %d | Name: %-10s | Dept: %-12s | Total Pay: $%.2f%n",
                employeeId, name, departmentName, calculateSalary());
    }

    // Implementation of Department interface methods
    @Override
    public void assignDepartment(String deptName) {
        this.departmentName = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department Name: " + departmentName;
    }
}

// 3. Subclass for Full-Time Employees
class FullTimeEmployee extends Employee {
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculateSalary() {
        // Full-time salary = base salary + fixed bonus
        return getBaseSalary() + fixedBonus;
    }
}

// 4. Subclass for Part-Time Employees
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, int hoursWorked, double hourlyRate) {
        // Base salary is set to 0 as it's calculated by hours
        super(employeeId, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        // Part-time salary = hours * rate
        return hoursWorked * hourlyRate;
    }
}

// 5. Main Class to execute the system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Use a List of Employee references to demonstrate Polymorphism
        List<Employee> employeeList = new ArrayList<>();

        // Instantiate subclasses and assign departments
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "John Doe", 5000.0, 1500.0);
        emp1.assignDepartment("IT Solutions");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Jane Smith", 80, 25.0);
        emp2.assignDepartment("Marketing");

        FullTimeEmployee emp3 = new FullTimeEmployee(103, "Robert Fox", 4500.0, 1000.0);
        emp3.assignDepartment("HR");

        // Adding different types to the same list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Process the list using the Employee reference (Polymorphism)
        System.out.println("--- Employee Payroll Summary ---");
        for (Employee emp : employeeList) {
            emp.displayDetails();
        }
    }
}