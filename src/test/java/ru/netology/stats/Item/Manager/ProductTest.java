package ru.netology.stats.Item.Manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductTest {
    @Mock
    private Repository repository;
    @InjectMocks
    private ProductManager manager;
    private Book book = new Book(1, "1984", 300, "George Orwell");
    private Smartphone phone = new Smartphone(2, "Galaxy S21", 75000, "Samsung");
    private Smartphone newPhone = new Smartphone(3, "iPhone 12", 60000, "Apple");
    private Product[] returned = new Product[]{book, phone, newPhone};

    @Test
    public void shouldAdd() {

        manager = new ProductManager(new Repository());
        manager.add(book);

        Product[] actual = manager.getRepository().findAll();
        Product[] expected = new Product[]{book};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAndReturnOneProduct() {
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("la");
        Product[] expected = new Product[]{phone};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByAndReturnSeveralProducts() {
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("2");
        Product[] expected = new Product[]{phone, newPhone};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByAndReturnAllProducts() {
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("1");
        Product[] expected = new Product[]{book, phone, newPhone};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldSearchByAndReturnNoProducts() {
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("14");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldMatchesAndReturnTrue() {
        boolean actual = manager.matches(phone, "S21");
        assertTrue(actual);
    }

    @Test
    public void shouldMatchesAndReturnFalse() {
        boolean actual = manager.matches(phone, "S20");
        assertFalse(actual);
    }
}

