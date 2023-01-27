package ru.netology.stats.Item.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {


    @Test

    public void searchTestWhenFewProductFound(){
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Идиот", 1000, "Ф.М.Достоевский");
        Book book2 = new Book(2, "HARRY POTTER 1", 2000, "J. K. ROWLING");
        Book book3 = new Book(3, "HARRY POTTER 2", 1000, "J. K. ROWLING");
        Smartphone phone = new Smartphone(4, "iPhone 14", 5000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone);

        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("HARRY");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchTestWhenOneProductFound(){
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Smartphone phone = new Smartphone(4, "iPhone 14", 5000, "Apple");

        manager.add(phone);

        Product[] expected = {phone};
        Product[] actual = manager.searchBy("iPhone 14");

        Assertions.assertArrayEquals(expected, actual);


    }




}
