package co.edu.uptc.linkedlistworkshop.controller;

import co.edu.uptc.linkedlistworkshop.model.Moto;
import java.util.ArrayList;

public class ListManagement {

    public boolean isEmpty() {
        return true;
    }

    public void addNodeFirst(int id, String brand, String model, String color, int year, int engineSize, double price) {

    }

    public void addNodeLast(int id, String brand, String model, String color, int year, int engineSize, double price) {

    }

    public void addNodeAfterTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, double price) {
    }

    public void addNodeBeforeTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, double price) {

    }

    public void addNodeSorted(int id, String brand, String model, String color, int year, int engineSize, double price) {

    }

    public boolean findNode(int id) {
        return true;
    }

    public ArrayList<String> getLinkedList(boolean order){
        return null;
    }

    public String deleteNode(int id) {
        return "";
    }

    public int getSize(){
        return 0;
    }

    public String getFist() {
        return "";
    }

    public String getLast() {
        return "";
    }

    public void sortLinkedList(){

    }

    public int getNodeId(int id, String brand, String model, String color, int year, int engineSize, double price) {
        return -1;
    }

    public boolean priceValidation(double price) {
        return price >= 2000000 && price <= 160000000;
    }

    public boolean engineValidation(int engine){
        return engine >= 50 && engine <= 1200;
    }

    public int isNumericInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
