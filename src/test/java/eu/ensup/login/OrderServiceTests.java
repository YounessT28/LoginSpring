package eu.ensup.login;

import eu.ensup.dao.OrdersRepository;
import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Orders;
import eu.ensup.domaine.Product;
import eu.ensup.service.OrderService;
import eu.ensup.service.ProductService;
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
public class OrderServiceTests {
    @InjectMocks
    private OrderService orderService;

    private Orders order;

    @Mock
    private OrdersRepository ordersRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Add an order")
    void testAddOrder() {
        order = new Orders(1, 1);

        when(ordersRepository.save(order)).thenReturn(order);

        orderService.create(order);

        verify(ordersRepository, times(1)).save(order);
    }

    @Test
    @DisplayName("Get an order")
    void testGetOrder() {
        order = new Orders(1, 1);

        when(ordersRepository.findByProductid(order.getProductid())).thenReturn(order);

        orderService.findUser(order);

        verify(ordersRepository, times(1)).findByProductid(order.getProductid());
    }

    @Test
    @DisplayName("Update an order")
    void testUpdateOrder() {
        order = new Orders(1, 1);
        int newquantity = 10;

        when(ordersRepository.save(order)).thenReturn(order);
        when(ordersRepository.findByProductid(order.getProductid())).thenReturn(order);

        orderService.update(order, newquantity); // Update product


        verify(ordersRepository, times(1)).findByProductid(order.getProductid());
        verify(ordersRepository, times(1)).save(order);
    }

    @Test
    @DisplayName("Delete an order")
    void testDeleteOrder() {
        order = new Orders(1, 1);

        doNothing().when(ordersRepository).delete(order);

        orderService.delete(order);

        verify(ordersRepository, times(1)).delete(order);
    }
}
