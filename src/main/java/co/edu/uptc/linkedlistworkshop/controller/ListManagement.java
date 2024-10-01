package co.edu.uptc.linkedlistworkshop.controller;

import co.edu.uptc.linkedlistworkshop.model.Moto;
import java.util.ArrayList;

/**
 * This class manages a linked list of Moto objects, providing methods to manipulate
 * the list such as adding, deleting, and searching for nodes.
 */
public class ListManagement {

    private LinkedList <Moto> motoList;

    /**
     * Constructor for ListManagement.
     * Initializes an empty linked list for storing Moto objects.
     */
    public ListManagement() {
        motoList = new LinkedList<>();
    }

    /**
     * Checks if the moto list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return motoList.isEmpty();
    }

    /**
     * Adds a new Moto node at the beginning of the linked list.
     * @param id the id of the Moto.
     * @param brand the brand of the Moto.
     * @param model the model of the Moto.
     * @param color the color of the Moto.
     * @param year the year of the Moto.
     * @param engineSize the engine size of the Moto.
     * @param price the price of the Moto.
     * @return true if the Moto was successfully added, false otherwise.
     */
    public boolean addNodeFirst(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeFirst(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds a new Moto node at the end of the linked list.
     * @param id the id of the Moto.
     * @param brand the brand of the Moto.
     * @param model the model of the Moto.
     * @param color the color of the Moto.
     * @param year the year of the Moto.
     * @param engineSize the engine size of the Moto.
     * @param price the price of the Moto.
     * @return true if the Moto was successfully added, false otherwise.
     */
    public boolean addNodeLast(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeLast(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds a new Moto node after an existing node with the specified currentId.
     * @param currentId the id of the Moto node after which to add the new Moto.
     * @param id the id of the new Moto.
     * @param brand the brand of the new Moto.
     * @param model the model of the new Moto.
     * @param color the color of the new Moto.
     * @param year the year of the new Moto.
     * @param engineSize the engine size of the new Moto.
     * @param price the price of the new Moto.
     * @return true if the Moto was successfully added, false otherwise.
     */
    public boolean addNodeAfterTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeAfterTo(currentId, newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds a new Moto node before an existing node with the specified currentId.
     * @param currentId the id of the Moto node before which to add the new Moto.
     * @param id the id of the new Moto.
     * @param brand the brand of the new Moto.
     * @param model the model of the new Moto.
     * @param color the color of the new Moto.
     * @param year the year of the new Moto.
     * @param engineSize the engine size of the new Moto.
     * @param price the price of the new Moto.
     * @return true if the Moto was successfully added, false otherwise.
     */
    public boolean addNodeBeforeTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeBeforeTo(currentId, newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds a new Moto node in a sorted manner.
     * @param id the id of the new Moto.
     * @param brand the brand of the new Moto.
     * @param model the model of the new Moto.
     * @param color the color of the new Moto.
     * @param year the year of the new Moto.
     * @param engineSize the engine size of the new Moto.
     * @param price the price of the new Moto.
     * @return true if the Moto was successfully added, false otherwise.
     */
    public boolean addNodeSorted(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeSorted(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Finds and returns the Moto node with the specified id.
     * @param id the id of the Moto to find.
     * @return the node containing the Moto, or null if not found.
     */
    public Node<Moto> findNode(int id) {
        return motoList.findNode(id);
    }

    /**
     * Returns an ArrayList containing all the Moto objects in the linked list.
     * @param order true if the list should be ordered from first to last, false if in reverse.
     * @return an ArrayList of Moto objects.
     */
    public ArrayList<Moto> getLinkedList(boolean order){
        return motoList.getLinkedList(order);
    }

    /**
     * Deletes the Moto node with the specified id and returns its string representation.
     * @param id the id of the Moto to delete.
     * @return the string representation of the deleted Moto, or null if not found.
     */
    public String deleteNode(int id) {
        return motoList.deleteNode(id).toString();
    }

    /**
     * Returns the size of the moto list (number of nodes).
     * @return the number of nodes in the moto list.
     */
    public int getSize(){
        return motoList.getSize();
    }

    /**
     * Returns the first Moto in the linked list.
     * @return the first Moto object.
     */
    public Moto getFist() {
        return motoList.getFist().getInfo();
    }

    /**
     * Returns the last Moto in the linked list.
     * @return the last Moto object.
     */
    public Moto getLast() {
        return motoList.getLast().getInfo();
    }

    /**
     * Validates if the price is within a valid range.
     * @param price the price to validate.
     * @return true if the price is between 2,000,000 and 160,000,000, false otherwise.
     */
    public boolean priceValidation(int price) {
        return price >= 2000000 && price <= 160000000;
    }

    /**
     * Validates if the engine size is within a valid range.
     * @param engine the engine size to validate.
     * @return true if the engine size is between 50 and 1200 cc, false otherwise.
     */
    public boolean engineValidation(int engine){
        return engine >= 50 && engine <= 1200;
    }

    /**
     * Validates if the id is a non-negative integer.
     * @param id the id to validate.
     * @return true if the id is greater than or equal to 0, false otherwise.
     */
    public boolean idValidation(int id){
        return id >= 0;
    }

    /**
     * Converts the given string to an integer, or returns -1 if the string is not a valid number.
     * @param str the string to convert.
     * @return the integer value of the string, or -1 if invalid.
     */
    public int isNumericInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}