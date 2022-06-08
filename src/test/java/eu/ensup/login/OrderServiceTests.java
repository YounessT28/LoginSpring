package eu.ensup.login;

import eu.ensup.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void test_OrderService() {
        assertTrue(true);
    }
}
