package co.edu.uptc.linkedlistworkshop.model;

/**
 * The Moto class represents a motorcycle with various attributes such as
 * id, brand, model, color, year, engine size, and price.
 * This class provides getter and setter methods to access and modify these properties.
 */
public class Moto {
    private int id;
    private String brand;
    private String model;
    private String color;
    private int year;
    private int engineSize;
    private int price;

    /**
     * Constructs a new Moto object with the specified details.
     * @param id the unique identifier for the motorcycle
     * @param brand the brand of the motorcycle
     * @param model the model of the motorcycle
     * @param color the color of the motorcycle
     * @param year the manufacturing year of the motorcycle
     * @param engineSize the engine size of the motorcycle (in cubic centimeters)
     * @param price the price of the motorcycle
     */
    public Moto(int id, String brand, String model, String color, int year, int engineSize, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;
    }

    /**
     * Retrieves the unique identifier of the motorcycle.
     * @return the id of the motorcycle
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the motorcycle.
     * @param id the new id of the motorcycle
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the color of the motorcycle.
     * @return the color of the motorcycle
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the motorcycle.
     * @param color the new color of the motorcycle
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retrieves the brand of the motorcycle.
     * @return the brand of the motorcycle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the motorcycle.
     * @param brand the new brand of the motorcycle
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Retrieves the model of the motorcycle.
     * @return the model of the motorcycle
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the motorcycle.
     * @param model the new model of the motorcycle
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Retrieves the manufacturing year of the motorcycle.
     * @return the year of the motorcycle
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the manufacturing year of the motorcycle.
     * @param year the new year of the motorcycle
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the engine size of the motorcycle.
     * @return the engine size of the motorcycle (in cubic centimeters)
     */
    public int getEngineSize() {
        return engineSize;
    }

    /**
     * Sets the engine size of the motorcycle.
     * @param engineSize the new engine size of the motorcycle
     */
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    /**
     * Retrieves the price of the motorcycle.
     * @return the price of the motorcycle
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the motorcycle.
     * @param price the new price of the motorcycle
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the motorcycle, including its id, brand, model,
     * color, year, engine size, and price.
     * @return a string representing the motorcycle
     */
    @Override
    public String toString() {
        return "Moto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", engineSize=" + engineSize +
                ", price=" + price +
                '}';
    }
}