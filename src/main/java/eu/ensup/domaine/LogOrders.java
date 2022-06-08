package eu.ensup.domaine;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LogOrders {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private int orderid;
    private int userid;

    public LogOrders(int orderid, int userid) {
        this.orderid = orderid;
        this.userid = userid;
    }

    public LogOrders(){}
}
