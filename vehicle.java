

public class Vehicle {
    // Instance variables
    private String plateNumber;
    private String manufacturer;
    private String vehicleType;
    private int yearBuilt;
    private String model;
    private String exteriorColor;
    private String dateAcquired;
    private double cost;
    private double value;
    private boolean workNeeded;
    private String workNotes;

    // Default constructor
    public Vehicle() {
    }

    // Constructor with all instance variables

    public Vehicle(String plateNumber,int yearBuilt, String manufacturer, String vehicleType, String exteriorColor, String model,
                   String dateAcquired, double cost, double value, boolean workNeeded, String workNotes) {
        this.plateNumber = plateNumber;
        this.manufacturer = manufacturer;
        this.vehicleType = vehicleType;
        this.yearBuilt = yearBuilt;
        this.model = model;
        this.exteriorColor = exteriorColor;
        this.dateAcquired = dateAcquired;
        this.cost = cost;
        this.value = value;
        this.workNeeded = workNeeded;
        this.workNotes = workNotes;
    }


    // Getters and setters
    // Getter and setter for ExteriorColor
    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    // Getter and setter for Cost
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // Getter and setter for WorkNeeded
    public void setWorkNeeded(boolean workNeeded) {
        this.workNeeded = workNeeded;
    }

    public boolean isWorkNeeded() {
        return workNeeded;
    }



    // Getter and setter for WorkNotes
    public String getWorkNotes() {
        return workNotes;
    }

    public void setWorkNotes(String workNotes) {
        this.workNotes = workNotes;
    }
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

   public int getYearBuilt() {
       return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
      this.yearBuilt = yearBuilt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    // ToString method
    @Override
    public String toString() {
        String message = String.format("%-10s%-10d%-10s%-25s%-15s%-10s%-15s\n",
                plateNumber,yearBuilt,  manufacturer, model, vehicleType," ", dateAcquired);
        return message;
    }






}
