import java.util.Scanner;

public class CollectionDriver {
    private Scanner scanner;

    public CollectionDriver() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CollectionDriver driver = new CollectionDriver();
        Collection collection = new Collection();
        driver.setup(collection);
    }

    public void setup(Collection collection) {
        String[] menuItems = {
                "Add a Vehicle",
                "Edit a Vehicle",
                "Search for a Vehicle",
                "Display Vehicles That Need Work",
                "Display the Entire Collection",
                "Load from a file",
                "Write to a file",
                "Delete a Vehicle",
                "Quit"
        };

        TextMenu textMenu = new TextMenu(menuItems);

        int choice;
        do {
            choice = textMenu.getChoice();
            processChoice(choice, collection);
        } while (choice != menuItems.length);
    }

    private void processChoice(int choice, Collection collection) {
        switch (choice) {
            case 1:
                addVehicle(collection);
                break;
            case 2:
                System.out.print("Enter plate number: ");
                String plateNumber = scanner.nextLine();
                collection.updateVehicle(plateNumber);
                break;
            case 3:
                System.out.print("Enter plate number: ");
                String plateNumber3 = scanner.nextLine();
                collection.displayVehicle(plateNumber3);
                break;
            case 4:
                collection.needsWork();
                break;
            case 5:
                System.out.print("JAY’S VEHICLE COLLECTION \n");
                System.out.printf("%-10s%-10s%-10s%-25s%-15s%-10s%-15s\n",
                        "Tag No.", "Year", "Manuf.", "Model", "Type"," ", "Acquired");
                collection.displayCollection();
                break;
            case 6:
                System.out.print("Enter the name of the file to be read: ");
                String fileName = scanner.nextLine();
                collection.readFile(fileName);
                break;
            case 7:
                System.out.print("Enter the name of the file to be written: ");
                String fileName1 = scanner.nextLine();
                collection.writeFile(fileName1);
                break;
            case 8:
                System.out.print("Enter the Plate Number: ");
                String plateNumber8 = scanner.nextLine();
                collection.removeVehicle(plateNumber8);
                break;
            case 9:
                System.out.println("Program Exiting.");
                System.out.println("Thank you for using Jay’s Car Collection! ");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addVehicle(Collection collection) {

        System.out.print("Enter the plate number: ");
        String plateNumber = scanner.nextLine();
        System.out.print("Enter year of vehicle: ");
        int yearBuilt = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter the model of vehicle: ");
        String model = scanner.nextLine();
        System.out.print("Enter the color: ");
        String exteriorColor = scanner.nextLine();
        System.out.print("Enter the type of vehicle:  ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter the date acquired:  ");
        String dateAcquired = scanner.nextLine();
        System.out.print("Enter the purchase price:  ");
        double cost = scanner.nextDouble();
        System.out.print("Enter the current value:  ");
        double value = scanner.nextDouble();
        System.out.print("Is work needed (yes/no):  ");
        String userInput = scanner.nextLine();
        boolean workNeeded = userInput.equals("yes");
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter nature of the work required (enter “none” if none needed): ");
        String workNotes = scanner.nextLine();
        // Instantiate a Vehicle object
        Vehicle vehicle = new Vehicle(plateNumber,yearBuilt, manufacturer, vehicleType, exteriorColor,
                model, dateAcquired, cost, value, workNeeded, workNotes);

        collection.addVehicle(vehicle);



    }


}
