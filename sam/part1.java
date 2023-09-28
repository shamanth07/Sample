package sam;

import java.util.Objects;

public class part1 {

	private String brand;
    private String model;
    private long sn;
    private double price;
    
    private static int numberOfCreatedComputers = 0;
    public void Computer(String brand, String model, long sn, double price) {
        this.brand = brand;
        this.model = model;
        this.sn = sn;
        this.price = price;
        numberOfCreatedComputers++;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public long getSN() {
        return sn;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSN(long sn) {
        this.sn = sn;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String toString() {
        return "Brand: " + brand + "\nModel: " + model + "\nSerial Number: " + sn + "\nPrice: " + price;
    }

    public static int findNumberOfCreatedComputers() {
        return numberOfCreatedComputers;
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Computer otherComputer = (Computer) obj;
        return brand.equals(otherComputer.brand) && model.equals(otherComputer.model) && Double.compare(otherComputer.price, price) == 0;
    }

    public int hashCode() {
        return Objects.hash(brand, model, price);
    }
}

