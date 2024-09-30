package co.edu.uptc.linkedlistworkshop.model;

/**
 * The Moto class represents a motorcycle with basic properties such as
 * brand, model, color, year, engine size, weight and price.
 */
public class Moto {
    private int id;
    private String brand;
    private String model;
    private String color;
    private int year;
    private int engineSize;
    private int price;

    public Moto(int id, String brand, String model, String color, int year, int engineSize, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
