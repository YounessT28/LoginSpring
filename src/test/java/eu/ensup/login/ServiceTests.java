package eu.ensup.login;

import eu.ensup.service.LogOrdersService;
import eu.ensup.service.OrderService;
import eu.ensup.service.ProductService;
import eu.ensup.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

//    @Autowired
//    private OrderService orderService;

//    @Autowired
//    private LogOrdersService logOrdersService;

    @Test
    public void test_JUnit() {
        assertTrue(true);
    }

}