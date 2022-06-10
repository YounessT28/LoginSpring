package eu.ensup.login;

import eu.ensup.dao.ProductRepository;
import eu.ensup.dao.UserRepository;
import eu.ensup.domaine.Product;
import eu.ensup.domaine.User;
import eu.ensup.service.ProductService;
import eu.ensup.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService productService;

    private Product product;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Add a product")
    void testAddProduct() {
        product = new Product("Banane", 1);

        when(productRepository.save(product)).thenReturn(product);

        productService.create(product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    @DisplayName("Get a product")
    void testGetProduct() {
        product = new Product("Banane", 1);

        when(productRepository.findByName(product.getName())).thenReturn(product);

        productService.findUser(product);

        verify(productRepository, times(1)).findByName(product.getName());
    }

    @Test
    @DisplayName("Update a product")
    void testUpdateProduct() {
        product = new Product("Banane", 5);
        int newquantity = 10;

        when(productRepository.save(product)).thenReturn(product);
        when(productRepository.findByName(product.getName())).thenReturn(product);

        productService.update(product, newquantity); // Update product


        verify(productRepository, times(1)).findByName(product.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    @DisplayName("Delete a product")
    void testDeleteProduct() {
        product = new Product("Banane", 5);

        doNothing().when(productRepository).delete(product);

        productService.delete(product);

        verify(productRepository, times(1)).delete(product);
    }
}
