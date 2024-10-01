package co.edu.uptc.linkedlistworkshop.controller;

import co.edu.uptc.linkedlistworkshop.model.Moto;
import java.util.ArrayList;

public class ListManagement {

    private LinkedList <Moto> motoList;

    public ListManagement() {
        motoList = new LinkedList<>();
        addNodeSorted(1, "brand", "asdf", "res", 2002, 33, 333333);
        addNodeSorted(2, "brand", "asdf", "res", 2002, 22, 222222);
    }

    public boolean isEmpty() {
        return motoList.isEmpty();
    }

    public boolean addNodeFirst(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeFirst(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addNodeLast(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeLast(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addNodeAfterTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeAfterTo(currentId, newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addNodeBeforeTo(int currentId, int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeBeforeTo(currentId, newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addNodeSorted(int id, String brand, String model, String color, int year, int engineSize, int price) {
        try {
            Moto newMoto = new Moto(id, brand, model, color, year, engineSize, price);
            motoList.addNodeSorted(newMoto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Node<Moto> findNode(int id) {
        return motoList.findNode(id);
    }

    public ArrayList<Moto> getLinkedList(boolean order){
        return motoList.getLinkedList(order);
    }

    public String deleteNode(int id) {
        return motoList.deleteNode(id).toString();
    }

    public int getSize(){
        return motoList.getSize();
    }

    public Moto getFist() {
        return motoList.getFist().getInfo();
    }

    public Moto getLast() {
        return motoList.getLast().getInfo();
    }

    public boolean priceValidation(int price) {
        return price >= 2000000 && price <= 160000000;
    }

    public boolean engineValidation(int engine){
        return engine >= 50 && engine <= 1200;
    }

    public boolean idValidation(int id){
        return id >= 0;
    }

    public int isNumericInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
