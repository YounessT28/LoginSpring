package eu.ensup.login;

import eu.ensup.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @Test
    public void test_ProducstService() {
        assertTrue(true);
    }
}
