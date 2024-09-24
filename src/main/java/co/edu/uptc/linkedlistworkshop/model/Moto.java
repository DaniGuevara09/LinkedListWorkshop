package co.edu.uptc.linkedlistworkshop.model;

/**
 * The Moto class represents a motorcycle with basic properties such as
 * brand, model, color, year, and price.
 */
public class Moto {
    private int id;
    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;

    /**
     * Constructor for the Moto class.
     *
     * @param brand Brand of the motorcycle.
     * @param model Model of the motorcycle.
     * @param color Color of the motorcycle.
     * @param year Year of manufacture of the motorcycle.
     * @param price Price of the motorcycle.
     */
    public Moto(String brand, String model, String color, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}
