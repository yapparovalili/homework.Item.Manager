package ru.netology.stats.Item.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {



    @Test

    public void testRemoveCorrectId(){
        Repository repo = new Repository();

        Book book1 = new Book(1, "Идиот", 1000, "Ф.М.Достоевский");
        Book book2 = new Book(2, "HARRY POTTER", 2000, "J. K. ROWLING");
        Book book3 = new Book(3, "HARRY POTTER1", 1000, "J. K. ROWLING");
        Smartphone phone = new Smartphone(4, "iPhone 14", 5000, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone);
        repo.removeByID(book2.id);

        Product[] expected = {book1, book3, phone};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);



    }




}
