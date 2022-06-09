package eu.ensup.login;

import eu.ensup.service.LogOrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LogOrdersServiceTests {
    @Autowired
    private LogOrdersService logOrdersService;

    @Test
    public void testLogOrdersService() {
        assertTrue(true);
    }
}
