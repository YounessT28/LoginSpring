package eu.ensup.login;

import eu.ensup.dao.LogOrderRepository;
import eu.ensup.dao.OrdersRepository;
import eu.ensup.domaine.LogOrders;
import eu.ensup.domaine.Orders;
import eu.ensup.service.LogOrdersService;
import eu.ensup.service.LogOrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LogOrdersServiceTests {
    @InjectMocks
    private LogOrdersService LogOrdersService;

    private LogOrders logOrders;

    @Mock
    private LogOrderRepository logOrderRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Add a log order")
    void testAddLogOrder() {
        logOrders = new LogOrders(1, 1);

        when(logOrderRepository.save(logOrders)).thenReturn(logOrders);

        LogOrdersService.create(logOrders);

        verify(logOrderRepository, times(1)).save(logOrders);
    }

    @Test
    @DisplayName("Get a log order")
    void testGetLogOrder() {
        logOrders = new LogOrders(1, 1);

        when(logOrderRepository.findByUserid(logOrders.getUserid())).thenReturn(logOrders);

        LogOrdersService.findLogOrder(logOrders);

        verify(logOrderRepository, times(1)).findByUserid(logOrders.getUserid());
    }

    @Test
    @DisplayName("Update a log order")
    void testUpdateLogOrder() {
        logOrders = new LogOrders(1, 1);
        int neworderid = 10;

        when(logOrderRepository.save(logOrders)).thenReturn(logOrders);
        when(logOrderRepository.findByUserid(logOrders.getUserid())).thenReturn(logOrders);

        LogOrdersService.update(logOrders, neworderid); // Update product


        verify(logOrderRepository, times(1)).findByUserid(logOrders.getUserid());
        verify(logOrderRepository, times(1)).save(logOrders);
    }

    @Test
    @DisplayName("Delete a log order")
    void testDeleteLogOrder() {
        logOrders = new LogOrders(1, 1);

        doNothing().when(logOrderRepository).delete(logOrders);

        LogOrdersService.delete(logOrders);

        verify(logOrderRepository, times(1)).delete(logOrders);
    }
}
