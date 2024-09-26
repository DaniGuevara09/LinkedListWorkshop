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
    private double price;

    public Moto(int id, String brand, String model, String color, int year, int engineSize, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;
    }
}
