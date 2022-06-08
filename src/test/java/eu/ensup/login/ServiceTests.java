package eu.ensup.login;

import eu.ensup.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void test_JUnit() {
        assertTrue(true);
    }

}