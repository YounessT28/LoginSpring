package eu.ensup.service;

import eu.ensup.dao.OrdersRepository;
import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Orders;
import eu.ensup.domaine.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) { this.ordersRepository = ordersRepository; }

    // Save product
    public void create(Orders order){
        this.ordersRepository.save(order);
    }

    // Get product
    public Orders findUser(Orders order){
        return this.ordersRepository.findByProductid(order.getProductid());
    }

    // Save product
    public void update(Orders order, int newquantity){

        Orders o = this.ordersRepository.findByProductid(order.getProductid());
        o.setQuantity(newquantity);
        this.ordersRepository.save(o);
    }

    public void delete(Orders order){
        this.ordersRepository.delete(order);
    }
}
