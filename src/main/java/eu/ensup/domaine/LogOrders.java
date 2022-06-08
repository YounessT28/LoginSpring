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
    private int order_id;
    private int user_id;

    public LogOrders(int order_id, int user_id) {
        this.order_id = order_id;
        this.user_id = user_id;
    }

    public LogOrders(){}
}
