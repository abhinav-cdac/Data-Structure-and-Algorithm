import java.util.Scanner;

public class SinglyCircularLinkedList {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        List list = new List();
	        int choice;
	        do {
	            System.out.println("\n----CIRCULAR SINGLY LINKED LIST MENU----");
	            System.out.println("1. Add First");
	            System.out.println("2. Add Last");
	            System.out.println("3. Add at Position");
	            System.out.println("4. Delete First");
	            System.out.println("5. Delete Last");
	            System.out.println("6. Delete at Position");
	            System.out.println("7. Display");
	            System.out.println("8. Delete All");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter value to add at first: ");
	                    char valueFirst = sc.next().charAt(0);
	                    list.addFirst(valueFirst);
	                    System.out.println("Value added at first.");
	                    break;
	                case 2:
	                    System.out.print("Enter value to add at last: ");
	                    char valueLast = sc.next().charAt(0);
	                    list.addLast(valueLast);
	                    System.out.println("Value added at last.");
	                    break;
	                case 3:
	                    System.out.print("Enter value to add: ");
	                    char valuePos = sc.next().charAt(0);
	                    System.out.print("Enter position to add the value: ");
	                    int pos = sc.nextInt();
	                    list.addPosition(valuePos, pos);
	                    break;
	                case 4:
	                    list.deleteFirst();
	                    break;
	                case 5:
	                    list.deleteLast();
	                    break;
	                case 6:
	                    System.out.print("Enter position to delete: ");
	                    int delPos = sc.nextInt();
	                    list.deletePosition(delPos);
	                    break;
	                case 7:
	                    list.display();
	                    break;
	                case 8:
	                    list.deleteAll();
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
