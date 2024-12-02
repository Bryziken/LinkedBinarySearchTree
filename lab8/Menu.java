package lab8;
import java.util.Scanner;
public class Menu {

	private LinkedBinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();

	 public void mainMenu() {
	        System.out.println("\nPlease input an integer number 0-5:");
	        System.out.println("    1: Insert a node.");
	        System.out.println("    2: Delete a node.");
	        System.out.println("    3: Search a node.");
	        System.out.println("    4: Display BST.");
	        System.out.println("    0: Exit.");
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

	        while (scanner.hasNext()) {
	            if (scanner.hasNextInt()) {
	                switch (scanner.nextInt()) {
	                    case 0:
	                        System.out.println("Exiting system!");
	                        return;
	                    case 1:
	                        System.out.println("Insert a new node.");
	                        insertMenu();
	                        break;
	                    case 2:
	                        System.out.println("Delete a node.");
	                        deleteMenu();
	                        break;
	                    case 3:
	                        System.out.println("Search a node.");
	                        searchMenu();
	                        break;
	                    case 4:
	                        bst.inOrder(bst.root()); // Display the BST using in-order traversal
	                        break;
	                    default:
	                        System.out.println("Invalid input, please try again!");
	                        break;
	                }
	                System.out.println("\nPlease input an integer number 0-5:");
	                System.out.println("    1: Insert a new node.");
	                System.out.println("    2: Delete a node.");
	                System.out.println("    3: Search a node.");
	                System.out.println("    4: Display BST.");
	                System.out.println("    0: Exit.");
	            } else {
	                System.out.println("Invalid input, please try again!");
	                scanner.next();
	            }
	        }
	    }

	 public void insertMenu() {
		 @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	     System.out.println("Please input a node (positive integer number) to be inserted (input <= 0: return to Main Menu):");

	     while (scanner.hasNext()) {
	    	 if (scanner.hasNextInt()) {
	         int num = scanner.nextInt();
	         if (num <= 0)
	        	 break;

	         bst.insert(num);
	         System.out.println("Node inserted.");
	         break;
	    	 } else {
	    		 System.out.println("Invalid input, please try again!");
	             scanner.next();
	    	 }
	     }
	 }

	 public void searchMenu() {
	        System.out.println("Please input a node (positive integer number) to be searched (input <= 0: return to Main Menu):");
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

	        while (scanner.hasNext()) {
	            if (scanner.hasNextInt()) {
	                int num = scanner.nextInt();
	                if (num <= 0)
	                    break;

	                if (bst.search(bst.root(), num) != null)
	                    System.out.println("Node found!");
	                else
	                    System.out.println("Node not found!");

	                break;
	            } else {
	                System.out.println("Invalid input, please try again!");
	                scanner.next();
	            }
	        }
	    }

	 public void deleteMenu() {
	        System.out.println("Please input a node (positive integer number) to be deleted (input <= 0: return to Main Menu):");
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

	        while (scanner.hasNext()) {
	            if (scanner.hasNextInt()) {
	                int num = scanner.nextInt();
	                if (num <= 0)
	                    break;

	                if (bst.delete(num) != null)
	                    System.out.println("Node deleted.");
	                else
	                    System.out.println("Node not found!");

	                break;
	            } else {
	                System.out.println("Invalid input, please try again!");
	                scanner.next();
	            }
	        }
	    }
}