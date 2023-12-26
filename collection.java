import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Collection {
    // Instance variables
    private Vehicle[] vehicles;
    private int count;


    // Constructor
    public Collection() {
        // Default capacity, you can modify this value
        int defaultCapacity = 11;
        vehicles = new Vehicle[defaultCapacity];
        count = 0;
    }

    // Add a vehicle to the collection only if it's not already in the list
    public void addVehicle(Vehicle vehicle) {
        if (!containsVehicle(vehicle)) {
            if (count < vehicles.length) {
                vehicles[count] = vehicle;
                count++;

            } else {
                System.out.println("Collection is full. Cannot add more vehicles.");
            }
        } else {
            System.out.println("Vehicle is already in the collection. Not added again.");
        }

        System.out.println("Number of vehicles in collection: "+ count);
    }

    // Check if the vehicle is already in the collection
    private boolean containsVehicle(Vehicle vehicle) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].equals(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void  readFile(String fileName){
        try (Scanner input = new Scanner(new File(fileName))){
            while(input.hasNextLine()){
                // Extract plateNumber
                String plateNumber = input.nextLine();
                // Read other data fields
                String[] parts = input.nextLine().split(" ");
                int yearBuilt = Integer.parseInt(parts[0]);
                String manufacturer = parts[1];
                String vehicleType = input.nextLine();
                String exteriorColor = input.nextLine();
                String model = input.nextLine();
                String dateAcquired = input.nextLine();
                double cost = Double.parseDouble(input.nextLine());
                double value = Double.parseDouble(input.nextLine());
                boolean workNeeded = Boolean.parseBoolean(input.nextLine());
                String workNotes = input.nextLine();


                // Create a Vehicle object
                Vehicle vehicle = new Vehicle(plateNumber,yearBuilt, manufacturer, vehicleType, exteriorColor,
                        model, dateAcquired, cost, value, workNeeded, workNotes);

                // Add the vehicle to the collection
                addVehicle(vehicle);


            }


        }
        catch (FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        catch (NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }

    }

    // Method to sort the array of vehicles by plateNumber
    public Vehicle[] sortArray() {
        // Create a copy of the vehicles array to avoid modifying the original array
        Vehicle[] sortedArray = Arrays.copyOf(vehicles, count);

        // Sort the array using a custom comparator based on plateNumber
        Arrays.sort(sortedArray, Comparator.comparing(Vehicle::getPlateNumber));

        return sortedArray;
    }

    // Write the contents of the sorted array to a file
    public void writeFile(String fileName) {
        // Get the sorted array
        Vehicle[] sortedArray = sortArray();
        int index = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write each vehicle's information to the file
            for (int i = 0; i < sortedArray.length; i++) {
                writer.write(sortedArray[i].getPlateNumber() + "\n");
                writer.write(sortedArray[i].getYearBuilt() + " " + sortedArray[i].getManufacturer() + "\n");
                writer.write(sortedArray[i].getVehicleType() + "\n");
                writer.write(sortedArray[i].getExteriorColor() + "\n");
                writer.write(sortedArray[i].getModel() + "\n");
                writer.write(sortedArray[i].getDateAcquired() + "\n");
                writer.write(sortedArray[i].getCost() + "\n");
                writer.write(sortedArray[i].getValue() + "\n");
                writer.write(sortedArray[i].isWorkNeeded() + "\n");
                writer.write(sortedArray[i].getWorkNotes() + "\n");
                index++;
            }
            System.out.println("File writing completed.");
            System.out.println("Vehicles written to the file: "+ index);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to display all vehicles in the collection
    public void displayCollection() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                System.out.println(vehicle);
            }
        }
    }

    // Method to display vehicles that need work
    public void needsWork() {

        int index = 0;
        for (int i = 0; i < count; i++) {
            Vehicle currentVehicle = vehicles[i];
            if (currentVehicle != null) {
                if (currentVehicle.isWorkNeeded()) {
                    System.out.println("Plate Number: "+ currentVehicle.getPlateNumber());
                    System.out.println("Year/Make/Model: "+ currentVehicle.getYearBuilt() +" " +currentVehicle.getManufacturer()+" "+currentVehicle.getModel());
                    System.out.println("Color: "+ currentVehicle.getExteriorColor());
                    System.out.println("Type : "+ currentVehicle.getVehicleType());
                    System.out.println("Date Acquired: "+ currentVehicle.getDateAcquired());
                    System.out.println("Purchase Price: "+ currentVehicle.getCost());
                    System.out.println("Current Value: "+ currentVehicle.getValue());
                    System.out.println("Needs work: "+ currentVehicle.isWorkNeeded());
                    System.out.println("Nature of work needed: "+ currentVehicle.getWorkNotes());
                    index++;
                }
            } else {
                System.out.println("Null vehicle encountered at index " + i);
            }
        }
        System.out.println("Number of vehicles that need work: "+ index );
    }

    public void updateVehicle(String plateNumber) {
        Vehicle currentVehicle = findVehicleByPlateNumber(plateNumber);

        if (currentVehicle != null) {
            Scanner scanner = new Scanner(System.in);
            String choice;

            do {

                System.out.println("Plate Number: "+ currentVehicle.getPlateNumber());
                System.out.println("Year/Make/Model: "+ currentVehicle.getYearBuilt() +" " +currentVehicle.getManufacturer()+" "+currentVehicle.getModel());
                System.out.println("Color: "+ currentVehicle.getExteriorColor());
                System.out.println("Type : "+ currentVehicle.getVehicleType());
                System.out.println("Date Acquired: "+ currentVehicle.getDateAcquired());
                System.out.println("Purchase Price: "+ currentVehicle.getCost());
                System.out.println("Current Value: "+ currentVehicle.getValue());
                System.out.println("Needs work: "+ currentVehicle.isWorkNeeded());
                System.out.println("Nature of work needed: "+ currentVehicle.getWorkNotes());

                System.out.println("\nChoose a field to update:");
                System.out.println("1. Manufacturer");
                System.out.println("2. Vehicle Type");
                System.out.println("3. Exterior Color");
                System.out.println("4. Model");
                System.out.println("5. Date Acquired");
                System.out.println("6. Cost");
                System.out.println("7. Value");
                System.out.println("8. Work Needed");
                System.out.println("9. Work Notes");
                System.out.println("0. Finish updating");

                System.out.print("Enter your choice: ");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Enter new manufacturer: ");
                        currentVehicle.setManufacturer(scanner.nextLine());
                        break;
                    case "2":
                        System.out.print("Enter new vehicle type: ");
                        currentVehicle.setVehicleType(scanner.nextLine());
                        break;
                    case "3":
                        System.out.print("Enter new exterior color: ");
                        currentVehicle.setExteriorColor(scanner.nextLine());
                        break;
                    case "4":
                        System.out.print("Enter new model: ");
                        currentVehicle.setModel(scanner.nextLine());
                        break;
                    case "5":
                        System.out.print("Enter new date acquired: ");
                        currentVehicle.setDateAcquired(scanner.nextLine());
                        break;
                    case "6":
                        System.out.print("Enter new cost: ");
                        currentVehicle.setCost(Double.parseDouble(scanner.nextLine()));
                        break;
                    case "7":
                        System.out.print("Enter new value: ");
                        currentVehicle.setValue(Double.parseDouble(scanner.nextLine()));
                        break;
                    case "8":
                        System.out.print("Enter new work needed (true/false): ");
                        currentVehicle.setWorkNeeded(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case "9":
                        System.out.print("Enter new work notes: ");
                        currentVehicle.setWorkNotes(scanner.nextLine());
                        break;
                    case "0":
                        System.out.println("Finished updating.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (!choice.equals("0"));
        } else {
            System.out.println("Vehicle with plate number " + plateNumber + " not found.");
        }
    }

    private Vehicle findVehicleByPlateNumber(String plateNumber) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(plateNumber)) {
                return vehicles[i];
            }
        }
        return null;
    }

    // Method to display information about a specific vehicle based on plateNumber
    public void displayVehicle(String plateNumber) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (vehicles[i].getPlateNumber().equals(plateNumber)) {

                System.out.println("Plate Number: "+ vehicles[i].getPlateNumber());
                System.out.println("Year/Make/Model: "+ vehicles[i].getYearBuilt() +" " +vehicles[i].getManufacturer()+" "+vehicles[i].getModel());
                System.out.println("Color: "+ vehicles[i].getExteriorColor());
                System.out.println("Type : "+ vehicles[i].getVehicleType());
                System.out.println("Date Acquired: "+ vehicles[i].getDateAcquired());
                System.out.println("Purchase Price: "+ vehicles[i].getCost());
                System.out.println("Current Value: "+ vehicles[i].getValue());
                System.out.println("Needs work: "+ vehicles[i].isWorkNeeded());
                System.out.println("Nature of work needed: "+ vehicles[i].getWorkNotes());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Vehicle with Plate Number " + plateNumber + " not found.");
        }
    }

    public void removeVehicle(String plateNumber) {
        boolean found = false;

        // Create a new array to hold the updated list of vehicles
        Vehicle[] updatedVehicles = new Vehicle[vehicles.length];
        int updatedCount = 0;

        for (int i = 0; i < count; i++) {
            // Check if the current vehicle matches the specified plateNumber
            if (vehicles[i].getPlateNumber().equals(plateNumber)) {
                found = true;

                // Ask for confirmation before removing the vehicle
                if (confirmRemoval()) {
                    // Skip copying this vehicle to the updated array
                    System.out.println("Vehicle " + plateNumber + " Deleted.");
                    count--;
                } else {
                    // Copy the vehicle to the updated array
                    updatedVehicles[updatedCount] = vehicles[i];
                    updatedCount++;
                }
            } else {
                // Copy the current vehicle to the updated array
                updatedVehicles[updatedCount] = vehicles[i];
                updatedCount++;
            }
        }

        // Update the original array with the modified array
        vehicles = Arrays.copyOf(updatedVehicles, updatedCount);

        // Display the number of vehicles in the collection after the operation
        System.out.println("Number of vehicles in collection: " + count);
    }

    private boolean confirmRemoval() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();
        return answer.equals("yes");
    }










}
