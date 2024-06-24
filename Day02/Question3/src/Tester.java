
public class Tester {

	public static void sortEmployeeBySalary(Employee[] emparr) {
		for (int i = 1; i<emparr.length; i++) {
			Employee temp = emparr[i];
			int j;
			for(j = i -1; j>=0 && emparr[j].getSalary()>temp.getSalary(); j--) {
				emparr[j+1] = emparr[j];
			}
			emparr[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		Employee[] emparr = new Employee[5];
		emparr[0] = new Employee(101, "Alice", 75000);
		emparr[1] = new Employee(102, "Virat", 80000);
		emparr[2] = new Employee(103, "Warner", 70000);
		emparr[3] = new Employee(104, "Bob", 90000);
		emparr[4] = new Employee(105, "Virat", 90000);
		System.out.println("Employee before sorting:");
		for(Employee emp : emparr) {
			System.out.println(emp);
		}
		System.out.println("Employee after sorting:");
		sortEmployeeBySalary(emparr);
		for(Employee emp : emparr) {
			System.out.println(emp);
		}
	}

}
