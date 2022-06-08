package eu.ensup.dao;

import eu.ensup.domaine.LogOrders;
import eu.ensup.domaine.Orders;
import org.springframework.data.jpa.repository.JpaRepository;





public interface LogOrderRepository extends JpaRepository<LogOrders, Integer> {
    LogOrders findByIdUser(int id);
}
