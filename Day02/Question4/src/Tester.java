import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of queue: ");
		int size = sc.nextInt();
		LinearQueue queue = new LinearQueue(size);
		int choice;
		do {
			System.out.println("--------MENU--------");
			System.out.println("0. EXIT\n1. PUSH\n2. POP\n3. PEEK");
			System.out.print("ENTER YOUR CHOICE: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter value to be entered: ");
				int value = sc.nextInt();
				queue.push(value);
				break;
			case 2:
			    int ele = queue.pop();
			    if(ele !=-1) {
			    	System.out.println("Popped element: "+ele);
			    }
				break;
			case 3:
				int ele1 = queue.peek();
				if(ele1!=-1) {
					System.out.println("Peeked element: "+ele1);
				}
				break;
			}
		} while (choice != 0);
		System.out.println("Exiting.....");
	}

}
