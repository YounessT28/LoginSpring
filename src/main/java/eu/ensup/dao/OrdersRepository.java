package eu.ensup.dao;

import eu.ensup.domaine.Orders;
import eu.ensup.domaine.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    Orders findByProductid(int id);
}
