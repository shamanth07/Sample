package sam;

import java.util.Scanner;

class Computer {
    String brand;
    String model;
    private long SN;
    double price;
    private static int numberOfCreatedComputers = 0;
    
    public Computer(String brand, String model, long SN, double price) {
        this.brand = brand;
        this.model = model;
        this.SN = SN;
        this.price = price;
        numberOfCreatedComputers++;
    }

    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public long getSN() {
        return SN;
    }
    
    public void setSN(long SN) {
        this.SN = SN;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // toString method to display computer information
    @Override
    public String toString() {
        return "Brand: " + brand + "\nModel: " + model + "\nSN: " + SN + "\nPrice: $" + price;
    }
    
    // Static method to get the number of created computers
    public static int findNumberOfCreatedComputers() {
        return numberOfCreatedComputers;
    }
    
    // Equals method to compare two computers for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Computer computer = (Computer) obj;
        return SN == computer.SN &&
               Double.compare(computer.price, price) == 0 &&
               brand.equals(computer.brand) &&
               model.equals(computer.model);
    }
}

   class ComputerStore {
    private static final String PASSWORD = "password";
    private static final int MAX_COMPUTERS = 100; // Adjust this based on your requirements
    private static Computer[] inventory = new Computer[MAX_COMPUTERS];
    private static int numComputers = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        System.out.println("Welcome to the Computer Store!");
        
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Computers");
            System.out.println("2. Update Computer");
            System.out.println("3. Find Computers by Brand");
            System.out.println("4. Find Computers Cheaper Than");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addComputers(scanner);
                    break;
                case 2:
                    updateComputer(scanner);
                    break;
                case 3:
                    findComputersByBrand(scanner);
                    break;
                case 4:
                    findComputersCheaperThan(scanner);
                    break;
                case 5:
                    System.out.println("Closing the Computer Store. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
    
    private static void addComputers(Scanner scanner) {
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();
        
        if (password.equals(PASSWORD)) {
            System.out.print("How many computers do you want to add? ");
            int numToAdd = scanner.nextInt();
            
            if (numToAdd + numComputers <= MAX_COMPUTERS) {
                for (int i = 0; i < numToAdd; i++) {
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter details for Computer #" + (i + 1));
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Serial Number: ");
                    long sn = scanner.nextLong();
                    System.out.print("Price: $");
                    double price = scanner.nextDouble();
                    
                    inventory[numComputers++] = new Computer(brand, model, sn, price);
                }
                
                System.out.println(numToAdd + " computers added successfully.");
            } else {
                System.out.println("There is not enough space in the inventory.");
            }
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }
    
    private static void updateComputer(Scanner scanner) {
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();
        
        if (password.equals(PASSWORD)) {
            System.out.print("Enter the computer number to update (1-" + numComputers + "): ");
            int computerNumber = scanner.nextInt();
            
            if (computerNumber >= 1 && computerNumber <= numComputers) {
                Computer computer = inventory[computerNumber - 1];
                System.out.println("Current information for Computer #" + computerNumber);
                System.out.println(computer);
                
                int attributeChoice;
                do {
                    System.out.println("\nChoose an attribute to change:");
                    System.out.println("1. Brand");
                    System.out.println("2. Model");
                    System.out.println("3. Serial Number");
                    System.out.println("4. Price");
                    System.out.println("5. Done");
                    System.out.print("Enter your choice (1-5): ");
                    
                    attributeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    switch (attributeChoice) {
                        case 1:
                            System.out.print("Enter new brand: ");
                            String newBrand = scanner.nextLine();
                            computer.setBrand(newBrand);
                            break;
                        case 2:
                            System.out.print("Enter new model: ");
                            String newModel = scanner.nextLine();
                            computer.setModel(newModel);
                            break;
                        case 3:
                            System.out.print("Enter new serial number: ");
                            long newSN = scanner.nextLong();
                            computer.setSN(newSN);
                            break;
                        case 4:
                            System.out.print("Enter new price: $");
                            double newPrice = scanner.nextDouble();
                            computer.setPrice(newPrice);
                            break;
                        case 5:
                            System.out.println("Changes saved.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                    
                    System.out.println("Updated information for Computer #" + computerNumber);
                    System.out.println(computer);
                    
                } while (attributeChoice != 5);
            } else {
                System.out.println("Invalid computer number. Please enter a number between 1 and " + numComputers + ".");
            }
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }
    
    private static void findComputersByBrand(Scanner scanner) {
        System.out.print("Enter the brand name to search for: ");
        String searchBrand = scanner.nextLine();
        
        System.out.println("Computers with brand '" + searchBrand + "':");
        for (int i = 0; i < numComputers; i++) {
            Computer computer = inventory[i];
            if (computer.getBrand().equalsIgnoreCase(searchBrand)) {
                System.out.println("Computer #" + (i + 1));
                System.out.println(computer);
            }
        }
    }
    
    private static void findComputersCheaperThan(Scanner scanner) {
        System.out.print("Enter the maximum price to search for: $");
        double maxPrice = scanner.nextDouble();
        
        System.out.println("Computers with a price less than $" + maxPrice + ":");
        for (int i = 0; i < numComputers; i++) {
            Computer computer = inventory[i];
            if (computer.getPrice() < maxPrice) {
                System.out.println("Computer #" + (i + 1));
                System.out.println(computer);
            }
        }
    }
}
