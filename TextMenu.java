import java.util.Arrays;
import java.util.Scanner;
public class TextMenu {
    private String[] menuItems;
    private Scanner scanner;


    // Constructor
    public TextMenu(String[] menuItems) {
        // Create a new array and copy the contents from the provided array
        this.menuItems = Arrays.copyOf(menuItems, menuItems.length);
        this.scanner = new Scanner(System.in);
    }

    // Method to display the menu
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }

    // Method to validate user choice
    public int validateChoice(String choice) {
        try {
            int numericChoice = Integer.parseInt(choice);
            if (numericChoice >= 1 && numericChoice <= menuItems.length) {
                return numericChoice;
            }
        } catch (NumberFormatException e) {
            // Ignore, and return -1 if not a valid integer choice
        }
        return -1;
    }

    // Method to get user choice
    public int getChoice() {
        int userChoice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            userChoice = validateChoice(input);
            if (userChoice == -1) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice == -1);

        return userChoice;
    }


}
