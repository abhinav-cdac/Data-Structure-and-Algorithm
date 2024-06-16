package Day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question4 {
	public static Employee searchById(Employee[] emparr, int id) {
		for (int i = 0; i < emparr.length; i++) {
			if (id == emparr[i].getEmpid()) {
				return emparr[i];
			}
		}
		return null;
	}

	public static Employee[] searchByName(Employee[] emparr, String name) {
		List<Employee> emplist = new ArrayList<Employee>();
		for(Employee emp : emparr) {
			if(name.equals(emp.getName())){
				emplist.add(emp);
			}
		}
		return emplist.toArray(new Employee[0]);
	}

	public static Employee[] searchBySalary(Employee[] emparr, Double salary) {
		List<Employee> emplist = new ArrayList<Employee>();
		for(Employee emp : emparr) {
			if(salary == emp.getSalary()){
				emplist.add(emp);
			}
		}
		return emplist.toArray(new Employee[0]);
	}

	public static void main(String[] args) {
		Employee[] emparr = new Employee[5];
		emparr[0] = new Employee(101, "Alice", 75000);
		emparr[1] = new Employee(102, "Virat", 80000);
		emparr[2] = new Employee(103, "Warner", 70000);
		emparr[3] = new Employee(104, "Bob", 90000);
		emparr[4] = new Employee(105, "Virat", 90000);

		// Search by id
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter EMPID to search Employee:");
		int empid = sc.nextInt();
		Employee emp1 = searchById(emparr, empid);
		if (emp1 != null) {
			System.out.println(emp1);
		} else {
			System.out.println("Employee Not Found");
		}
		System.out.print("Enter EMPNAME to search Employee:");
		String empname = sc.next();
		
		Employee[] emp2 = searchByName(emparr, empname);
		if(emp2.length>0) {
			for(Employee emp : emp2) {
				System.out.println(emp);
			}
		}else {
			System.out.println("Employee Not Found");
		}
		System.out.print("Enter EMPSALARY to search Employee:");
		double salary = sc.nextDouble();
		Employee[] emp3 = searchBySalary(emparr, salary);
		if(emp3.length>0) {
			for(Employee emp : emp3) {
				System.out.println(emp);
			}
		}else {
			System.out.println("Employee Not Found");
		}
	}

}

class Employee {
	private int empid;
	private String name;
	private double salary;

	public Employee(int empid, String name, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
	}

}

/*
 * 1. Create array of employees and search employee by i. empid ii. name iii.
 * salary
 */