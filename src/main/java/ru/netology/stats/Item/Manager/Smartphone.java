package ru.netology.stats.Item.Manager;

public class Smartphone extends Product {
    private String brand;


    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }


}
