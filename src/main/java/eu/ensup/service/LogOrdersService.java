package eu.ensup.service;

import eu.ensup.dao.LogOrderRepository;
import eu.ensup.domaine.LogOrders;
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
}
