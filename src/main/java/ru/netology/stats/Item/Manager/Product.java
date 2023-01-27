package ru.netology.stats.Item.Manager;


public class Product {
    protected int id;
    protected String name;
    protected int price;

    public String getName() {
        return name;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }


}
