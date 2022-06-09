package eu.ensup.service;

import eu.ensup.dao.LogOrderRepository;
import eu.ensup.domaine.LogOrders;
import eu.ensup.domaine.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogOrdersService {

    @Autowired
    private LogOrderRepository logOrderRepository;

    public LogOrdersService(LogOrderRepository logOrderRepository) {
        this.logOrderRepository = logOrderRepository;
    }

    public void create(LogOrders logOrders){
        this.logOrderRepository.save(logOrders);
    }

    // Get product
    public LogOrders findLogOrder(LogOrders logorder){
        return this.logOrderRepository.findByUserid(logorder.getUserid());
    }

    // Save product
    public void update(LogOrders logorder, int neworderid){

        LogOrders o = this.logOrderRepository.findByUserid(logorder.getUserid());
        o.setOrderid(neworderid);
        this.logOrderRepository.save(o);
    }

    public void delete(LogOrders logorder){
        this.logOrderRepository.delete(logorder);
    }
}
