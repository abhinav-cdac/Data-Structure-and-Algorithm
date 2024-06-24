
import java.util.Scanner;

class Employee {
    int empId;
    String name;
    double salary;
    Employee next;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.next = null;
    }
}

class EmployeeList {
    private Employee head;

    public EmployeeList() {
        this.head = null;
    }

    public void addEmployee(int empId, String name, double salary) {
        Employee newEmployee = new Employee(empId, name, salary);
        if (head == null) {
            head = newEmployee;
        } else {
            Employee current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEmployee;
        }
    }

    public void displayEmployees() {
        Employee current = head;
        while (current != null) {
            System.out.println("ID: " + current.empId + ", Name: " + current.name + ", Salary: " + current.salary);
            current = current.next;
        }
    }

    public void searchEmployeeByName(String name) {
        Employee current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("ID: " + current.empId + ", Name: " + current.name + ", Salary: " + current.salary);
                return;
            }
            current = current.next;
        }
        System.out.println("Employee not found.");
    }

    public void deleteEmployeeById(int empId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.empId == empId) {
            head = head.next;
            System.out.println("Employee with ID " + empId + " deleted.");
            return;
        }

        Employee current = head;
        while (current.next != null && current.next.empId != empId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Employee with ID " + empId + " deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateSalary(int empId, double newSalary) {
        Employee current = head;
        while (current != null) {
            if (current.empId == empId) {
                current.salary = newSalary;
                System.out.println("Salary updated for employee ID " + empId);
                return;
            }
            current = current.next;
        }
        System.out.println("Employee not found.");
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeList list = new EmployeeList();
        int choice;
        do {
            System.out.println("\n----EMPLOYEE MANAGEMENT MENU----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by Name");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Update Salary of Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    list.addEmployee(empId, name, salary);
                    System.out.println("Employee added.");
                    break;
                case 2:
                    list.displayEmployees();
                    break;
                case 3:
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter Employee Name to Search: ");
                    String searchName = sc.nextLine();
                    list.searchEmployeeByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();
                    list.deleteEmployeeById(deleteId);
                    break;
                case 5:
                    System.out.print("Enter Employee ID to Update Salary: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    list.updateSalary(updateId, newSalary);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
